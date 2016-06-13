package com.example.vale.buscadorpds;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn_main_simple= (Button) findViewById(R.id.btn_simple);{
            btn_main_simple.setOnClickListener(new View.OnClickListener(){
                @Override
                public  void onClick(View view){
                    Intent intentActivitySimple = new Intent(MainActivity.this, Busqueda_simpleActivity.class);
                    startActivity(intentActivitySimple);
                }
            });
        }
        Button btn_main_avanzada=(Button) findViewById(R.id.btn_avan);{
<<<<<<< HEAD
            btn_main_avanzada.setOnClickListener(new View.OnClickListener(){
                @Override
                public  void onClick(View view){
                    Intent intentActivityAvanz = new Intent(MainActivity.this, Busqueda_avanzadaActivity.class);
                    startActivity(intentActivityAvanz);
                }
            });
=======
        btn_main_avanzada.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent intentActivityAvanz = new Intent(MainActivity.this, Busqueda_avanzadaActivity.class);
                startActivity(intentActivityAvanz);
            }
        });
>>>>>>> origin/master
    }

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
