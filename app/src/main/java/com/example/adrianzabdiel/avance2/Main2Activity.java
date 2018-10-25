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

    private Button btnInsertar,btnActualizar, btnBorrar,btnConsultar;
    private DataBaseManagerUsuario managerCurso;
    private RecyclerView recycler;
    private UserAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Usuario> listaItemsCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        managerCurso= new DataBaseManagerUsuario(this);
        adViews();
        inicializarRecicler();
    }

    private void adViews() {
        btnInsertar=(Button) findViewById(R.id.btnInsertar);
        btnInsertar.setOnClickListener(this);

        btnBorrar=(Button) findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(this);

        btnActualizar=(Button) findViewById(R.id.btnActalizar);
        btnActualizar.setOnClickListener(this);

        btnConsultar=(Button) findViewById(R.id.btnConsulta);
        btnConsultar.setOnClickListener(this);


    }

    public void inicializarRecicler() {

        listaItemsCursos = managerCurso.getUsuarioList();

        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        adapter = new UserAdapter(listaItemsCursos, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());

    }

    public void Insertar(View view){
        managerCurso.insertar_parametros("Curp: ", "Nombre: ", "Apellido ","Fecha de nacimiento",
                " ", " ", "Sexo: ", "Entidad: ");
    }
    public void Borrar(View view){
        managerCurso.eliminarTodo();
    }
    public void Reciclar(View view){
        int i=0;
        managerCurso.actualizar_parametros(listaItemsCursos.get(i).getUsuario(), "Nombre: "+i, "Apellido "+i,"Fecha de nacimiento",
                " ", " ", "Sexo: ", "Entidad: ");
    }
    public void Consulta(View view) {

        listaItemsCursos = managerCurso.getUsuarioList();
        adapter = new UserAdapter(listaItemsCursos, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }

    protected void onDestroy() {

        managerCurso.cerrar();

        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }
}
