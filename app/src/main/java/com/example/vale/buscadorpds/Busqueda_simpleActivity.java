package com.example.vale.buscadorpds;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Busqueda_simpleActivity extends AppCompatActivity {
    String ip="192.168.0.3";
    String NAMESPACE="http://serviciosweb";
    String URL="http://"+ip+":8080/TallerJSP/services/WebServiceProveedor?wsdl";
    String SOAP_ACTION="http://"+ip+":8080/TallerJSP/services/WebServiceProveedor";
    String METHOD_NAME="busquedaSimple";

    EditText textoBusqueda;
    TextView textViewResultado;
    Button btn_simple_enviar;
    String criteria;
    String resultado;
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_simple);

        textoBusqueda = (EditText) findViewById(R.id.editTextSimple);
        textViewResultado = (TextView) findViewById(R.id.textViewRaw);
        btn_simple_enviar = (Button) findViewById(R.id.btn_enviarSimpel);

        btn_simple_enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!textoBusqueda.getText().toString().equals("") &&  textoBusqueda.getText().length() != 0){
                    criteria = textoBusqueda.getText().toString();
                    generateAsyncTask task = new generateAsyncTask();
                    task.execute();
                }else{
                    textViewResultado.setText("busqueda");
                }
            }
        });

    }
    public void obtenerResultado(String busqueda){
        SoapObject query = new SoapObject(NAMESPACE, METHOD_NAME);
        PropertyInfo propInf = new PropertyInfo();
        propInf.setName("textoBusqueda");
        propInf.setValue(busqueda);
        propInf.setType(String.class);

        query.addProperty(propInf);

        SoapSerializationEnvelope toSend = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        toSend.dotNet = true;

        toSend.setOutputSoapObject(query);

        HttpTransportSE transportHttp = new HttpTransportSE(URL);

        try{
            transportHttp.call(SOAP_ACTION, toSend);

            SoapPrimitive response = (SoapPrimitive) toSend.getResponse();

            resultado = response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private class generateAsyncTask extends AsyncTask<String, Void, Void>{
        @Override
        protected Void doInBackground(String... params){
            Log.i(TAG, "doInBackground");
            obtenerResultado(criteria);
            return null;
        }

        @Override
        protected void onPostExecute(Void results){
            Log.i(TAG, "onPostExecute");
            textViewResultado.setText(resultado);
        }

        @Override
        protected void onPreExecute(){
            Log.i(TAG, "onPreExecute");
            textViewResultado.setText("Buscando");
        }

        @Override
        protected void  onProgressUpdate(Void... values){
            Log.i(TAG, "onProgressUpdate");
        }
    }

}
