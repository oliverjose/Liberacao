package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.gruposhark.liberacao.R;
import model.MennuResumo;

/**
 * Created by Admin on 30/10/2016.
 */
public class SHK03MennuResAdapter extends BaseAdapter {

    private Context context;
    private List<MennuResumo> mennuResumoList;

    public SHK03MennuResAdapter(Context context, List<MennuResumo> mennuResumoList) {
        this.context = context;
        this.mennuResumoList = mennuResumoList;
    }


    @Override
    public int getCount() {
        return mennuResumoList.size();
    }

    @Override
    public Object getItem(int position) {


        return mennuResumoList.get(position);
    }

    @Override
    public long getItemId(int position) {


        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MennuResumo mennuResumo = mennuResumoList.get(position);
        View linha = LayoutInflater.from(context).inflate(R.layout.layout_shk03_mennu_resumo, null);

            //textViewSHK03CPO01
        TextView textViewSHK03CPO01Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO01Res);
        TextView textViewSHK03CPO02Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO02Res);
        TextView textViewSHK03CPO03Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO03Res);
        TextView textViewSHK03CPO04Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO04Res);
        TextView textViewSHK03CPO05Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO05Res);
        TextView textViewSHK03CPO06Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO06Res);
        TextView textViewSHK03CPO07Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO07Res);
        TextView textViewSHK03CPO08Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO08Res);
        TextView textViewSHK03CPO09Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO09Res);
        TextView textViewSHK03CPO10Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO10Res);
        TextView textViewSHK03CPO11Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO11Res);
        TextView textViewSHK03CPO12Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO12Res);
        TextView textViewSHK03CPO13Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO13Res);
        TextView textViewSHK03CPO14Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO14Res);
        TextView textViewSHK03CPO15Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO15Res);
        TextView textViewSHK03CPO16Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO16Res);
        TextView textViewSHK03CPO17Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO17Res);
        TextView textViewSHK03CPO18Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO18Res);
        TextView textViewSHK03CPO19Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO19Res);
        TextView textViewSHK03CPO20Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO20Res);
        TextView textViewSHK03CPO21Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO21Res);
        TextView textViewSHK03CPO22Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO22Res);
        TextView textViewSHK03CPO23Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO23Res);
        TextView textViewSHK03CPO24Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO24Res);
        TextView textViewSHK03CPO25Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO25Res);
        TextView textViewSHK03CPO26Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO26Res);
        TextView textViewSHK03CPO27Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO27Res);
        TextView textViewSHK03CPO28Res = (TextView) linha.findViewById(R.id.textViewSHK03CPO28Res);

        textViewSHK03CPO01Res.setText(mennuResumo.getCpo01());
        textViewSHK03CPO02Res.setText(mennuResumo.getCpo02());
        textViewSHK03CPO03Res.setText(mennuResumo.getCpo03());
        textViewSHK03CPO04Res.setText(mennuResumo.getCpo04());
        textViewSHK03CPO05Res.setText(mennuResumo.getCpo05());
        textViewSHK03CPO06Res.setText(mennuResumo.getCpo06());
        textViewSHK03CPO07Res.setText(mennuResumo.getCpo07());
        textViewSHK03CPO08Res.setText(mennuResumo.getCpo08());
        textViewSHK03CPO09Res.setText(mennuResumo.getCpo09());
        textViewSHK03CPO10Res.setText(mennuResumo.getCpo10());
        textViewSHK03CPO11Res.setText(mennuResumo.getCpo11());
        textViewSHK03CPO12Res.setText(mennuResumo.getCpo12());
        textViewSHK03CPO13Res.setText(mennuResumo.getCpo13());
        textViewSHK03CPO14Res.setText(mennuResumo.getCpo14());
        textViewSHK03CPO15Res.setText(mennuResumo.getCpo15());
        textViewSHK03CPO16Res.setText(mennuResumo.getCpo16());
        textViewSHK03CPO17Res.setText(mennuResumo.getCpo17());
        textViewSHK03CPO18Res.setText(mennuResumo.getCpo18());
        textViewSHK03CPO19Res.setText(mennuResumo.getCpo19());
        textViewSHK03CPO20Res.setText(mennuResumo.getCpo20());
        textViewSHK03CPO21Res.setText(mennuResumo.getCpo21());
        textViewSHK03CPO22Res.setText(mennuResumo.getCpo22());
        textViewSHK03CPO23Res.setText(mennuResumo.getCpo23());
        textViewSHK03CPO24Res.setText(mennuResumo.getCpo24());
        textViewSHK03CPO25Res.setText(mennuResumo.getCpo25());
        textViewSHK03CPO26Res.setText(mennuResumo.getCpo26());
        textViewSHK03CPO27Res.setText(mennuResumo.getCpo27());
        textViewSHK03CPO28Res.setText(mennuResumo.getCpo28());

        return linha;
    }
}
