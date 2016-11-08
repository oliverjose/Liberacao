package br.com.gruposhark.liberacao;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Celular;
import model.Dinamica;
import model.Usuario;
import util.Converte;
import util.SoapSerEnv;

public class SHK01LoginActivity extends AppCompatActivity {

    ArrayList<Celular> celulars;
    ArrayList<Usuario>usuarios;
    Celular celular;
    Usuario usuario;

    EditText editTextSHK01Login;
    EditText editTextSHK01Senha;
    Button buttonSHK01Entrar;
    ProgressBar progressBarSHK01;

    private String respErro = null;
    private String imei;
    private String imsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shk01_login);
        Log.e("SHK01LoginActivity -> ", "onCreate");


        editTextSHK01Login = (EditText) findViewById(R.id.editTextSHK01Login);
        editTextSHK01Senha = (EditText) findViewById(R.id.editTextSHK01Senha);
        buttonSHK01Entrar  = (Button)   findViewById(R.id.buttonSHK01Entrar);
        progressBarSHK01   = (ProgressBar) findViewById(R.id.progressBarSHK01);
        progressBarSHK01.setVisibility(View.GONE);

        usuarios = new ArrayList<Usuario>();

        Intent it = getIntent();
        celulars = it.getParcelableArrayListExtra("CELULAR");
        imei = (String.valueOf(celulars.get(0).getImei()));
        imsi = (String.valueOf(celulars.get(0).getImsi()));

    }

    public void menu_onClick(View view) {
        Log.e("SHK01LoginActivity -> ", "menu_onClick");

        final Converte converteSenha = new Converte();

        try {
            String usuario = editTextSHK01Login.getText().toString();
            String senha = converteSenha.convertPasswordToMD5(editTextSHK01Senha.getText().toString());
            imei = (String.valueOf(celulars.get(0).getImei()));


            progressBarSHK01.setVisibility(View.VISIBLE);
            WebService webService01000 = new WebService();
            webService01000.execute(usuario, senha, imei);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class WebService extends AsyncTask<String, Object, String> {

        //private final String NAMESPACE = "http://177.11.31.87:23973/";
        private final String NAMESPACE = "http://10.1.17.100:8013/";
        private final String SOAP_SERVICE = "ws/WSMOBILE01000.apw";
        private final String URL = NAMESPACE + SOAP_SERVICE;
        private final String METHOD = "SMOBA01001";
        private final String SOAP_ACTION = NAMESPACE + METHOD;

        private SoapObject request = null;
        private SoapObject results = null;
        private SoapObject response = null;
        private SoapObject liberacao = null;
        private SoapObject libera = null;
        private SoapSerEnv envelope = null;
        private HttpTransportSE androidHttpTransport = null;
        boolean erro = false;
        public WebService() {

        }

        @Override
        protected String doInBackground(String... params) {
            Log.e("SHK01LoginActivity/WebService -> ", "doInBackground");

            try {
                getSMOBA01000(params[0], params[1], params[2]);
                //Atualiza a interface através do onProgressUpdate
            } catch (Exception e) {
                e.printStackTrace();
                //enviarErro(respErro);
            }
            return null; //

        }
        @Override
        protected void onPreExecute() {
            Log.e("SHK01LoginActivity/WebService -> ", "onPreExecute");

            Context contexto = getApplicationContext();
            String texto = "Conectando ao Servidor";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();

        }

        @Override
        protected void onPostExecute(String strings) {
            Log.e("SHK01LoginActivity/WebService -> ", "onPostExecute");
            progressBarSHK01.setVisibility(View.GONE);
            if (erro == false){
                Context contexto = getApplicationContext();
                String texto = "Conectado";
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, texto,duracao);
                toast.show();
                Intent intentSHK02 = new Intent(SHK01LoginActivity.this, SHK02MenuActivity.class);
                intentSHK02.putParcelableArrayListExtra("CELULAR", celulars);
                intentSHK02.putParcelableArrayListExtra("USUARIO", usuarios);
                startActivity(intentSHK02);
                finish();
            }else {
                enviarErro(respErro);
            }
        }

        private void getSMOBA01000(String _usuario, String _senha, String _imei){
            Log.e("SHK01LoginActivity/WebService -> ", "getSMOBA01000");

            request = new SoapObject(NAMESPACE, METHOD);
            envelope = new SoapSerEnv(SoapEnvelope.VER11);
            androidHttpTransport = new HttpTransportSE(URL);

            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            request.addProperty("_CLOGIN", _usuario);
            request.addProperty("_CMD5", _senha);
            request.addProperty("_CIMEI", _imei);



            try {
                androidHttpTransport.getServiceConnection().setRequestProperty("Connection", "close");
                System.setProperty("http.keepAlive", "false");

                androidHttpTransport.call(SOAP_ACTION, envelope);

                results = (SoapObject) envelope.bodyIn;
                response = (SoapObject) envelope.getResponse();
                liberacao = (SoapObject) results.getProperty(0);

                for (int i = 0; i < liberacao.getPropertyCount(); i++) {
                    libera = (SoapObject) liberacao.getProperty(i);
                    Log.d("CONEXAO_WS_EFETUADA: ", response.toString());
                    libera.getProperty(i).toString();

                    usuario = new Usuario(
                            libera.getProperty(2).toString(), // IdUser 2
                            libera.getProperty(3).toString(), // Login 3
                            libera.getProperty(4).toString(), // Nome 4
                            libera.getProperty(1).toString(), // Email 1
                            libera.getProperty(5).toString(), // Tema 5
                            libera.getProperty(0).toString()  // Conexao 0
                    );
                    usuarios.add(usuario);
                }
                Log.v("DADOS_WS_CAPTURADO ", response.toString());
            }
            catch(Exception e){
                Log.e("SHK01LoginActivity/WebService -> ", "Error on soapObjectData() " + e.getMessage());
                if(envelope.bodyIn != null){
                    respErro = envelope.bodyIn.toString();
                }else {
                    Class c = e.getClass();
                    respErro = c.getName();
                }
                erro = true;//1

            }
            // 2
        }
    }
    public void enviarErro(String _erro){
        String erro = _erro;
        respErro = null;
        Intent intentSHK99 = new Intent(SHK01LoginActivity.this, SHK99ErroActivity.class);
        intentSHK99.putExtra("ERRO", erro);
        startActivity(intentSHK99);
    }

}
