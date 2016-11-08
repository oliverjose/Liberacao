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
import model.Item;


/**
 * Created by Admin on 31/10/2016.
 */
public class SHK04ItemAdapter extends BaseAdapter {

    private Context context;
    private List<Item> itemList;

    public SHK04ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {

        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = itemList.get(position);
        View linha = LayoutInflater.from(context).inflate(R.layout.layout_shk04_mennu_detalhe, null);

        TextView textViewSHK04CPO01Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO01Item);
        TextView textViewSHK04CPO02Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO02Item);
        TextView textViewSHK04CPO03Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO03Item);
        TextView textViewSHK04CPO04Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO04Item);
        TextView textViewSHK04CPO05Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO05Item);
        TextView textViewSHK04CPO06Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO06Item);
        TextView textViewSHK04CPO07Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO07Item);
        TextView textViewSHK04CPO08Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO08Item);
        TextView textViewSHK04CPO09Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO09Item);
        TextView textViewSHK04CPO10Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO10Item);
        TextView textViewSHK04CPO11Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO11Item);
        TextView textViewSHK04CPO12Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO12Item);
        TextView textViewSHK04CPO13Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO13Item);
        TextView textViewSHK04CPO14Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO14Item);
        TextView textViewSHK04CPO15Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO15Item);
        TextView textViewSHK04CPO16Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO16Item);
        TextView textViewSHK04CPO17Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO17Item);
        TextView textViewSHK04CPO18Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO18Item);
        TextView textViewSHK04CPO19Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO19Item);
        TextView textViewSHK04CPO20Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO20Item);
        TextView textViewSHK04CPO21Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO21Item);
        TextView textViewSHK04CPO22Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO22Item);
        TextView textViewSHK04CPO23Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO23Item);
        TextView textViewSHK04CPO24Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO24Item);
        TextView textViewSHK04CPO25Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO25Item);
        TextView textViewSHK04CPO26Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO26Item);
        TextView textViewSHK04CPO27Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO27Item);
        TextView textViewSHK04CPO28Item = (TextView) linha.findViewById(R.id.textViewSHK04CPO28Item);
        
        if(item.getCpo27().toString().equals("B0")){
            textViewSHK04CPO01Item.setText(item.getCpo01());
            textViewSHK04CPO01Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO02Item.setText(item.getCpo02());
            textViewSHK04CPO02Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO03Item.setText(item.getCpo03());
            textViewSHK04CPO03Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO04Item.setText(item.getCpo04());
            textViewSHK04CPO04Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO05Item.setText(item.getCpo05());
            textViewSHK04CPO05Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO06Item.setText(item.getCpo06());
            textViewSHK04CPO06Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO07Item.setText(item.getCpo07());
            textViewSHK04CPO07Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO08Item.setText(item.getCpo08());
            textViewSHK04CPO08Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO09Item.setText(item.getCpo09());
            textViewSHK04CPO09Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO10Item.setText(item.getCpo10());
            textViewSHK04CPO10Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO11Item.setText(item.getCpo11());
            textViewSHK04CPO11Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO12Item.setText(item.getCpo12());
            textViewSHK04CPO12Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO13Item.setText(item.getCpo13());
            textViewSHK04CPO13Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO14Item.setText(item.getCpo14());
            textViewSHK04CPO14Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO15Item.setText(item.getCpo15());
            textViewSHK04CPO15Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO16Item.setText(item.getCpo16());
            textViewSHK04CPO16Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO17Item.setText(item.getCpo17());
            textViewSHK04CPO17Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO18Item.setText(item.getCpo18());
            textViewSHK04CPO18Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO19Item.setText(item.getCpo19());
            textViewSHK04CPO19Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO20Item.setText(item.getCpo20());
            textViewSHK04CPO20Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO21Item.setText(item.getCpo21());
            textViewSHK04CPO21Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO22Item.setText(item.getCpo22());
            textViewSHK04CPO22Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO23Item.setText(item.getCpo23());
            textViewSHK04CPO23Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO24Item.setText(item.getCpo24());
            textViewSHK04CPO24Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO25Item.setText(item.getCpo25());
            textViewSHK04CPO25Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO26Item.setText(item.getCpo26());
            textViewSHK04CPO26Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO27Item.setText(item.getCpo27());
            textViewSHK04CPO27Item.setTextColor(Color.parseColor("#FFED4F54"));
            textViewSHK04CPO28Item.setText(item.getCpo28());
            textViewSHK04CPO28Item.setTextColor(Color.parseColor("#FFED4F54"));
        }else {

            textViewSHK04CPO01Item.setText(item.getCpo01());
            textViewSHK04CPO02Item.setText(item.getCpo02());
            textViewSHK04CPO03Item.setText(item.getCpo03());
            textViewSHK04CPO04Item.setText(item.getCpo04());
            textViewSHK04CPO05Item.setText(item.getCpo05());
            textViewSHK04CPO06Item.setText(item.getCpo06());
            textViewSHK04CPO07Item.setText(item.getCpo07());
            textViewSHK04CPO08Item.setText(item.getCpo08());
            textViewSHK04CPO09Item.setText(item.getCpo09());
            textViewSHK04CPO10Item.setText(item.getCpo10());
            textViewSHK04CPO11Item.setText(item.getCpo11());
            textViewSHK04CPO12Item.setText(item.getCpo12());
            textViewSHK04CPO13Item.setText(item.getCpo13());
            textViewSHK04CPO14Item.setText(item.getCpo14());
            textViewSHK04CPO15Item.setText(item.getCpo15());
            textViewSHK04CPO16Item.setText(item.getCpo16());
            textViewSHK04CPO17Item.setText(item.getCpo17());
            textViewSHK04CPO18Item.setText(item.getCpo18());
            textViewSHK04CPO19Item.setText(item.getCpo19());
            textViewSHK04CPO20Item.setText(item.getCpo20());
            textViewSHK04CPO21Item.setText(item.getCpo21());
            textViewSHK04CPO22Item.setText(item.getCpo22());
            textViewSHK04CPO23Item.setText(item.getCpo23());
            textViewSHK04CPO24Item.setText(item.getCpo24());
            textViewSHK04CPO25Item.setText(item.getCpo25());
            textViewSHK04CPO26Item.setText(item.getCpo26());
            textViewSHK04CPO27Item.setText(item.getCpo27());
            textViewSHK04CPO28Item.setText(item.getCpo28());
        }
              return linha;
    }

    static class ViewHolder{
        TextView textViewSHK04CPO01Item;
        TextView textViewSHK04CPO02Item;
        TextView textViewSHK04CPO03Item;
        TextView textViewSHK04CPO04Item;
        TextView textViewSHK04CPO05Item;
        TextView textViewSHK04CPO06Item;
        TextView textViewSHK04CPO07Item;
        TextView textViewSHK04CPO08Item;
        TextView textViewSHK04CPO09Item;
        TextView textViewSHK04CPO10Item;
        TextView textViewSHK04CPO11Item;
        TextView textViewSHK04CPO12Item;
        TextView textViewSHK04CPO13Item;
        TextView textViewSHK04CPO14Item;
        TextView textViewSHK04CPO15Item;
        TextView textViewSHK04CPO16Item;
        TextView textViewSHK04CPO17Item;
        TextView textViewSHK04CPO18Item;
        TextView textViewSHK04CPO19Item;
        TextView textViewSHK04CPO20Item;
        TextView textViewSHK04CPO21Item;
        TextView textViewSHK04CPO22Item;
        TextView textViewSHK04CPO23Item;
        TextView textViewSHK04CPO24Item;
        TextView textViewSHK04CPO25Item;
        TextView textViewSHK04CPO26Item;
        TextView textViewSHK04CPO27Item;
        TextView textViewSHK04CPO28Item;
    }

}
