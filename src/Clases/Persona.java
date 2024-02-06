/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import ConexionDataBase.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persona {
    String ID_people;
    String Nombres;
    String Apellidos;
    String Direccion;
    String Telefonos;
    String Correos;
    String Password;
    String sentencias;
 Conexion conex = new Conexion();
 public Persona(){
     this.ID_people ="";
     this.Nombres ="";
     this.Apellidos = "";
     this.Direccion= "";
     this.Telefonos="";
     this.Correos="";
     this.Password="";
     this.sentencias="";
     
     
 }

    public String getID_people() {
        return ID_people;
    }

    public void setID_people(String ID_people) {
        this.ID_people = ID_people;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(String Telefonos) {
        this.Telefonos = Telefonos;
    }

    public String getCorreos() {
        return Correos;
    }

    public void setCorreos(String Correos) {
        this.Correos = Correos;
    }
    

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    

    public String getSentencias() {
        return sentencias;
    }

    public void setSentencias(String sentencias) {
        this.sentencias = sentencias;
    }

    public Conexion getConex() {
        return conex;
    }

    public void setConex(Conexion conex) {
        this.conex = conex;
    }
    @SuppressWarnings("empty-statement")
 public boolean insertar(){
     int answer=0;
        try{
           String sentencias = "INSERT INTO registros(ID,Nombre,Apellido,Direccion,Telefono,Correo,Contraseña)values(?,?,?,?,?,?,?)";
           PreparedStatement set = conex.conectar().prepareStatement(sentencias);
           set.setString(1, this.getID_people());
           set.setString(2, this.getNombres());
           set.setString(3, this.getApellidos());
           set.setString(4, this.getDireccion());
           set.setString(5, this.getTelefonos());
           set.setString(6, this.getCorreos());
           set.setString(7, this.getPassword());
                
                answer= set.executeUpdate();
       } catch(SQLException e){
           
       }if(answer>0){
           return true;
       }else{
           return false;
       }
       
 }
 public String[][] consultar(String usuario, String clave){
     String[][] object = null;
     try{
         this.sentencias ="SELECT * FROM registros WHERE Correo=? AND Contraseña=?";
         PreparedStatement statement = conex.conectar().prepareStatement(this.sentencias, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
         statement.setString(1, usuario);
         statement.setString(2, clave);
      ResultSet datos = statement.executeQuery();
      if(datos.last()){
          int numRows = datos.getRow();
          object = new String [numRows][2];
           datos.beforeFirst(); int row=0;
           while(datos.next()){
               object[row][0]=datos.getObject(1).toString();
               object[row][1]=datos.getObject(2).toString();
               row++;
           }
           
      }
     } catch(Exception e){
         
     }
     return object;
 } 
}
