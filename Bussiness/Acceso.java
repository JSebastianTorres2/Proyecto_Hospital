/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness;

/**
 *
 * @author Pro
 */
import Data.StackMedicamento;
import Data.DatabaseManager;
import Data.Medicamento;
public class Acceso {
    static DatabaseManager db = new DatabaseManager("medicamentos");
    public StackMedicamento medicamentos(){
            return db.obtenerMedicamentosComoPila(); 
    }
    public void borrarMedicamento(Medicamento m){
            db.eliminarMedicamento(m);
    }
    public void agregarMedicamento(Medicamento m){
            db.insertarMedicamento(m);
    }
    
    
    
}
