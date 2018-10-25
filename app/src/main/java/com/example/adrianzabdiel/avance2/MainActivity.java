package com.example.adrianzabdiel.avance2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nombres = (EditText) findViewById(R.id.editText19);
        final EditText apellidos = (EditText) findViewById(R.id.editText16);
        final EditText sexo = (EditText) findViewById(R.id.editText);
        final EditText nacimiento = (EditText) findViewById(R.id.editText22);
        final EditText mes = (EditText) findViewById(R.id.editText23);
        final EditText year = (EditText) findViewById(R.id.editText24);
        final String state = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener (new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Usuario usuario = new Usuario(nombres.getText().toString(), apellidos.getText().toString(), sexo.getText().toString(), nacimiento.getText().toString(), mes.getText().toString(), year.getText().toString(), state);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
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
}