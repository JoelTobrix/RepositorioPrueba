/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package traveldelevopersolutions;

import ConexionDataBase.Conexion;
import Interfaces.Login;


public class TravelDelevoperSolutions {

    
    public static void main(String[] args) {
        // Metodo main
        Conexion frmConexion = new Conexion();
        Login frmLogin = new Login();
        frmLogin.setLocationRelativeTo(null);
        frmLogin.setVisible(true);
        
        
    }
    
}
