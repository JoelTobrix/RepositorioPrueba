/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import ConexionDataBase.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Inventarios {
    String ID_valor; String productos; String precio_publico; String precio_mayorista; String cantidad; String sentencia; 
    Conexion conex3 = new Conexion();
public Inventarios(){
    this.ID_valor=""; this.productos=""; this.precio_publico=""; this.precio_mayorista=""; this.cantidad=""; this.sentencia="";
}    

    public String getID_valor() {
        return ID_valor;
    }

    public void setID_valor(String ID_valor) {
        this.ID_valor = ID_valor;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getPrecio_publico() {
        return precio_publico;
    }

    public void setPrecio_publico(String precio_publico) {
        this.precio_publico = precio_publico;
    }

    public String getPrecio_mayorista() {
        return precio_mayorista;
    }

    public void setPrecio_mayorista(String precio_mayorista) {
        this.precio_mayorista = precio_mayorista;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public Conexion getConex3() {
        return conex3;
    }

    public void setConex3(Conexion conex3) {
        this.conex3 = conex3;
    }
public boolean insertar(){
    int respuestas = 0;
     try{
           String sentencias=  "INSERT INTO inventario(Codigo_barras,Productos,Precio_PVP,Precio_Mayorista,Cantidad)values(?,?,?,?,?)";
           PreparedStatement st= conex3.conectar().prepareStatement(sentencias);
             st.setString(1, this.getID_valor());
             st.setString(2, this.getProductos());
             st.setString(3, this.getPrecio_publico());
             st.setString(4, this.getPrecio_mayorista());
             st.setString(5, this.getCantidad());
          respuestas = st.executeUpdate();   
     }catch(Exception e){
     }if(respuestas>0){
         return true;
     }else{
         return false;
     }
}
public Object[][] consultar(){
    Object objects [][]= null;
          try{
              this.sentencia="SELECT * FROM inventario";
             Statement st = conex3.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet dato = st.executeQuery(this.sentencia);
             dato.last(); int nif= dato.getRow(); objects= new Object[nif][5];
              int f=0;  dato.beforeFirst(); while(dato.next()){
                  objects[f][0]= dato.getObject(1);
                  objects[f][1]= dato.getObject(2);
                  objects[f][2]= dato.getObject(3);
                  objects[f][3]= dato.getObject(4);
                  objects[f][4]= dato.getObject(5);
               f++;   
              }
}catch(Exception e){
    
}  return objects;         
}
public Object[][] consultar2(){
    Object obj[][]=null;
    try{
   this.sentencia = "SELECT Productos,Precio_PVP,Precio_Mayorista,Cantidad FROM inventario";

       Statement st = conex3.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet dato = st.executeQuery(this.sentencia);
             dato.last(); int nif= dato.getRow(); obj= new Object[nif][4];
              int f=0;  dato.beforeFirst(); while(dato.next()){
                  obj[f][0]= dato.getObject(1);
                  obj[f][1]= dato.getObject(2);
                  obj[f][2]= dato.getObject(3);
                  obj[f][3]= dato.getObject(4);
                 
               f++;   
              }
}catch(Exception e){
    
}  return obj;         
} 
public Object [][] investigar(){
    Object obje [][] = null;
    try{
         this.sentencia = "SELECT Productos,Precio_PVP,Precio_Mayorista FROM inventario";
         Statement st = conex3.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet dato = st.executeQuery(this.sentencia);
             dato.last(); int nif= dato.getRow(); obje= new Object[nif][4];
              int f=0;  dato.beforeFirst(); while(dato.next()){
                  obje[f][0]= dato.getObject(1);
                  obje[f][1]= dato.getObject(2);
                  obje[f][2]= dato.getObject(3);
                 
               f++;   
              }
}catch(Exception e){
    
}  return obje;
    }

public boolean eliminarFila(String codigoBarras) {
    int respuesta = 0;
    try {
        if (conex3.conectar() != null) {
            String sentencia = "DELETE FROM inventario WHERE Codigo_barras=?";
            PreparedStatement st = conex3.conectar().prepareStatement(sentencia);
            st.setString(1, codigoBarras);
            respuesta = st.executeUpdate();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return respuesta > 0;
}

    public void setModel(DefaultTableModel modelo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
    
    

