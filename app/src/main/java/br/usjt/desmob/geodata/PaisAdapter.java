package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by kauemirkai on 28/03/2018.
 */

public class PaisAdapter extends BaseAdapter {
    private Pais[] paises;
    private Activity activity;

    public PaisAdapter(Pais[] paises, Activity activity) {
        this.paises = paises;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int position) {
        return paises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, parent, false);
            ImageView bandeira = (ImageView) view.findViewById(R.id.foto_pais);
            TextView nome = (TextView) view.findViewById(R.id.texto_nome_pais);
            TextView detalhe = (TextView) view.findViewById(R.id.texto_detalhe_pais);
            ViewHolder viewHolder = new ViewHolder(bandeira, nome, detalhe);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getNome().setText(paises[position].getNome());
        viewHolder.getDetalhe().setText(String.format(
                activity.getResources().getString(R.string.lbl_regiao)+
                        " %s - "+
                        activity.getResources().getString(R.string.lbl_capital)+
                        " %s",
                paises[position].getRegiao(),
                paises[position].getCapital()));
        Drawable drawable = br.usjt.desmob.geodata.Util.getDrawable(activity, paises[position].getCodigo3().toLowerCase());
        viewHolder.getBandeira().setImageDrawable(drawable);

        return view;
    }
}

