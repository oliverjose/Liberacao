package br.com.gruposhark.liberacao;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
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
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import adapter.SHK03MennuResAdapter;
import adapter.SHK04ItemAdapter;
import model.Celular;
import model.Item;
import model.Mennu;
import model.MennuResumo;
import model.Usuario;
import util.SoapSerEnv;

public class SHK04MenuDetalhe extends AppCompatActivity {

    ArrayList<Celular> celulars;
    ArrayList<Usuario> usuarios;
    ArrayList<Mennu> mennus;
    ArrayList<Item> items;
    ArrayList<Item> itemRotulo;
    ArrayList<MennuResumo> mennuResumos;
    ArrayList<MennuResumo> mennuRotulos;
    SHK04ItemAdapter adapter;
    MennuResumo mennuResumo;
    Item item;

    ImageView imageViewSHK04Grupo;
    //TextView textViewSHK02Menu;
    TextView textViewSHK04GrupoShark;

    ListView listViewSHK04MenuDet;
    ScrollView SHK04horizontalScrollView;
    ProgressBar progressBarSHK04MenuDet;

    TextView textViewSHK04CPO01Rot, textViewSHK04CPO01, textViewSHK04CPO01ItemRot;
    TextView textViewSHK04CPO02Rot, textViewSHK04CPO02, textViewSHK04CPO02ItemRot;
    TextView textViewSHK04CPO03Rot, textViewSHK04CPO03, textViewSHK04CPO03ItemRot;
    TextView textViewSHK04CPO04Rot, textViewSHK04CPO04, textViewSHK04CPO04ItemRot;
    TextView textViewSHK04CPO05Rot, textViewSHK04CPO05, textViewSHK04CPO05ItemRot;
    TextView textViewSHK04CPO06Rot, textViewSHK04CPO06, textViewSHK04CPO06ItemRot;
    TextView textViewSHK04CPO07Rot, textViewSHK04CPO07, textViewSHK04CPO07ItemRot;
    TextView textViewSHK04CPO08Rot, textViewSHK04CPO08, textViewSHK04CPO08ItemRot;
    TextView textViewSHK04CPO09Rot, textViewSHK04CPO09, textViewSHK04CPO09ItemRot;
    TextView textViewSHK04CPO10Rot, textViewSHK04CPO10, textViewSHK04CPO10ItemRot;
    TextView textViewSHK04CPO11Rot, textViewSHK04CPO11, textViewSHK04CPO11ItemRot;
    TextView textViewSHK04CPO12Rot, textViewSHK04CPO12, textViewSHK04CPO12ItemRot;
    TextView textViewSHK04CPO13Rot, textViewSHK04CPO13, textViewSHK04CPO13ItemRot;
    TextView textViewSHK04CPO14Rot, textViewSHK04CPO14, textViewSHK04CPO14ItemRot;
    TextView textViewSHK04CPO15Rot, textViewSHK04CPO15, textViewSHK04CPO15ItemRot;
    TextView textViewSHK04CPO16Rot, textViewSHK04CPO16, textViewSHK04CPO16ItemRot;
    TextView textViewSHK04CPO17Rot, textViewSHK04CPO17, textViewSHK04CPO17ItemRot;
    TextView textViewSHK04CPO18Rot, textViewSHK04CPO18, textViewSHK04CPO18ItemRot;
    TextView textViewSHK04CPO19Rot, textViewSHK04CPO19, textViewSHK04CPO19ItemRot;
    TextView textViewSHK04CPO20Rot, textViewSHK04CPO20, textViewSHK04CPO20ItemRot;
    TextView textViewSHK04CPO21Rot, textViewSHK04CPO21, textViewSHK04CPO21ItemRot;
    TextView textViewSHK04CPO22Rot, textViewSHK04CPO22, textViewSHK04CPO22ItemRot;
    TextView textViewSHK04CPO23Rot, textViewSHK04CPO23, textViewSHK04CPO23ItemRot;
    TextView textViewSHK04CPO24Rot, textViewSHK04CPO24, textViewSHK04CPO24ItemRot;
    TextView textViewSHK04CPO25Rot, textViewSHK04CPO25, textViewSHK04CPO25ItemRot;
    TextView textViewSHK04CPO26Rot, textViewSHK04CPO26, textViewSHK04CPO26ItemRot;
    TextView textViewSHK04CPO27Rot, textViewSHK04CPO27, textViewSHK04CPO27ItemRot;
    TextView textViewSHK04CPO28Rot, textViewSHK04CPO28, textViewSHK04CPO28ItemRot;

