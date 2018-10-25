package com.example.adrianzabdiel.avance2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CurpViewHolder> {
    private Context mainContext;
    private List<Usuario> items;

    public UserAdapter(List<Usuario> items, Context contexto) {
        this.mainContext = contexto;
        this.items = items;
    }

    static class CurpViewHolder extends RecyclerView.ViewHolder {
        protected TextView curp;
        protected TextView nombres;
        protected TextView apellidos;
        protected TextView nacimiento;
        protected TextView mes;
        protected TextView year;
        protected TextView sexo;
        protected TextView state;


        public CurpViewHolder(View v) {
            super(v);

            this.curp = (TextView) v.findViewById(R.id.curp);
            this.nombres = (TextView) v.findViewById(R.id.nombre);
            this.apellidos = (TextView) v.findViewById(R.id.Apellidos);
            this.nacimiento = (TextView) v.findViewById(R.id.Nacimiento);
            this.mes =(TextView) v.findViewById(R.id.Mes);
            this.year = (TextView) v.findViewById(R.id.year);
            this.sexo = (TextView) v.findViewById(R.id.sex);
            this.state = (TextView) v.findViewById(R.id.state);

        }
    }


    public CurpViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_carta_curso_adapter, viewGroup, false);
        return new CurpViewHolder(v);
    }

    public void onBindViewHolder(CurpViewHolder viewHolder, int position) {
        Usuario item = items.get(position);
        viewHolder.itemView.setTag(item);

        viewHolder.curp.setText("Curp: "+item.getUsuario());
        viewHolder.nombres.setText("Nombre: " +  item.getNombres());
        viewHolder.apellidos.setText("Apellido: " +  item.getApellidos());
        viewHolder.nacimiento.setText("Nacimiento Dia: " + item.getNacimiento());
        viewHolder.mes.setText("Mes: "+item.getMes());
        viewHolder.year.setText("Año " +  item.getYear());
        viewHolder.sexo.setText("Sexo: " +  item.getSexo());
        viewHolder.state.setText("Estado: " + item.getState());
    }

    public int getItemCount() {
        return items.size();
    }
}
