package com.example.padelwear;

import android.content.Context;
import android.support.wear.widget.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Miguel Á. Núñez on 13/05/2018.
 */
final class Adaptador extends WearableRecyclerView.Adapter {
    private String[] datos;
    private final Context contexto;
    private final LayoutInflater inflador;
    protected View.OnClickListener onClickListener;

    public Adaptador(Context contexto, String[] datos) {
        this.contexto = contexto;
        this.datos = datos;
        inflador = LayoutInflater.from(contexto);
    }

    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    public static class ItemViewHolder extends WearableRecyclerView.ViewHolder {
        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.nombre);
        }
    }

    // Creamos el ViewHolder con las vista de un elemento sin personalizar
    @Override
    public WearableRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos la vista desde el xml
        View v = inflador.inflate(R.layout.elemento_lista, null);
        v.setOnClickListener(onClickListener);
        return new ItemViewHolder(v);
    }

    // Usando como base el ViewHolder y lo personalizamos
    @Override
    public void onBindViewHolder(WearableRecyclerView.ViewHolder holder, int posicion) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        TextView view = itemHolder.textView;
        view.setText(datos[posicion]);
        holder.itemView.setTag(posicion);
    }

    // Indicamos el número de elementos de la lista
    @Override
    public int getItemCount() {
        return datos.length;
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
