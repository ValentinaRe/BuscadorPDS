package com.example.vale.buscadorpds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vale on 16-06-16.
 */
public class Ver_perfil_activity  extends AppCompatActivity {
    TextView rut;
    TextView nombre;
    TextView apellido;
    TextView mail;
    TextView telefono;
    TextView pais;
    TextView region;
    TextView ciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil);

        rut= (TextView) findViewById(R.id.rut);
        nombre= (TextView) findViewById(R.id.nombre);
        apellido= (TextView) findViewById(R.id.apellido);
        mail= (TextView) findViewById(R.id.mail);
        telefono= (TextView) findViewById(R.id.telefono);
        pais= (TextView) findViewById(R.id.pais);
        region= (TextView) findViewById(R.id.region);
        ciudad= (TextView) findViewById(R.id.ciudad);




        Bundle bun= this.getIntent().getExtras();

        rut.setText(bun.getString("rut"));
        nombre.setText(bun.getString("nombre"));
        apellido.setText(bun.getString("apellido"));
        mail.setText(bun.getString("mail"));
        telefono.setText(bun.getString("telefono"));
        pais.setText(bun.getString("pais"));
        region.setText(bun.getString("region"));
        ciudad.setText(bun.getString("ciudad"));








    }

}
