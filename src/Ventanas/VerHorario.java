/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
  * @author CL
 */
public class VerHorario extends javax.swing.JDialog {

    /**
     * Creates new form VerHorario
     */
    public VerHorario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Horario");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addGap(39, 39, 39)))
        );

        setSize(new java.awt.Dimension(711, 469));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    ResultSet resultado;
    
    public void CargarDatos(int ID_Medico){
      
String [] Header = {"Dia","Desde","Hasta"};    
model.setColumnIdentifiers(Header);  
this.jTable1.setModel(model);
        
String [] Datos = new String[3];

try{
    
    resultado = Conexion.consulta("Select Dia, Hora_Inicial, Hora_Final from Horario "
            + "Where ID_Medico = "+ID_Medico);
    
    while(resultado.next()){
        
       String Dia = resultado.getString(1);
       
       if("L".equals(Dia)){
           Dia = "Lunes";
       }
       if("M".equals(Dia)){
           Dia = "Martes";
       }
       if("X".equals(Dia)){
           Dia = "Miercoles";
       }
       if("J".equals(Dia)){
           Dia = "Jueves";
       }
       if("V".equals(Dia)){
           Dia = "Viernes";
       }
       if("S".equals(Dia)){
           Dia = "Sabado";
       }
       if("D".equals(Dia)){
           Dia = "Domingo";
       }
       Datos [0] = Dia;
       Datos [1] = resultado.getString(2);
       Datos [2] = resultado.getString(3);

       model.addRow(Datos);
    }
    
}catch(SQLException ex){
    
}

jTable1.setModel(model);

    }
    
    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerHorario dialog = new VerHorario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