    Button buttonSHK04Voltar;
    Button buttonSHK04Rejeitar;
    Button buttonSHK04Liberar;

    private String cpo03;
    private String cpo04;
    private String lote;
    private String conexao;
    private String respErro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shk04_menu_detalhe);
        Log.e("SHK04MenuDetalhe -> ", "onCreate");


        items = new ArrayList<Item>();
        itemRotulo = new ArrayList<Item>();

        Intent it = getIntent();
        usuarios = it.getParcelableArrayListExtra("USUARIO");
        mennus = it.getParcelableArrayListExtra("MENNU");
        mennuResumos = it.getParcelableArrayListExtra("MENNURES");
        mennuRotulos = it.getParcelableArrayListExtra("MENNUROT");
        int id = it.getIntExtra("ID", 0);
        cpo03 = it.getStringExtra("CPO03");
        cpo04 = it.getStringExtra("CPO04");
        celulars = it.getParcelableArrayListExtra("CELULAR");

        imageViewSHK04Grupo = (ImageView) findViewById(R.id.imageViewSHK04Grupo);
        //textViewSHK02Menu = (TextView) findViewById(R.id.textViewSHK02Menu);
        textViewSHK04GrupoShark = (TextView) findViewById(R.id.textViewSHK04GrupoShark);
        textViewSHK04GrupoShark.setText(cpo04);

        progressBarSHK04MenuDet = (ProgressBar) findViewById(R.id.progressBarSHK04MenuDet);
        progressBarSHK04MenuDet.setVisibility(View.GONE);


        buttonSHK04Voltar = (Button) findViewById(R.id.buttonSHK04Voltar);
        buttonSHK04Rejeitar = (Button) findViewById(R.id.buttonSHK04Rejeitar);
        buttonSHK04Liberar = (Button) findViewById(R.id.buttonSHK04Liberar);

        listViewSHK04MenuDet = (ListView) findViewById(R.id.listViewSHK04MenuDet);

        textViewSHK04CPO01Rot = (TextView) findViewById(R.id.textViewSHK04CPO01Rot);
        textViewSHK04CPO02Rot = (TextView) findViewById(R.id.textViewSHK04CPO02Rot);
        textViewSHK04CPO03Rot = (TextView) findViewById(R.id.textViewSHK04CPO03Rot);
        textViewSHK04CPO04Rot = (TextView) findViewById(R.id.textViewSHK04CPO04Rot);
        textViewSHK04CPO05Rot = (TextView) findViewById(R.id.textViewSHK04CPO05Rot);
        textViewSHK04CPO06Rot = (TextView) findViewById(R.id.textViewSHK04CPO06Rot);
        textViewSHK04CPO07Rot = (TextView) findViewById(R.id.textViewSHK04CPO07Rot);
        textViewSHK04CPO08Rot = (TextView) findViewById(R.id.textViewSHK04CPO08Rot);
        textViewSHK04CPO09Rot = (TextView) findViewById(R.id.textViewSHK04CPO09Rot);
        textViewSHK04CPO10Rot = (TextView) findViewById(R.id.textViewSHK04CPO10Rot);
        textViewSHK04CPO11Rot = (TextView) findViewById(R.id.textViewSHK04CPO11Rot);
        textViewSHK04CPO12Rot = (TextView) findViewById(R.id.textViewSHK04CPO12Rot);
        textViewSHK04CPO13Rot = (TextView) findViewById(R.id.textViewSHK04CPO13Rot);
        textViewSHK04CPO14Rot = (TextView) findViewById(R.id.textViewSHK04CPO14Rot);
        textViewSHK04CPO15Rot = (TextView) findViewById(R.id.textViewSHK04CPO15Rot);
        textViewSHK04CPO16Rot = (TextView) findViewById(R.id.textViewSHK04CPO16Rot);
        textViewSHK04CPO17Rot = (TextView) findViewById(R.id.textViewSHK04CPO17Rot);
        textViewSHK04CPO18Rot = (TextView) findViewById(R.id.textViewSHK04CPO18Rot);
        textViewSHK04CPO19Rot = (TextView) findViewById(R.id.textViewSHK04CPO19Rot);
        textViewSHK04CPO20Rot = (TextView) findViewById(R.id.textViewSHK04CPO20Rot);
        textViewSHK04CPO21Rot = (TextView) findViewById(R.id.textViewSHK04CPO21Rot);
        textViewSHK04CPO22Rot = (TextView) findViewById(R.id.textViewSHK04CPO22Rot);
        textViewSHK04CPO23Rot = (TextView) findViewById(R.id.textViewSHK04CPO23Rot);
        textViewSHK04CPO24Rot = (TextView) findViewById(R.id.textViewSHK04CPO24Rot);
        textViewSHK04CPO25Rot = (TextView) findViewById(R.id.textViewSHK04CPO25Rot);
        textViewSHK04CPO26Rot = (TextView) findViewById(R.id.textViewSHK04CPO26Rot);
        textViewSHK04CPO27Rot = (TextView) findViewById(R.id.textViewSHK04CPO27Rot);
        textViewSHK04CPO28Rot = (TextView) findViewById(R.id.textViewSHK04CPO28Rot);

        textViewSHK04CPO01Rot.setText(mennuRotulos.get(0).getCpo01());
        textViewSHK04CPO02Rot.setText(mennuRotulos.get(0).getCpo02());
        textViewSHK04CPO03Rot.setText(mennuRotulos.get(0).getCpo03());
        textViewSHK04CPO04Rot.setText(mennuRotulos.get(0).getCpo04());
        textViewSHK04CPO05Rot.setText(mennuRotulos.get(0).getCpo05());
        textViewSHK04CPO06Rot.setText(mennuRotulos.get(0).getCpo06());
        textViewSHK04CPO07Rot.setText(mennuRotulos.get(0).getCpo07());
        textViewSHK04CPO08Rot.setText(mennuRotulos.get(0).getCpo08());
        textViewSHK04CPO09Rot.setText(mennuRotulos.get(0).getCpo09());
        textViewSHK04CPO10Rot.setText(mennuRotulos.get(0).getCpo10());
        textViewSHK04CPO11Rot.setText(mennuRotulos.get(0).getCpo11());
        textViewSHK04CPO12Rot.setText(mennuRotulos.get(0).getCpo12());
        textViewSHK04CPO13Rot.setText(mennuRotulos.get(0).getCpo13());
        textViewSHK04CPO14Rot.setText(mennuRotulos.get(0).getCpo14());
        textViewSHK04CPO15Rot.setText(mennuRotulos.get(0).getCpo15());
        textViewSHK04CPO16Rot.setText(mennuRotulos.get(0).getCpo16());
        textViewSHK04CPO17Rot.setText(mennuRotulos.get(0).getCpo17());
        textViewSHK04CPO18Rot.setText(mennuRotulos.get(0).getCpo18());
        textViewSHK04CPO19Rot.setText(mennuRotulos.get(0).getCpo19());
        textViewSHK04CPO20Rot.setText(mennuRotulos.get(0).getCpo20());
        textViewSHK04CPO21Rot.setText(mennuRotulos.get(0).getCpo21());
        textViewSHK04CPO22Rot.setText(mennuRotulos.get(0).getCpo22());
        textViewSHK04CPO23Rot.setText(mennuRotulos.get(0).getCpo23());
        textViewSHK04CPO24Rot.setText(mennuRotulos.get(0).getCpo24());
        textViewSHK04CPO25Rot.setText(mennuRotulos.get(0).getCpo25());
        textViewSHK04CPO26Rot.setText(mennuRotulos.get(0).getCpo26());
        textViewSHK04CPO27Rot.setText(mennuRotulos.get(0).getCpo27());
        textViewSHK04CPO28Rot.setText(mennuRotulos.get(0).getCpo28());

        textViewSHK04CPO01 = (TextView) findViewById(R.id.textViewSHK04CPO01);
        textViewSHK04CPO02 = (TextView) findViewById(R.id.textViewSHK04CPO02);
        textViewSHK04CPO03 = (TextView) findViewById(R.id.textViewSHK04CPO03);
        textViewSHK04CPO04 = (TextView) findViewById(R.id.textViewSHK04CPO04);
        textViewSHK04CPO05 = (TextView) findViewById(R.id.textViewSHK04CPO05);
        textViewSHK04CPO06 = (TextView) findViewById(R.id.textViewSHK04CPO06);
        textViewSHK04CPO07 = (TextView) findViewById(R.id.textViewSHK04CPO07);
        textViewSHK04CPO08 = (TextView) findViewById(R.id.textViewSHK04CPO08);
        textViewSHK04CPO09 = (TextView) findViewById(R.id.textViewSHK04CPO09);
        textViewSHK04CPO10 = (TextView) findViewById(R.id.textViewSHK04CPO10);
        textViewSHK04CPO11 = (TextView) findViewById(R.id.textViewSHK04CPO11);
        textViewSHK04CPO12 = (TextView) findViewById(R.id.textViewSHK04CPO12);
        textViewSHK04CPO13 = (TextView) findViewById(R.id.textViewSHK04CPO13);
        textViewSHK04CPO14 = (TextView) findViewById(R.id.textViewSHK04CPO14);
        textViewSHK04CPO15 = (TextView) findViewById(R.id.textViewSHK04CPO15);
        textViewSHK04CPO16 = (TextView) findViewById(R.id.textViewSHK04CPO16);
        textViewSHK04CPO17 = (TextView) findViewById(R.id.textViewSHK04CPO17);
        textViewSHK04CPO18 = (TextView) findViewById(R.id.textViewSHK04CPO18);
        textViewSHK04CPO19 = (TextView) findViewById(R.id.textViewSHK04CPO19);
        textViewSHK04CPO20 = (TextView) findViewById(R.id.textViewSHK04CPO20);
        textViewSHK04CPO21 = (TextView) findViewById(R.id.textViewSHK04CPO21);
        textViewSHK04CPO22 = (TextView) findViewById(R.id.textViewSHK04CPO22);
        textViewSHK04CPO23 = (TextView) findViewById(R.id.textViewSHK04CPO23);
        textViewSHK04CPO24 = (TextView) findViewById(R.id.textViewSHK04CPO24);
        textViewSHK04CPO25 = (TextView) findViewById(R.id.textViewSHK04CPO25);
        textViewSHK04CPO26 = (TextView) findViewById(R.id.textViewSHK04CPO26);
        textViewSHK04CPO27 = (TextView) findViewById(R.id.textViewSHK04CPO27);
        textViewSHK04CPO28 = (TextView) findViewById(R.id.textViewSHK04CPO28);

        textViewSHK04CPO01ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO01ItemRot);
        textViewSHK04CPO02ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO02ItemRot);
        textViewSHK04CPO03ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO03ItemRot);
        textViewSHK04CPO04ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO04ItemRot);
        textViewSHK04CPO05ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO05ItemRot);
        textViewSHK04CPO06ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO06ItemRot);
        textViewSHK04CPO07ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO07ItemRot);
        textViewSHK04CPO08ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO08ItemRot);
        textViewSHK04CPO09ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO09ItemRot);
        textViewSHK04CPO10ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO10ItemRot);
        textViewSHK04CPO11ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO11ItemRot);
        textViewSHK04CPO12ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO12ItemRot);
        textViewSHK04CPO13ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO13ItemRot);
        textViewSHK04CPO14ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO14ItemRot);
        textViewSHK04CPO15ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO15ItemRot);
        textViewSHK04CPO16ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO16ItemRot);
        textViewSHK04CPO17ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO17ItemRot);
        textViewSHK04CPO18ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO18ItemRot);
        textViewSHK04CPO19ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO19ItemRot);
        textViewSHK04CPO20ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO20ItemRot);
        textViewSHK04CPO21ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO21ItemRot);
        textViewSHK04CPO22ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO22ItemRot);
        textViewSHK04CPO23ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO23ItemRot);
        textViewSHK04CPO24ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO24ItemRot);
        textViewSHK04CPO25ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO25ItemRot);
        textViewSHK04CPO26ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO26ItemRot);
        textViewSHK04CPO27ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO27ItemRot);
        textViewSHK04CPO28ItemRot = (TextView) findViewById(R.id.textViewSHK04CPO28ItemRot);

        textViewSHK04CPO01.setText(mennuResumos.get(id).getCpo01());
        textViewSHK04CPO02.setText(mennuResumos.get(id).getCpo02());
        textViewSHK04CPO03.setText(mennuResumos.get(id).getCpo03());
        textViewSHK04CPO04.setText(mennuResumos.get(id).getCpo04());
        textViewSHK04CPO05.setText(mennuResumos.get(id).getCpo05());
        textViewSHK04CPO06.setText(mennuResumos.get(id).getCpo06());
        textViewSHK04CPO07.setText(mennuResumos.get(id).getCpo07());
        textViewSHK04CPO08.setText(mennuResumos.get(id).getCpo08());
        textViewSHK04CPO09.setText(mennuResumos.get(id).getCpo09());
        textViewSHK04CPO10.setText(mennuResumos.get(id).getCpo10());
        textViewSHK04CPO11.setText(mennuResumos.get(id).getCpo11());
        textViewSHK04CPO12.setText(mennuResumos.get(id).getCpo12());
        textViewSHK04CPO13.setText(mennuResumos.get(id).getCpo13());
        textViewSHK04CPO14.setText(mennuResumos.get(id).getCpo14());
        textViewSHK04CPO15.setText(mennuResumos.get(id).getCpo15());
        textViewSHK04CPO16.setText(mennuResumos.get(id).getCpo16());
        textViewSHK04CPO17.setText(mennuResumos.get(id).getCpo17());
        textViewSHK04CPO18.setText(mennuResumos.get(id).getCpo18());
        textViewSHK04CPO19.setText(mennuResumos.get(id).getCpo19());
        textViewSHK04CPO20.setText(mennuResumos.get(id).getCpo20());
        textViewSHK04CPO21.setText(mennuResumos.get(id).getCpo21());
        textViewSHK04CPO22.setText(mennuResumos.get(id).getCpo22());
        textViewSHK04CPO23.setText(mennuResumos.get(id).getCpo23());
        textViewSHK04CPO24.setText(mennuResumos.get(id).getCpo24());
        textViewSHK04CPO25.setText(mennuResumos.get(id).getCpo25());
        textViewSHK04CPO26.setText(mennuResumos.get(id).getCpo26());
        textViewSHK04CPO27.setText(mennuResumos.get(id).getCpo27());
        textViewSHK04CPO28.setText(mennuResumos.get(id).getCpo28());


        String empresa = usuarios.get(0).getEmpresa();

        switch (empresa) {
            case "C":
                imageViewSHK04Grupo.setImageResource(R.drawable.agricase);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFC6142F"));
                textViewSHK04GrupoShark.setTextColor(Color.parseColor("#FFC6142F"));
                buttonSHK04Voltar.setBackgroundColor(Color.parseColor("#FFC6142F"));
                buttonSHK04Rejeitar.setBackgroundColor(Color.parseColor("#FFC6142F"));
                buttonSHK04Liberar.setBackgroundColor(Color.parseColor("#FFC6142F"));
                //FFC6142F
                //textViewSHK02Grupo.setText("AGRICASE");
                break;
            case "D":
                imageViewSHK04Grupo.setImageResource(R.drawable.dismamassy);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFED4F54"));
                textViewSHK04GrupoShark.setTextColor(Color.parseColor("#FFED4F54"));
                buttonSHK04Voltar.setBackgroundColor(Color.parseColor("#FFED4F54"));
                buttonSHK04Rejeitar.setBackgroundColor(Color.parseColor("#FFED4F54"));
                buttonSHK04Liberar.setBackgroundColor(Color.parseColor("#FFED4F54"));
                //textViewSHK02Grupo.setText("DISMA");
                break;
            case "E":
                imageViewSHK04Grupo.setImageResource(R.drawable.equagrilagriculture);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFF6C331"));
                textViewSHK04GrupoShark.setTextColor(Color.parseColor("#FF034581"));
                buttonSHK04Voltar.setBackgroundColor(Color.parseColor("#FFF6C331"));
                buttonSHK04Rejeitar.setBackgroundColor(Color.parseColor("#FFF6C331"));
                buttonSHK04Liberar.setBackgroundColor(Color.parseColor("#FFF6C331"));
                break;
            case "M":
                imageViewSHK04Grupo.setImageResource(R.drawable.sharkmaquinascons);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FF020302"));
                textViewSHK04GrupoShark.setTextColor(Color.parseColor("#FF020302"));
                buttonSHK04Voltar.setBackgroundColor(Color.parseColor("#FF020302"));
                buttonSHK04Rejeitar.setBackgroundColor(Color.parseColor("#FF020302"));
                buttonSHK04Liberar.setBackgroundColor(Color.parseColor("#FF020302"));
                break;
            case "N":
                imageViewSHK04Grupo.setImageResource(R.drawable.equagrilagriculture);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FF034581"));
                textViewSHK04GrupoShark.setTextColor(Color.parseColor("#FF034581"));
                buttonSHK04Voltar.setBackgroundColor(Color.parseColor("#FF034581"));
                buttonSHK04Rejeitar.setBackgroundColor(Color.parseColor("#FF034581"));
                buttonSHK04Liberar.setBackgroundColor(Color.parseColor("#FF034581"));
                break;
            case "V":
                imageViewSHK04Grupo.setImageResource(R.drawable.valtra);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FFA40202"));
                textViewSHK04GrupoShark.setTextColor(Color.parseColor("#FFA40202"));
                buttonSHK04Voltar.setBackgroundColor(Color.parseColor("#FFA40202"));
                buttonSHK04Rejeitar.setBackgroundColor(Color.parseColor("#FFA40202"));
                buttonSHK04Liberar.setBackgroundColor(Color.parseColor("#FFA40202"));
                break;
            case "X":
                imageViewSHK04Grupo.setImageResource(R.drawable.sharktratores);
                //textViewSHK02Menu.setTextColor(Color.parseColor("#FF024D97"));
                textViewSHK04GrupoShark.setTextColor(Color.parseColor("#FF024D97"));
                buttonSHK04Voltar.setBackgroundColor(Color.parseColor("#FF024D97"));
                buttonSHK04Rejeitar.setBackgroundColor(Color.parseColor("#FF024D97"));
                buttonSHK04Liberar.setBackgroundColor(Color.parseColor("#FF024D97"));
                break;
        }

        lote = mennuResumos.get(id).getCpo25();
        conexao = usuarios.get(0).getConexao();

    }

    @Override
    protected void onResume() {
        super.onResume();
        WebService webService = new WebService();
        webService.execute(conexao, lote, cpo03);
    }

    public void voltarSHK03_onClick(View view) {

        onBackPressed();
        //Intent intentSHK04 = new Intent(this, SHK03MenuResumoActivity.class);
        //startActivity(intentSHK04);
    }

    public void rejeitarSHK04_onClick(View view) {

        AlertDialog.Builder dialogo = new
                AlertDialog.Builder(SHK04MenuDetalhe.this);
        dialogo.setMessage("Deseja rejeitar?");

        dialogo.setPositiveButton("Sim", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int arg) {
                        String libRej = "R";
                        WebServiceLib webServiceRej = new WebServiceLib();
                        webServiceRej.execute(conexao, lote, libRej, cpo03);
                    }
                });
        dialogo.setNegativeButton("Não", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int arg) {
                        onResume();
                    }
                });
        dialogo.setTitle("Aviso");
        dialogo.show();
    }

    public void liberarSHK04_onClick(View view) {

        AlertDialog.Builder dialogo = new
                AlertDialog.Builder(SHK04MenuDetalhe.this);
        dialogo.setMessage("Confirma a liberação?");

        dialogo.setPositiveButton("Sim", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int arg) {
                        String libRej = "L";
                        WebServiceLib webServiceLib = new WebServiceLib();
                        webServiceLib.execute(conexao, lote, libRej, cpo03);
                    }
                });
        dialogo.setNegativeButton("Não", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int arg) {
                        onResume();
                    }
                });
        dialogo.setTitle("Aviso");
        dialogo.show();

    }


    private class WebService extends AsyncTask<String, Object, String> {

        //private final String NAMESPACE = "http://177.11.31.87:23973/";
        private final String NAMESPACE = "http://10.1.17.100:8013/";
        private final String SOAP_SERVICE = "ws/WSMOBILE03000.apw";
        private final String URL = NAMESPACE + SOAP_SERVICE;
        private final String METHOD = "SMOBA03001";
        ;
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
            Log.e("SHK04MenuDetalhe -> ", "doInBackground");
            getSMOBA03000(params[0], params[1], params[2]);
            return null;
        }

        @Override
        protected void onPreExecute() {
            Log.e("Funcionalidade/WebService -> ", "onPreExecute");

            listViewSHK04MenuDet.setEnabled(false);
            buttonSHK04Voltar.setEnabled(false);
            buttonSHK04Rejeitar.setEnabled(false);
            buttonSHK04Liberar.setEnabled(false);
            progressBarSHK04MenuDet.setVisibility(View.VISIBLE);

        }

        @Override
        protected void onPostExecute(String s) {
            Log.e("Funcionalidade/WebService -> ", "onPostExecute");

            if (erro == false){
                listViewSHK04MenuDet.setEnabled(true);
                buttonSHK04Voltar.setEnabled(true);
                buttonSHK04Rejeitar.setEnabled(true);
                buttonSHK04Liberar.setEnabled(true);
                progressBarSHK04MenuDet.setVisibility(View.GONE);


                adapter = new SHK04ItemAdapter(SHK04MenuDetalhe.this, items);
                listViewSHK04MenuDet.setAdapter(adapter);

                textViewSHK04CPO01ItemRot.setText(itemRotulo.get(0).getCpo01());
                textViewSHK04CPO02ItemRot.setText(itemRotulo.get(0).getCpo02());
                textViewSHK04CPO03ItemRot.setText(itemRotulo.get(0).getCpo03());
                textViewSHK04CPO04ItemRot.setText(itemRotulo.get(0).getCpo04());
                textViewSHK04CPO05ItemRot.setText(itemRotulo.get(0).getCpo05());
                textViewSHK04CPO06ItemRot.setText(itemRotulo.get(0).getCpo06());
                textViewSHK04CPO07ItemRot.setText(itemRotulo.get(0).getCpo07());
                textViewSHK04CPO08ItemRot.setText(itemRotulo.get(0).getCpo08());
                textViewSHK04CPO09ItemRot.setText(itemRotulo.get(0).getCpo09());
                textViewSHK04CPO10ItemRot.setText(itemRotulo.get(0).getCpo10());
                textViewSHK04CPO11ItemRot.setText(itemRotulo.get(0).getCpo11());
                textViewSHK04CPO12ItemRot.setText(itemRotulo.get(0).getCpo12());
                textViewSHK04CPO13ItemRot.setText(itemRotulo.get(0).getCpo13());
                textViewSHK04CPO14ItemRot.setText(itemRotulo.get(0).getCpo14());
                textViewSHK04CPO15ItemRot.setText(itemRotulo.get(0).getCpo15());
                textViewSHK04CPO16ItemRot.setText(itemRotulo.get(0).getCpo16());
                textViewSHK04CPO17ItemRot.setText(itemRotulo.get(0).getCpo17());
                textViewSHK04CPO18ItemRot.setText(itemRotulo.get(0).getCpo18());
                textViewSHK04CPO19ItemRot.setText(itemRotulo.get(0).getCpo19());
                textViewSHK04CPO20ItemRot.setText(itemRotulo.get(0).getCpo20());
                textViewSHK04CPO21ItemRot.setText(itemRotulo.get(0).getCpo21());
                textViewSHK04CPO22ItemRot.setText(itemRotulo.get(0).getCpo22());
                textViewSHK04CPO23ItemRot.setText(itemRotulo.get(0).getCpo23());
                textViewSHK04CPO24ItemRot.setText(itemRotulo.get(0).getCpo24());
                textViewSHK04CPO25ItemRot.setText(itemRotulo.get(0).getCpo25());
                textViewSHK04CPO26ItemRot.setText(itemRotulo.get(0).getCpo26());
                textViewSHK04CPO27ItemRot.setText(itemRotulo.get(0).getCpo27());
                textViewSHK04CPO28ItemRot.setText(itemRotulo.get(0).getCpo28());
            }else{
                enviarErro(respErro);
            }
        }

        public void getSMOBA03000(String _conexao, String _lote, String _cpo03) {
            Log.e("SHK04MenuDetalhe -> ", "getSMOBA03000");

            request = new SoapObject(NAMESPACE, METHOD);
            envelope = new SoapSerEnv(SoapEnvelope.VER11);
            androidHttpTransport = new HttpTransportSE(URL);

            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            request.addProperty("_CCONEXAO", _conexao);
            request.addProperty("_CLOTE", _lote);
            request.addProperty("_CTPRET", "D");
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
                    item = new Item(
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
                    if (i == 0) {
                        itemRotulo.add(item);
                    } else {
                        items.add(item);
                    }
                }
                Log.v("DADOS_WS_CAPTURADO ", response.toString());
            } catch (Exception e) {
                Log.e("SHK04MenuDetalhe ->", "Error on soapObjectData() " + e.getMessage());
                if(envelope.bodyIn != null){
                    respErro = envelope.bodyIn.toString();
                }else {
                    Class c = e.getClass();
                    respErro = c.getName();
                }
                erro = true;//1
            }
        }
        public void enviarErro(String _erro){
            String erro = _erro;
            respErro = null;
            Intent intentSHK99 = new Intent(SHK04MenuDetalhe.this, SHK99ErroActivity.class);
            intentSHK99.putExtra("ERRO", erro);
            startActivity(intentSHK99);
        }
    }


    private class WebServiceLib extends AsyncTask<String, Object, String> {

        //private final String NAMESPACE = "http://177.11.31.87:23973/";
        private final String NAMESPACE = "http://10.1.17.100:8013/";
        private final String SOAP_SERVICE = "ws/WSMOBILE04000.apw";
        private final String URL = NAMESPACE + SOAP_SERVICE;
        private final String METHOD = "SMOBA04001";
        private final String SOAP_ACTION = NAMESPACE + METHOD;

        private SoapObject request = null;
        private SoapObject results = null;
        private SoapObject response = null;
        private SoapObject liberacao = null;
        private SoapObject libera = null;
        private SoapSerEnv envelope = null;
        private HttpTransportSE androidHttpTransport = null;
        boolean erro = false;
        String msg = "";

        public WebServiceLib() {

        }

        @Override
        protected String doInBackground(String... params) {
            Log.e("SHK04MenuDetalhe/WebServiceLibera -> ", "doInBackground");

            try {
                getSMOBA04001(params[0], params[1], params[2], params[3]);
                //Atualiza a interface através do onProgressUpdate
            } catch (Exception e) {
                e.printStackTrace();
                enviarErro(respErro);
            }
            return null; //

        }
        @Override
        protected void onPreExecute() {
            Log.e("SHK04menudetalhey/WebServiceLibera -> ", "onPreExecute");

            progressBarSHK04MenuDet.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String strings) {
            Log.e("SHK01LoginActivity/WebService -> ", "onPostExecute");
            progressBarSHK04MenuDet.setVisibility(View.GONE);

            Context contexto = getApplicationContext();
            int duracao = Toast.LENGTH_SHORT;

            if (erro == false){
                Toast toast = Toast.makeText(contexto, msg,duracao);
                toast.show();
                Intent intentSHK04 = new Intent(SHK04MenuDetalhe.this, SHK03MenuResumoActivity.class);
                intentSHK04.putExtra("CPO03", cpo03);
                intentSHK04.putExtra("CPO04", cpo04);
                intentSHK04.putParcelableArrayListExtra("USUARIO", usuarios);
                intentSHK04.putParcelableArrayListExtra("MENNU", mennus);
                startActivity(intentSHK04);
                finish();
            }else {
                enviarErro(respErro);
            }
        }

        private void getSMOBA04001(String _conexao, String _lote, String _libRej, String _cpo03){
            Log.e("SHK04MenuDetalhe/WebServiceLiberacao -> ", "getSMOBA04001");

            request = new SoapObject(NAMESPACE, METHOD);
            envelope = new SoapSerEnv(SoapEnvelope.VER11);
            androidHttpTransport = new HttpTransportSE(URL);

            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            request.addProperty("_CCONEXAO", _conexao);
            request.addProperty("_CLOTE", _lote);
            request.addProperty("_CTPLR", _libRej);
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

                    msg =  libera.getProperty(0).toString();
                    libera.getProperty(i).toString();
                }
                Log.v("DADOS_WS_CAPTURADO ", response.toString());
            }
            catch(Exception e){
                Log.e("SHK04MenuDetalhe/WebServiceLiberacao -> ", "Error on soapObjectData() " + e.getMessage());
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
            Intent intentSHK99 = new Intent(SHK04MenuDetalhe.this, SHK99ErroActivity.class);
            intentSHK99.putExtra("ERRO", erro);
            startActivity(intentSHK99);
        }
}

