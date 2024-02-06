/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import ConexionDataBase.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class administrador {
    String Ide;
   String ejecucion;
    Conexion conex = new Conexion();
public  administrador(){
    this.Ide="";
    this.ejecucion="";
}    

    public String getIde() {
        return Ide;
    }

    public void setIde(String Ide) {
        this.Ide = Ide;
    }

    public String getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(String ejecucion) {
        this.ejecucion = ejecucion;
    }

    public Conexion getConex2() {
        return conex;
    }

    public void setConex2(Conexion conex2) {
        this.conex = conex2;
    }
    public String[][] consultar2(String Ide){
        String [][] obj = null;
        try{
            this.ejecucion= "SELECT * FROM admin WHERE ID=?";
           PreparedStatement statement= conex.conectar().prepareStatement(this.ejecucion, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
           statement.setString(1, Ide);
            ResultSet datos = statement .executeQuery();
            if(datos.last()){
                int numRows = datos.getRow(); obj= new String[numRows][1]; datos.beforeFirst(); int row=0;
                while(datos.next()){
                    obj[row][0]= datos.getObject(1).toString();
                     row++;
                }
            }
            
        } catch(Exception e){
            
        }
        return obj;
    }
}
