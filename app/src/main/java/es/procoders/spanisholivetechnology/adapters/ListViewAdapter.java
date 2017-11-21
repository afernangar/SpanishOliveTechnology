package es.procoders.spanisholivetechnology.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.procoders.spanisholivetechnology.R;
import es.procoders.spanisholivetechnology.beans.Respuesta;

/**
 * @author Procoders
 * @since API 21
 * @version 1.0
 */

/*Este adaptador nos permite cargar las preguntas de los formularios y seleccionarlas para rellenarlas una por una.*/
public class ListViewAdapter extends ArrayAdapter<Respuesta> {

    private Context ctx;
    private ArrayList<Respuesta> lista;

    public ListViewAdapter(Context ctx, ArrayList<Respuesta> lista) {
        super(ctx,0,lista);
        this.ctx = ctx;
        this.lista = lista;


    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Respuesta getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Respuesta user = lista.get(position);
        view = LayoutInflater.from(getContext()).inflate(R.layout.list_simple_item, parent, false);
        TextView desc = (TextView) view.findViewById(R.id.idDescription);
        TextView name = (TextView) view.findViewById(R.id.mainListView);
        ImageView image = view.findViewById(R.id.imageListView);
        if (user.getPregunta().isRequired()){
            image.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_info));
        }
        if (user.getStr() != null){
            desc.setText(user.getStr());
        }
        name.setText(user.getPregunta().getStr());
        return view;
    }
}

