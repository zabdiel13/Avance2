package com.example.adrianzabdiel.avance2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView mImageView;
    private final String ruta= Environment.getExternalStoragePublicDirectory
            (Environment.DIRECTORY_PICTURES) + "/Pictures/";
    private File file = new File(ruta);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        file.mkdirs();
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
        Button btnfoto=(Button)findViewById(R.id.button3);
        listView =(ListView)findViewById(R.id.listView);
        mImageView=findViewById(R.id.imagen);
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

    public void tomarFoto(View view){
        String file = ruta + getCode() + ".jpg";
        File miFoto = new File(file);
        try {
            miFoto.createNewFile();
        } catch(IOException x){
            Log.e("Error", "ERROR:"+x);
        }
        Uri uri = Uri.fromFile(miFoto);
        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    private String getCode(){
        SimpleDateFormat formato=new SimpleDateFormat("yyyymmdd");
        String fecha = formato.format(new Date());
        String code = "pic_"+ fecha;
        return code;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extra =data.getExtras();
            Bitmap imageBitmap =(Bitmap)extra.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
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
