package capanegocio;

import com.google.gson.Gson;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vale on 10-06-16.
 */
public class Contacto {
    private Empresa empresaUid;
    private int uid;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String pais;
    private String region;
    private String ciudad;
    private String NAMESPACE;
    private String URL;
    private String SOAP_ACTION;
    private String METHOD_NAME;

    public Empresa getEmpresaUid() {
        return empresaUid;
    }
    public void setEmpresaUid(Empresa empresaUid) {
        this.empresaUid = empresaUid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }




    public List<Contacto> transformacionGson(String textoBusqueda){
        System.out.println(textoBusqueda);
        List<Contacto> lista= new ArrayList<Contacto>();
        if(!textoBusqueda.equals("error")){

            Gson gson =new Gson();
            Contacto[] mArray=gson.fromJson(textoBusqueda,Contacto[].class);
            System.out.println(mArray.length);
            List<Contacto>mList= Arrays.asList(mArray);
            System.out.println("entra a la lista");
            System.out.println(mList.size());
            lista=mList;

        }
        return lista;
    }

}
