package es.procoders.spanisholivetechnology.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.procoders.spanisholivetechnology.R;
import es.procoders.spanisholivetechnology.beans.Formulario;

/**
 * @author Procoders
 * @version 1.0
 * @since API 21
 */

public class ListViewAdapterMain extends ArrayAdapter<Formulario> {

    /*Este adaptador nos carga nuestros formularios guardados en el singleton, ya sean de la bbdd o locales.*/

    private Context ctx;
    private ArrayList<Formulario> lista;

    public ListViewAdapterMain(Context ctx, ArrayList<Formulario> lista) {
        super(ctx,0,lista);
        this.ctx = ctx;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Formulario getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (getCount()>0) {
            Formulario user = lista.get(position);
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_simple_formulari, parent, false);
            TextView date = (TextView) view.findViewById(R.id.date_formulario);
            TextView name = (TextView) view.findViewById(R.id.mainListView);
            TextView estado = (TextView) view.findViewById(R.id.estado_listView);


            switch (user.getTipo()){
                case BIOMASA:
                    name.setText(R.string.Cbiomasa);
                    break;
                case ALMAZARA:
                    name.setText(R.string.CAlmazara);
                    break;
                case PLANTACION:
                    name.setText(R.string.CPlantacion);
                    break;
                case COMERCIOACEITE:
                    name.setText(R.string.Caceiteoliva);
                    break;
                case FABRICAACEITUNA:
                    name.setText(R.string.Cfabricaaceituna);
                    break;
                case COMERCIOACEITUNA:
                    name.setText(R.string.Ccomercioaceituna);
                    break;
            }
            if (user.getDate()!=null) {
                date.setText(user.getDate());
                switch (user.getEstado()){
                    case "enviado":
                        estado.setTextColor(view.getContext().getResources().getColor(android.R.color.holo_orange_light));
                        break;
                    case "visto":
                        estado.setTextColor(view.getContext().getResources().getColor(android.R.color.holo_blue_light));
                        break;
                    case "contestado":
                        estado.setTextColor(view.getContext().getResources().getColor(R.color.colorAccent));
                        break;
                }

                estado.setText(user.getEstado());
            }else{
                estado.setTextColor(view.getContext().getResources().getColor(android.R.color.holo_red_dark));
                estado.setText("No enviado");
            }

        }
        return view;
    }
}

