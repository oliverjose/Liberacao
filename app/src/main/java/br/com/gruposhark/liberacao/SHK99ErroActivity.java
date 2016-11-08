package br.com.gruposhark.liberacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SHK99ErroActivity extends AppCompatActivity {

    TextView textViewErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shk99_erro);

        textViewErro = (TextView) findViewById(R.id.textViewErro);


        Intent it = getIntent();
        String erro = it.getStringExtra("ERRO");

        String resposta = null;

        switch (erro)
//java.lang.IllegalArgumentException
        {
            case "SoapFault - faultcode: 'Sender' faultstring: 'SMOBA01001 : Senha Invalida!' faultactor: 'null' detail: null":
                Log.e("CATCH - > SMOBA01001", "Usuario ou senha incorreto ");
                resposta = "USUARIO e/ou SENHA INVALIDO.";
                textViewErro.setText(resposta);
                break;
            case "SoapFault - faultcode: 'Sender' faultstring: 'SMOBA01001 : Favor solicitar liberação do aparelho!' faultactor: 'null' detail: null":
                Log.e("CATCH - > SMOBA01001", "Usuario ou senha incorreto ");
                resposta = "Entrar em contato no link 10624, solicitar a liberação do dispositivo.";
                textViewErro.setText(resposta);
                break;
            case "java.net.SocketTimeoutException":
                Log.e("CATCH - > SMOBA01001", "Servidor não encontrado");
                resposta = "Entrar em contato no link 10276 informar a mensagem:\nServidor não encontrado'";
                textViewErro.setText(resposta);
                break;
            case "java.net.ConnectException":
                Log.e("CATCH - > SMOBA01001", "Servidor não encontrado");
                resposta = "Entrar em contato no link 10276 informar a mensagem:\nConectar falhou após 20000ms: Rede está inacessível ";
                textViewErro.setText(resposta);
                break;
            case "java.lang.IllegalArgumentException":
                Log.e("CATCH - > SMOBA01001", "Porta do serviço incorreto");
                resposta = "Entrar em contato no link 10276 informar a mensagem:\nPorta do serviço não encontrada.";
                textViewErro.setText(resposta);
                break;
            case "Conexão: Sem conexão com internet":
                resposta = "Conexão: Sem conexão com internet";
                textViewErro.setText(resposta);
                break;


            case "SoapFault - faultcode:":
                textViewErro.setText(resposta);
        }
    }


    public void erro_onClick(View view) {
        Log.e("SHK99ErroActivity -> ", "erro_onClick");
        Intent intentSHK02 = new Intent(this, SHK00MainActivity.class);
        startActivity(intentSHK02);
        finish();
    }

}
