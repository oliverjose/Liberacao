package br.com.gruposhark.liberacao;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import adapter.SHK02MennuAdapter;
import model.Celular;
import model.Mennu;
import model.Usuario;
import util.SoapSerEnv;

public class SHK02MenuActivity extends AppCompatActivity {

    ArrayList<Celular> celulars;
    ArrayList<Usuario>usuarios;
    ArrayList<Mennu>mennus;
    Mennu mennu;
    SHK02MennuAdapter adapter;

    ListView listViewSHK02Menu;
    Button buttonSHK02Sair;
    ProgressBar progressBarSHK02;
    ImageView imageViewSHK02Grupo;
    TextView textViewSHK02Menu;
    TextView textViewSHK02GrupoShark;

    private String conexao;
    private String respErro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shk02_menu);
        Log.e("SHK02MenuActivity -> ", "onCreate");


        listViewSHK02Menu = (ListView) findViewById(R.id.listViewSHK02Menu);
        buttonSHK02Sair = (Button) findViewById(R.id.buttonSHK02Sair);
        progressBarSHK02   = (ProgressBar) findViewById(R.id.progressBarSHK02);
        progressBarSHK02.setVisibility(View.GONE);
        imageViewSHK02Grupo = (ImageView) findViewById(R.id.imageViewSHK02Grupo);
        textViewSHK02Menu = (TextView) findViewById(R.id.textViewSHK02Menu);
        textViewSHK02GrupoShark = (TextView) findViewById(R.id.textViewSHK02GrupoShark);

        Intent it = getIntent();
        celulars = it.getParcelableArrayListExtra("CELULAR");
        usuarios = it.getParcelableArrayListExtra("USUARIO");

        String empresa = usuarios.get(0).getEmpresa();

        switch (empresa) {
            case "C":
                imageViewSHK02Grupo.setImageResource(R.drawable.agricase);
                textViewSHK02Menu.setTextColor(Color.parseColor("#FFC6142F"));
                textViewSHK02GrupoShark.setTextColor(Color.parseColor("#FFC6142F"));
                textViewSHK02GrupoShark.setText("Agricase");
                buttonSHK02Sair.setBackgroundColor(Color.parseColor("#FFC6142F"));


                //FFC6142F
                //textViewSHK02Grupo.setText("AGRICASE");
                break;
            case "D":
                imageViewSHK02Grupo.setImageResource(R.drawable.dismamassy);
                textViewSHK02Menu.setTextColor(Color.parseColor("#FFED4F54"));
                textViewSHK02GrupoShark.setTextColor(Color.parseColor("#FFED4F54"));
                textViewSHK02GrupoShark.setText("Disma Tratores");
                buttonSHK02Sair.setBackgroundColor(Color.parseColor("#FFED4F54"));
                //textViewSHK02Grupo.setText("DISMA");
                break;
            case "E":
                imageViewSHK02Grupo.setImageResource(R.drawable.equagrilagriculture);
                textViewSHK02Menu.setTextColor(Color.parseColor("#FF034581"));
                textViewSHK02GrupoShark.setTextColor(Color.parseColor("#FF034581"));
                textViewSHK02GrupoShark.setText("Equagril");
                buttonSHK02Sair.setBackgroundColor(Color.parseColor("#FFF6C331"));
                break;
            case "M":
                imageViewSHK02Grupo.setImageResource(R.drawable.sharkmaquinascons);
                textViewSHK02Menu.setTextColor(Color.parseColor("#FF020302"));
                textViewSHK02GrupoShark.setTextColor(Color.parseColor("#FF020302"));
                textViewSHK02GrupoShark.setText("Shark Maquinas");
                buttonSHK02Sair.setBackgroundColor(Color.parseColor("#FF020302"));
                break;
            case "N":
                imageViewSHK02Grupo.setImageResource(R.drawable.equagrilagriculture);
                textViewSHK02Menu.setTextColor(Color.parseColor("#FF034581"));
                textViewSHK02GrupoShark.setTextColor(Color.parseColor("#FF034581"));
                textViewSHK02GrupoShark.setText("Nova Holanda");
                buttonSHK02Sair.setBackgroundColor(Color.parseColor("#FF034581"));
                break;
            case "V":
                imageViewSHK02Grupo.setImageResource(R.drawable.valtra);
                textViewSHK02Menu.setTextColor(Color.parseColor("#FFA40202"));
                textViewSHK02GrupoShark.setTextColor(Color.parseColor("#FFA40202"));
                textViewSHK02GrupoShark.setText("Valtra");
                buttonSHK02Sair.setBackgroundColor(Color.parseColor("#FFA40202"));
                break;
            case "X":
                imageViewSHK02Grupo.setImageResource(R.drawable.sharktratores);
                textViewSHK02Menu.setTextColor(Color.parseColor("#FF024D97"));
                textViewSHK02GrupoShark.setTextColor(Color.parseColor("#FF024D97"));
                textViewSHK02GrupoShark.setText("Shark Tratores");
                buttonSHK02Sair.setBackgroundColor(Color.parseColor("#FF024D97"));
                break;
        }
        conexao = usuarios.get(0).getConexao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SHK02MenuActivity -> ", "onResume");
        progressBarSHK02.setVisibility(View.GONE);
        WebService webService = new WebService();
        webService.execute(conexao);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SHK02MenuActivity -> ", "onPause");
    }

    public void voltarSHK01_onClick(View view) {
        Intent intentSHK02 = new Intent(this, SHK00MainActivity.class);
        startActivity(intentSHK02);
    }

    private class WebService extends AsyncTask<String, Object, String> {

        //private final String NAMESPACE = "http://177.11.31.87:23973/";
        private final String NAMESPACE = "http://10.1.17.100:8013/";
        private final String SOAP_SERVICE = "ws/WSMOBILE02000.apw";
        private final String URL = NAMESPACE + SOAP_SERVICE;
        private final String METHOD = "SMOBA02001";;
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
            Log.e("SHK02MenuActivity -> ", "doInBackground");
            getSMOBA02000(params[0]);
            return null;
        }

        @Override
        protected void onPreExecute() {
            Log.e("Funcionalidade/WebService -> ", "onPreExecute");

            progressBarSHK02.setVisibility(View.VISIBLE);
            mennus = new ArrayList<Mennu>();
            buttonSHK02Sair.setEnabled(false);
            listViewSHK02Menu.setEnabled(false);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.e("Funcionalidade/WebService -> ", "onPostExecute");

            listViewSHK02Menu.setEnabled(true);
            adapter = new SHK02MennuAdapter(SHK02MenuActivity.this,mennus);
            listViewSHK02Menu.setAdapter((ListAdapter) adapter);
            progressBarSHK02.setVisibility(View.GONE);
            buttonSHK02Sair.setEnabled(true);

            if (erro == false){
                listViewSHK02Menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        progressBarSHK02.setVisibility(View.VISIBLE);
                        Intent intentSHK02 = new Intent(getBaseContext(), SHK03MenuResumoActivity.class);
                        String cpo03 = "";
                        String cpo04 = "";
                        //int _id = position + 1;
                        cpo03 = mennus.get(position).getCpo03();
                        cpo04 = mennus.get(position).getCpo04();
                        int pos = cpo04.indexOf("(");
                        cpo04 = cpo04.substring(0, pos);

                        intentSHK02.putExtra("CPO03", cpo03);
                        intentSHK02.putExtra("CPO04", cpo04);
                        intentSHK02.putParcelableArrayListExtra("USUARIO", usuarios);
                        intentSHK02.putParcelableArrayListExtra("MENNU", mennus);
                        startActivity(intentSHK02);
                    }
                });
            }else {
                enviarErro(respErro);
            }

        }

        public void getSMOBA02000(String _conexao){
            Log.e("SHK02MenuActivity -> ", "getIdentificadorSMOBA02000");

            request = new SoapObject(NAMESPACE, METHOD);
            envelope = new SoapSerEnv(SoapEnvelope.VER11);
            androidHttpTransport = new HttpTransportSE(URL);

            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            request.addProperty("_CCONEXAO", _conexao);

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
                    mennu = new Mennu(
                            libera.getProperty(0).toString(), // LIBERA
                            libera.getProperty(1).toString(), // LIBERACAO
                            libera.getProperty(2).toString(), // DEVVENDA
                            libera.getProperty(3).toString(), // DEV. VENDA
                            libera.getProperty(4).toString(), // 1
                            libera.getProperty(5).toString() // 0
                    );
                    mennus.add(mennu);
                }
                Log.v("DADOS_WS_CAPTURADO ", response.toString());
            }
            catch(Exception e){
                Log.e("SHK02MenuActivity", "Error on soapObjectData() " + e.getMessage());
                if(envelope.bodyIn != null){
                    respErro = envelope.bodyIn.toString();
                }else {
                    Class c = e.getClass();
                    respErro = c.getName();
                }
                erro = true;//1
            }
        }
    }
    public void enviarErro(String _erro){
        String erro = _erro;
        respErro = null;
        Intent intentSHK99 = new Intent(SHK02MenuActivity.this, SHK99ErroActivity.class);
        intentSHK99.putExtra("ERRO", erro);
        startActivity(intentSHK99);
    }
}
