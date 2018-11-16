package com.example.adrianzabdiel.avance2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


    public Context context = this;
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
        Log.d("hola", "Consulta: ");
        Intent intent = new Intent(context,Main3Activity.class);
        startActivity(intent);
    }

    protected void onDestroy() {
        manager.cerrar();
        super.onDestroy();
    }

    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onCreateItemSelected(MenuItem opcion){
        switch (opcion.getItemId()){
            case R.id.Return:
                finish();
                return true;
            default:
                onBackPressed();
                return true;
        }
    }
    @Override
    public void onClick(View v) {

    }
}
