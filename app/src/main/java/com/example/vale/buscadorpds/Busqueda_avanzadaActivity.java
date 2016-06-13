package com.example.vale.buscadorpds;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class Busqueda_avanzadaActivity extends AppCompatActivity {
    String ip = "192.168.0.3";
    String NAMESPACE = "http://serviciosweb";
    String URL = "http://" + ip + ":8080/TallerJSP/services/WebServiceProveedor?wsdl";
    String SOAP_ACTION = "http://" + ip + ":8080/TallerJSP/services/WebServiceProveedor";
    String METHOD_NAME = "busquedaSimple";

    EditText textoBusquedaAva;
    TextView textViewResultadoAva;
    Button btn_enviar_avan;
    String criteria_avan;
    String resultado_avan;
    String TAG;

    EditText editTextRun;
    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextEmail;
    EditText editTextTelefono;
    EditText editTextPais;
    EditText editTextRegion;
    EditText editTextCiudad;

    String Run;
    String Nombre;
    String Apellido;
    String Mail;
    String Telefono;
    String Pais;
    String Region;
    String Ciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_avanzada);
        editTextRun = (EditText) findViewById(R.id.editTextRun);
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextApellido = (EditText) findViewById(R.id.editTextApellido);
        editTextEmail = (EditText) findViewById(R.id.editTextMail);
        editTextTelefono = (EditText) findViewById(R.id.editTextTelefono);
        editTextPais = (EditText) findViewById(R.id.editTextPais);
        editTextRegion = (EditText) findViewById(R.id.editTextRegion);
       // editTextCiudad = (EditText) findViewById(R.id.editTextCiudad);

        textViewResultadoAva = (TextView) findViewById(R.id.textViewRaw);
        btn_enviar_avan = (Button) findViewById(R.id.btn_enviarAvan);

        btn_enviar_avan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextRun.getText().toString().equals("") && editTextRun.getText().length() != 0) {
                    Run = editTextRun.getText().toString();
                } else {
                    Run = "";
                }

                if (!editTextNombre.getText().toString().equals("") && editTextNombre.getText().length() != 0) {
                    Nombre = editTextNombre.getText().toString();
                } else {
                    Nombre = "";
                }

                if (!editTextApellido.getText().toString().equals("") && editTextApellido.getText().length() != 0) {
                   Apellido = editTextApellido.getText().toString();
                } else {
                    Apellido = "";
                }

                if (!editTextEmail.getText().toString().equals("") && editTextEmail.getText().length() != 0) {
                    Mail = editTextEmail.getText().toString();
                } else {
                    Mail = "";
                }

                if (!editTextTelefono.getText().toString().equals("") && editTextTelefono.getText().length() != 0) {
                    Telefono = editTextTelefono.getText().toString();
                } else {
                    Telefono = "";
                }

                if (!editTextPais.getText().toString().equals("") && editTextPais.getText().length() != 0) {
                    Pais = editTextPais.getText().toString();
                } else {
                    Pais = "";
                }

                if (!editTextRegion.getText().toString().equals("") && editTextRegion.getText().length() != 0) {
                   Region = editTextRegion.getText().toString();
                } else {
                    Region = "";
                }
                if (!editTextCiudad.getText().toString().equals("") && editTextCiudad.getText().length() != 0) {
                   Ciudad = editTextCiudad.getText().toString();
                } else {
                    Ciudad = "";
                }
                generateAsyncTask task = new generateAsyncTask();
                task.execute();
            }
        });


    }

    public void obtenerResultado(String strRun,
                               String strNombre,
                               String strApellido,
                               String strMail,
                               String strTelefono,
                               String strPais,
                               String strRegion, String strCiudad) {

        SoapObject query = new SoapObject(NAMESPACE, METHOD_NAME);
        List<PropertyInfo> properties = new ArrayList<PropertyInfo>();
        PropertyInfo propIn = new PropertyInfo();

        propIn.setName("run");
        propIn.setValue(strRun);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);

        propIn = new PropertyInfo();
        propIn.setName("nombre");
        propIn.setValue(strNombre);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);

        propIn = new PropertyInfo();
        propIn.setName("apellido");
        propIn.setValue(strApellido);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);

        propIn = new PropertyInfo();
        propIn.setName("mail");
        propIn.setValue(strMail);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);

        propIn = new PropertyInfo();
        propIn.setName("telefono");
        propIn.setValue(strTelefono);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);

        propIn = new PropertyInfo();
        propIn.setName("direccion");
        propIn.setValue(strPais);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);

        propIn = new PropertyInfo();
        propIn.setName("region");
        propIn.setValue(strRegion);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);

        propIn = new PropertyInfo();
        propIn.setName("ciudad");
        propIn.setValue(strCiudad);
        propIn.setType(String.class);
        properties.add(propIn);
        query.addProperty(propIn);


        SoapSerializationEnvelope toSend = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        toSend.dotNet = true;

        toSend.setOutputSoapObject(query);

        HttpTransportSE transportHttp = new HttpTransportSE(URL);

        try {
            transportHttp.call(SOAP_ACTION, toSend);

            SoapPrimitive response = (SoapPrimitive) toSend.getResponse();

            resultado_avan = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class generateAsyncTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params){
            Log.i(TAG, "doInBackground");
           obtenerResultado(Run, Nombre, Apellido,Mail, Telefono, Pais, Region,Ciudad);
            return null;
        }

        @Override
        protected void onPostExecute(Void results){
            Log.i(TAG, "onPostExecute");
            textViewResultadoAva.setText(resultado_avan);
        }

        @Override
        protected void onPreExecute(){
            Log.i(TAG, "onPreExecute");
            textViewResultadoAva.setText("Buscando");
        }

        @Override
        protected void  onProgressUpdate(Void... values){
            Log.i(TAG, "onProgressUpdate");
        }
    }
}