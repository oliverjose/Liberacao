package br.com.gruposhark.liberacao;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


import model.Celular;


public class SHK00MainActivity extends AppCompatActivity {

    TextView textView4;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;

    LinearLayout linearApresentacao;

    Button buttonSHK00Entrar;
    Celular celular;
    ArrayList<Celular> celulars;

    private static int SPLASH_TIME_OUT = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shk00_main);

        // Fazer a verificação de rede no dispositivo
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        String s = "Conexão: ";
        if(wifi.isConnected()){
            s += "Conectando via Wi-Fi";
        }else if(mobile.isConnected()){
            s += "Conectando via Dados Móvel";
        }else {
            s += "Sem conexão com internet";
            Intent intentSHK00 = new Intent(this, SHK99ErroActivity.class);
            intentSHK00.putExtra("ERRO", s);
            startActivity(intentSHK00);
            finish();
        }
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SHK00Main -> ", "onStart");

        TelephonyManager telephonyManager = (TelephonyManager)
                getSystemService(Context.TELEPHONY_SERVICE);
        celulars = new ArrayList<Celular>();

        celular = new Celular(
                telephonyManager.getDeviceId(),
                telephonyManager.getSimSerialNumber()
        );

        celulars.add((Celular) celular);


        Intent intentSHK01 = new Intent(this, SHK01LoginActivity.class);
        intentSHK01.putParcelableArrayListExtra("CELULAR", celulars);
        startActivity(intentSHK01);
        finish();
    }

}
