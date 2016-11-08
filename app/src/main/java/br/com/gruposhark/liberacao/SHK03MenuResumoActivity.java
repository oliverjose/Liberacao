package br.com.gruposhark.liberacao;

import android.content.Intent;
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
import adapter.SHK03MennuResAdapter;
import model.Celular;
import model.Mennu;
import model.MennuResumo;
import model.Usuario;
import util.SoapSerEnv;

public class SHK03MenuResumoActivity extends AppCompatActivity {

    ArrayList<Celular> celulars;
    ArrayList<Usuario>usuarios;
    ArrayList<Mennu>mennus;
    ArrayList<MennuResumo>mennuResumos;
    ArrayList<MennuResumo>mennuRotulos;
    SHK03MennuResAdapter adapter;
    MennuResumo mennuResumo;

    ListView listViewSHK03MenuResumo;

    TextView textViewSHK03CPO01Rot;
    TextView textViewSHK03CPO02Rot;
    TextView textViewSHK03CPO03Rot;
    TextView textViewSHK03CPO04Rot;
    TextView textViewSHK03CPO05Rot;
    TextView textViewSHK03CPO06Rot;
    TextView textViewSHK03CPO07Rot;
    TextView textViewSHK03CPO08Rot;
    TextView textViewSHK03CPO09Rot;
    TextView textViewSHK03CPO10Rot;
    TextView textViewSHK03CPO11Rot;
    TextView textViewSHK03CPO12Rot;
    TextView textViewSHK03CPO13Rot;
    TextView textViewSHK03CPO14Rot;
    TextView textViewSHK03CPO15Rot;
    TextView textViewSHK03CPO16Rot;
    TextView textViewSHK03CPO17Rot;
    TextView textViewSHK03CPO18Rot;
    TextView textViewSHK03CPO19Rot;
    TextView textViewSHK03CPO20Rot;
    TextView textViewSHK03CPO21Rot;
    TextView textViewSHK03CPO22Rot;
    TextView textViewSHK03CPO23Rot;
    TextView textViewSHK03CPO24Rot;
    TextView textViewSHK03CPO25Rot;
    TextView textViewSHK03CPO26Rot;
    TextView textViewSHK03CPO27Rot;
    TextView textViewSHK03CPO28Rot;


    ImageView imageViewSHK03Grupo;
    //TextView textViewSHK02Menu;
    TextView textViewSHK03GrupoShark;

    Button buttonSHK03Voltar;

    ProgressBar progressBarSHK03;

