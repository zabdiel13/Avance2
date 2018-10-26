package com.example.adrianzabdiel.avance2;

import android.content.Intent;
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
        onBackPressed();
    }
    public void Borrar(View view){
        manager.eliminarTodo();
    }

    public void Consulta(View view) {

        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(intent);
    }

    protected void onDestroy() {
        manager.cerrar();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }
}
