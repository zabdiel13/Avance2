package com.example.adrianzabdiel.avance2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private Button mInsertar;
    private Button mActualizar;
    private Button mBorrar;
    private Button mConsultar;
    private DataBaseManagerUsuario manager;
    private RecyclerView recycler;
    private UserAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Usuario> listaItemsUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        manager= new DataBaseManagerUsuario(this);
        adViews();
        inicializarRecicler();
    }

    private void adViews() {
        mInsertar=(Button) findViewById(R.id.boton_insertar);
        mInsertar.setOnClickListener(this);
        mBorrar=(Button) findViewById(R.id.boton_borrar);
        mBorrar.setOnClickListener(this);
        mActualizar=(Button) findViewById(R.id.actualizar);
        mActualizar.setOnClickListener(this);
        mConsultar=(Button) findViewById(R.id.consultar);
        mConsultar.setOnClickListener(this);


    }

    public void inicializarRecicler() {

        listaItemsUsuario = manager.getUsuarioList();
        lManager = new LinearLayoutManager(this);
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(lManager);
        adapter = new UserAdapter(listaItemsUsuario, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());

    }

    public void Insertar(View view){
        manager.insertar_parametros("Curp: ", "Nombre: ", "Apellido ","Fecha de nacimiento",
                " ", " ", "Sexo: ", "Entidad: ");
    }
    public void Borrar(View view){
        manager.eliminarTodo();
    }
    public void Reciclar(View view){
        int i=0;
        manager.actualizar_parametros(listaItemsUsuario.get(i).getUsuario(), "Nombre: "+i, "Apellido "+i,"Fecha de nacimiento",
                " ", " ", "Sexo: ", "Entidad: ");
    }
    public void Consulta(View view) {

        listaItemsUsuario = manager.getUsuarioList();
        adapter = new UserAdapter(listaItemsUsuario, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }

    protected void onDestroy() {
        manager.cerrar();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }
}