    private String cpo03;
    private String cpo04;
    private String conexao;
    private String respErro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shk03_menu_resumo);
        Log.e("SHK03MenuResumoActivity -> ", "onCreate");


        mennuResumos = new ArrayList<MennuResumo>();
        mennuRotulos = new ArrayList<MennuResumo>();

        listViewSHK03MenuResumo = (ListView) findViewById(R.id.listViewSHK03MenuResumo);

        textViewSHK03CPO01Rot = (TextView) findViewById(R.id.textViewSHK03CPO01Rot);
        textViewSHK03CPO02Rot = (TextView) findViewById(R.id.textViewSHK03CPO02Rot);
        textViewSHK03CPO03Rot = (TextView) findViewById(R.id.textViewSHK03CPO03Rot);
        textViewSHK03CPO04Rot = (TextView) findViewById(R.id.textViewSHK03CPO04Rot);
        textViewSHK03CPO05Rot = (TextView) findViewById(R.id.textViewSHK03CPO05Rot);
        textViewSHK03CPO06Rot = (TextView) findViewById(R.id.textViewSHK03CPO06Rot);
        textViewSHK03CPO07Rot = (TextView) findViewById(R.id.textViewSHK03CPO07Rot);
        textViewSHK03CPO08Rot = (TextView) findViewById(R.id.textViewSHK03CPO08Rot);
        textViewSHK03CPO09Rot = (TextView) findViewById(R.id.textViewSHK03CPO09Rot);
        textViewSHK03CPO10Rot = (TextView) findViewById(R.id.textViewSHK03CPO10Rot);

        textViewSHK03CPO11Rot = (TextView) findViewById(R.id.textViewSHK03CPO11Rot);
        textViewSHK03CPO12Rot = (TextView) findViewById(R.id.textViewSHK03CPO12Rot);
        textViewSHK03CPO13Rot = (TextView) findViewById(R.id.textViewSHK03CPO13Rot);
        textViewSHK03CPO14Rot = (TextView) findViewById(R.id.textViewSHK03CPO14Rot);
        textViewSHK03CPO15Rot = (TextView) findViewById(R.id.textViewSHK03CPO15Rot);
        textViewSHK03CPO16Rot = (TextView) findViewById(R.id.textViewSHK03CPO16Rot);
        textViewSHK03CPO17Rot = (TextView) findViewById(R.id.textViewSHK03CPO17Rot);
        textViewSHK03CPO18Rot = (TextView) findViewById(R.id.textViewSHK03CPO18Rot);
        textViewSHK03CPO19Rot = (TextView) findViewById(R.id.textViewSHK03CPO19Rot);
        textViewSHK03CPO20Rot = (TextView) findViewById(R.id.textViewSHK03CPO20Rot);

        textViewSHK03CPO21Rot = (TextView) findViewById(R.id.textViewSHK03CPO21Rot);
        textViewSHK03CPO22Rot = (TextView) findViewById(R.id.textViewSHK03CPO22Rot);
        textViewSHK03CPO23Rot = (TextView) findViewById(R.id.textViewSHK03CPO23Rot);
        textViewSHK03CPO24Rot = (TextView) findViewById(R.id.textViewSHK03CPO24Rot);
        textViewSHK03CPO25Rot = (TextView) findViewById(R.id.textViewSHK03CPO25Rot);
        textViewSHK03CPO26Rot = (TextView) findViewById(R.id.textViewSHK03CPO26Rot);
        textViewSHK03CPO27Rot = (TextView) findViewById(R.id.textViewSHK03CPO27Rot);
        textViewSHK03CPO28Rot = (TextView) findViewById(R.id.textViewSHK03CPO28Rot);

        buttonSHK03Voltar = (Button) findViewById(R.id.buttonSHK03Voltar);

        progressBarSHK03   = (ProgressBar) findViewById(R.id.progressBarSHK03);
        progressBarSHK03.setVisibility(View.GONE);

        imageViewSHK03Grupo = (ImageView) findViewById(R.id.imageViewSHK03Grupo);
        //textViewSHK02Menu = (TextView) findViewById(R.id.textViewSHK02Menu);
        textViewSHK03GrupoShark = (TextView) findViewById(R.id.textViewSHK03GrupoShark);

        Intent it = getIntent();
        celulars = it.getParcelableArrayListExtra("CELULAR");
        usuarios = it.getParcelableArrayListExtra("USUARIO");
        mennus = it.getParcelableArrayListExtra("MENNU");
        cpo03 = it.getStringExtra("CPO03");
        cpo04 = it.getStringExtra("CPO04");
        textViewSHK03GrupoShark.setText(cpo04);


        String empresa = usuarios.get(0).getEmpresa();

        switch (empresa) {
            case "C":
                imageViewSHK03Grupo.setImageResource(R.drawable.agricase);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFC6142F"));
                textViewSHK03GrupoShark.setTextColor(Color.parseColor("#FFC6142F"));
                buttonSHK03Voltar.setBackgroundColor(Color.parseColor("#FFC6142F"));
                //FFC6142F
                //textViewSHK02Grupo.setText("AGRICASE");
                break;
            case "D":
                imageViewSHK03Grupo.setImageResource(R.drawable.dismamassy);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFED4F54"));
                textViewSHK03GrupoShark.setTextColor(Color.parseColor("#FFED4F54"));
                buttonSHK03Voltar.setBackgroundColor(Color.parseColor("#FFED4F54"));
                //textViewSHK02Grupo.setText("DISMA");
                break;
            case "E":
                imageViewSHK03Grupo.setImageResource(R.drawable.equagrilagriculture);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFF6C331"));
                textViewSHK03GrupoShark.setTextColor(Color.parseColor("#FF034581"));
                buttonSHK03Voltar.setBackgroundColor(Color.parseColor("#FFF6C331"));
                break;
            case "M":
                imageViewSHK03Grupo.setImageResource(R.drawable.sharkmaquinascons);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FF020302"));
                textViewSHK03GrupoShark.setTextColor(Color.parseColor("#FF020302"));
                buttonSHK03Voltar.setBackgroundColor(Color.parseColor("#FF020302"));
                break;
            case "N":
                imageViewSHK03Grupo.setImageResource(R.drawable.equagrilagriculture);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FF034581"));
                textViewSHK03GrupoShark.setTextColor(Color.parseColor("#FF034581"));
                buttonSHK03Voltar.setBackgroundColor(Color.parseColor("#FF034581"));
                break;
            case "V":
                imageViewSHK03Grupo.setImageResource(R.drawable.valtra);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFA40202"));
                textViewSHK03GrupoShark.setTextColor(Color.parseColor("#FFA40202"));
                buttonSHK03Voltar.setBackgroundColor(Color.parseColor("#FFA40202"));
                break;
            case "X":
                imageViewSHK03Grupo.setImageResource(R.drawable.sharktratores);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FF024D97"));
                textViewSHK03GrupoShark.setTextColor(Color.parseColor("#FF024D97"));
                buttonSHK03Voltar.setBackgroundColor(Color.parseColor("#FF024D97"));
                break;
        }

        conexao = usuarios.get(0).getConexao();

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SHK03MenuResumoActivity -> ", "onResume");

        WebService webService = new WebService();
        webService.execute(conexao, cpo03);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SHK03MenuResumoActivity -> ", "onPause");
    }

    public void voltarSHK02_onClick(View view) {
        onBackPressed();
        //Intent intentSHK03 = new Intent(this, SHK02MenuActivity.class);
        //startActivity(intentSHK03);
    }


    private class WebService extends AsyncTask<String, Object, String> {

        //private final String NAMESPACE = "http://177.11.31.87:23973/";
        private final String NAMESPACE = "http://10.1.17.100:8013/";
        private final String SOAP_SERVICE = "ws/WSMOBILE03000.apw";
        private final String URL = NAMESPACE + SOAP_SERVICE;
        private final String METHOD = "SMOBA03001";;
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
            Log.e("SHK03MenuResumoActivity -> ", "doInBackground");

            getSMOBA03000(params[0], params[1]);
            return null;
        }

        @Override
        protected void onPreExecute() {
            Log.e("Funcionalidade/WebService -> ", "onPreExecute");
            progressBarSHK03.setVisibility(View.VISIBLE);
            mennus = new ArrayList<Mennu>();
            mennuRotulos = new ArrayList<MennuResumo>();
            mennuResumos = new ArrayList<MennuResumo>();
            buttonSHK03Voltar.setEnabled(false);
            listViewSHK03MenuResumo.setEnabled(false);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.e("Funcionalidade/WebService -> ", "onPostExecute");

            if (erro == false){
                buttonSHK03Voltar.setEnabled(true);
                listViewSHK03MenuResumo.setEnabled(true);
                textViewSHK03CPO01Rot.setText(mennuRotulos.get(0).getCpo01());
                textViewSHK03CPO02Rot.setText(mennuRotulos.get(0).getCpo02());
                textViewSHK03CPO03Rot.setText(mennuRotulos.get(0).getCpo03());
                textViewSHK03CPO04Rot.setText(mennuRotulos.get(0).getCpo04());
                textViewSHK03CPO05Rot.setText(mennuRotulos.get(0).getCpo05());
                textViewSHK03CPO06Rot.setText(mennuRotulos.get(0).getCpo06());
                textViewSHK03CPO07Rot.setText(mennuRotulos.get(0).getCpo07());
                textViewSHK03CPO08Rot.setText(mennuRotulos.get(0).getCpo08());
                textViewSHK03CPO09Rot.setText(mennuRotulos.get(0).getCpo09());
                textViewSHK03CPO10Rot.setText(mennuRotulos.get(0).getCpo10());
                textViewSHK03CPO11Rot.setText(mennuRotulos.get(0).getCpo11());
                textViewSHK03CPO12Rot.setText(mennuRotulos.get(0).getCpo12());
                textViewSHK03CPO13Rot.setText(mennuRotulos.get(0).getCpo13());
                textViewSHK03CPO14Rot.setText(mennuRotulos.get(0).getCpo14());
                textViewSHK03CPO15Rot.setText(mennuRotulos.get(0).getCpo15());
                textViewSHK03CPO16Rot.setText(mennuRotulos.get(0).getCpo16());
                textViewSHK03CPO17Rot.setText(mennuRotulos.get(0).getCpo17());
                textViewSHK03CPO18Rot.setText(mennuRotulos.get(0).getCpo18());
                textViewSHK03CPO19Rot.setText(mennuRotulos.get(0).getCpo19());
                textViewSHK03CPO20Rot.setText(mennuRotulos.get(0).getCpo20());
                textViewSHK03CPO21Rot.setText(mennuRotulos.get(0).getCpo21());
                textViewSHK03CPO22Rot.setText(mennuRotulos.get(0).getCpo22());
                textViewSHK03CPO23Rot.setText(mennuRotulos.get(0).getCpo23());
                textViewSHK03CPO24Rot.setText(mennuRotulos.get(0).getCpo24());
                textViewSHK03CPO25Rot.setText(mennuRotulos.get(0).getCpo25());
                textViewSHK03CPO26Rot.setText(mennuRotulos.get(0).getCpo26());
                textViewSHK03CPO27Rot.setText(mennuRotulos.get(0).getCpo27());
                textViewSHK03CPO28Rot.setText(mennuRotulos.get(0).getCpo28());

                //listViewSHK03MenuResumo.

                adapter = new SHK03MennuResAdapter(SHK03MenuResumoActivity.this,mennuResumos);
                listViewSHK03MenuResumo.setAdapter((ListAdapter) adapter);

                progressBarSHK03.setVisibility(View.GONE);

                listViewSHK03MenuResumo.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intentSHK02 = new Intent(getBaseContext(), SHK04MenuDetalhe.class);

                        intentSHK02.putExtra("ID", position);
                        intentSHK02.putExtra("CPO03", cpo03);
                        intentSHK02.putExtra("CPO04", cpo04);
                        intentSHK02.putParcelableArrayListExtra("USUARIO", usuarios);
                        intentSHK02.putParcelableArrayListExtra("MENNU", mennus);
                        intentSHK02.putParcelableArrayListExtra("MENNUROT", mennuRotulos);
                        intentSHK02.putParcelableArrayListExtra("MENNURES", mennuResumos);

                        startActivity(intentSHK02);
                    }
                });
            }else{
                enviarErro(respErro);
            }

        }

        public void getSMOBA03000(String _conexao, String _cpo03){
            Log.e("SHK03MenuResumoActivity -> ", "getSMOBA03000");


            request = new SoapObject(NAMESPACE, METHOD);
            envelope = new SoapSerEnv(SoapEnvelope.VER11);
            androidHttpTransport = new HttpTransportSE(URL);

            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            request.addProperty("_CCONEXAO", _conexao);
            request.addProperty("_CLOTE", "");
            request.addProperty("_CTPRET", "R");
            request.addProperty("_CGRUPO", _cpo03);

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
                    //libera.getProperty(i).toString();
                    mennuResumo = new MennuResumo(
                            libera.getProperty(0).toString(),
                            libera.getProperty(1).toString(),
                            libera.getProperty(2).toString(),
                            libera.getProperty(3).toString(),
                            libera.getProperty(4).toString(),
                            libera.getProperty(5).toString(),
                            libera.getProperty(6).toString(),
                            libera.getProperty(7).toString(),
                            libera.getProperty(8).toString(),
                            libera.getProperty(9).toString(),
                            libera.getProperty(10).toString(),
                            libera.getProperty(11).toString(),
                            libera.getProperty(12).toString(),
                            libera.getProperty(13).toString(),
                            libera.getProperty(14).toString(),
                            libera.getProperty(15).toString(),
                            libera.getProperty(16).toString(),
                            libera.getProperty(17).toString(),
                            libera.getProperty(18).toString(),
                            libera.getProperty(19).toString(),
                            libera.getProperty(20).toString(),
                            libera.getProperty(21).toString(),
                            libera.getProperty(22).toString(),
                            libera.getProperty(23).toString(),
                            libera.getProperty(24).toString(),
                            libera.getProperty(25).toString(),
                            libera.getProperty(26).toString(),
                            libera.getProperty(27).toString()
                    );

                    if (i == 0){
                        mennuRotulos.add(mennuResumo);
                    }else {
                        mennuResumos.add(mennuResumo);
                    }

                }
                Log.v("DADOS_WS_CAPTURADO ", response.toString());
            }
            catch(Exception e){
                Log.e("SHK03MenuResumoActivity -> ", "Error on soapObjectData() " + e.getMessage());
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
        Intent intentSHK99 = new Intent(SHK03MenuResumoActivity.this, SHK99ErroActivity.class);
        intentSHK99.putExtra("ERRO", erro);
        startActivity(intentSHK99);
    }

}
