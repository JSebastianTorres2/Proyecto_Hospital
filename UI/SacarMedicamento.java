/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pro
 * 
 *         if (pila.peek()!=null){
            Medicamento.setText(pila.peek().getNombre());
        }else{
            Medicamento.setText("Se acabaron los medicamentos");
        }
 */
package UI;

import Bussiness.Acceso;
import Data.StackMedicamento;

import Bussiness.Acceso;
import Data.StackMedicamento;

/**
 *
 * @author Pro
 */
public class SacarMedicamento extends javax.swing.JFrame {

    /**
     * Creates new form QuitarMedicamento
     */
    StackMedicamento pila;
    public SacarMedicamento() {
        initComponents();
    }
    public SacarMedicamento(StackMedicamento pila) {
        this.pila=pila;
        initComponents();
    }
                        
     private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Sacar = new javax.swing.JButton();
        Siguiente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        agregarMedicamentos = new javax.swing.JButton();
        medicamento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Sacar Medicamentos");

        Sacar.setText("Sacar");
        Sacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SacarActionPerformed(evt);
            }
        });

        Siguiente.setText("Siguiente");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        agregarMedicamentos.setText("Agregar Medicamentos");
        agregarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMedicamentosActionPerformed(evt);
            }
        });

        if (pila.peek()!=null){
            medicamento.setText(pila.peek().getNombre());
        }else{
            medicamento.setText("Se acabaron los medicamentos");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(Sacar)
                .addGap(102, 102, 102)
                .addComponent(Siguiente)
                .addGap(132, 132, 132))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(agregarMedicamentos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(medicamento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(101, 101, 101)
                .addComponent(medicamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sacar)
                    .addComponent(Siguiente))
                .addGap(48, 48, 48)
                .addComponent(agregarMedicamentos)
                .addGap(71, 71, 71)
                .addComponent(jButton3)
                .addGap(31, 31, 31))
        );

        pack();
    }

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {
        if(pila.peek()==null){
            new ErrorSiguienteMedicamento();
           
        }else{
            pila.peek().getNombre();
            pila.pop();
            new SacarMedicamento(pila).setVisible(true);
            this.setVisible(false);  
        }

    }                                         

    private void SacarActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:

        if (pila.peek()==null){
            new ErrorSacarMedicamento();
        }else{
            new Acceso().borrarMedicamento(pila.peek());
            pila.pop();
            new SacarMedicamento(pila).setVisible(true);
        }
    }
    private void agregarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        new AgregarMedicamentos().setVisible(true);
        this.setVisible(false);
    }                                                   

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {                                      
        new  MenuFuncionario().setVisible(true);
        this.setVisible(false);
    } 

    /**
     * @param args the command line arguments
     */

    


    // Variables declaration - do not modify                     
    private javax.swing.JButton Sacar;
    private javax.swing.JButton Siguiente;
    private javax.swing.JButton agregarMedicamentos;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel medicamento;
    // End of variables declaration                   
}
