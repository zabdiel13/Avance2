package com.example.adrianzabdiel.avance2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final ListView listView;
        final List<String> user = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        Usuario usuario = extras.getParcelable("usuario");

        final TextView nombres = (TextView) findViewById(R.id.nom);
        nombres.setText(usuario.nombres);
        final TextView apellidos = (TextView) findViewById(R.id.ap);
        apellidos.setText(usuario.apellidos);
        final TextView sexo = (TextView) findViewById(R.id.genre);
        sexo.setText(usuario.sexo);
        final TextView nacimiento = (TextView) findViewById(R.id.born);
        nacimiento.setText(usuario.nacimiento);
        TextView mes = (TextView) findViewById(R.id.born2);
        mes.setText(usuario.mes);
        final TextView year = (TextView) findViewById(R.id.born3);
        year.setText(usuario.year);
        final TextView state = (TextView) findViewById(R.id.entidad);
        state.setText(usuario.state);
        final TextView curp = (TextView) findViewById(R.id.curp);
        curp.setText(usuario.getUsuario());
        Button boton=(Button)findViewById(R.id.button2);
        listView =(ListView)findViewById(R.id.listView);
        final ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,user);
        listView.setAdapter(Adapter);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                listView.setAdapter(null);
                String c=curp.getText().toString();
                user.add(c);
                listView.setAdapter(Adapter);
            }
        });
    }
}
