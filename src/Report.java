
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Report extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
        setResizable(false);
         setSize(1180,630);
         setLocation(100,20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kiran = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("EMPLOYEE REPORT");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("SEARCH");

        kiran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kiranKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kiranKeyTyped(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLOYEE NAME", "GENDER", "SALARY", "BRANCH ID", "BRANCH NAME", "CLIENT ID", "CLIENT NAME", "SUPPLIER NAME", "SUPPLIER TYPE"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("COMPANY REPORT");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 683, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kiran, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(167, 167, 167))
            .addGroup(layout.createSequentialGroup()
                .addGap(471, 471, 471)
                .addComponent(jButton1)
                .addGap(66, 66, 66)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(kiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kiranKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kiranKeyReleased
     DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        try {
            String sql="select e.first_name,e.gender,e.salary,b.branch_id,b.branch_name,c.client_id,c.client_name,s.supplier_name,supply_type from employee e,branch b,client c,branch_supplier s where e.emp_id=? and b.branch_id=c.branch_id and e.branch_id=b.branch_id and c.branch_id=e.branch_id and s.branch_id=c.branch_id and s.branch_id=b.branch_id and s.branch_id=e.branch_id";
            
             Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","kiran@123");
            pst=con.prepareStatement(sql);
            pst.setString(1,kiran.getText());
            rs=pst.executeQuery();
            if(rs.next()) {
                String  add1=rs.getString("first_name");
             
                
                 String  add2=rs.getString("gender");
                
                 String  add3=rs.getString("salary");
                
                
                 String  add4=rs.getString("branch_id");
              
                
                 String  add5=rs.getString("branch_name");
               
                 String  add6=rs.getString("client_id");
                
                
                 String  add7=rs.getString("client_name");
               
                
                 String  add8=rs.getString("supplier_name");
                 
                 String  add9=rs.getString("supply_type");
                model.addRow(new Object[] {add1,add2,add3,add4,add5,add6,add7,add8,add9});
                
                
            }
            
            
        }catch(Exception e ) {
            
        }
        
       
        try {
           
            String sql="select e.first_name,e.gender,e.salary,b.branch_id,b.branch_name,c.client_id,c.client_name,s.supplier_name,supply_type from employee e,branch b,client c,branch_supplier s where e.first_name=? and b.branch_id=c.branch_id and e.branch_id=b.branch_id and c.branch_id=e.branch_id and s.branch_id=c.branch_id and s.branch_id=b.branch_id and s.branch_id=e.branch_id";
            
             Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","kiran@123");
            pst=con.prepareStatement(sql);
            pst.setString(1,kiran.getText());
            rs=pst.executeQuery();
            if(rs.next()) {
                String  add1=rs.getString("first_name");
             
                
                 String  add2=rs.getString("gender");
                
                 String  add3=rs.getString("salary");
                
                
                 String  add4=rs.getString("branch_id");
              
                
                 String  add5=rs.getString("branch_name");
               
                 String  add6=rs.getString("client_id");
                
                
                 String  add7=rs.getString("client_name");
               
                
                 String  add8=rs.getString("supplier_name");
                 
                 String  add9=rs.getString("supply_type");
                model.addRow(new Object[] {add1,add2,add3,add4,add5,add6,add7,add8,add9});
                
                
            }
            
            
        }catch(Exception e ) {
            
        }
           
           
            
                
                
            
                  
                  
              
               
                
        
              
                
                 
               
                
                 
              
                
                
               
                
        
    }//GEN-LAST:event_kiranKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Others s=new Others();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Mainpage m=new Mainpage();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kiranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kiranKeyTyped
         
    }//GEN-LAST:event_kiranKeyTyped

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField kiran;
    // End of variables declaration//GEN-END:variables
}
