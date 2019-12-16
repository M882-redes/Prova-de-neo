/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Cadastrado;

import DAO.*;
import Modelo.Categoria;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Maria Vitória
 */
public class CadastrarCategoria extends javax.swing.JFrame {
    
   public String Inserir_Categoria(Categoria a) {
      String sql = "insert into categoria values(0,?)";
      try {
          PreparedStatement ps = null;
          ps = ps.setString(1, a.getNome());
       
          
          if (ps.executeUpdate() > 0) {
              return "Inserido com sucesso.";
          }else{
              return "Erro ao inserir";
          }  
          } catch (SQLException e) {
                  return e.getMessage();
                  }
          
  }  
   
   public List<Categoria> ListarCategoria() {
         String sql = "Select idcategoria,nome";
         List<Categoria> lista = new ArrayList<>();
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     Categoria a = new Categoria();
                     a.setNome(rs.getString(1));
                   
                     lista.add(a);
                  }
                 return lista;
             }else{
                 return null;
                 
             }
         } catch (SQLException e) {
                     return null;
         }
    }
    public List<Categoria> Pesquisar_Nome_Categoria(String nome) {
         String sql = "select idcategoria, nome"
                 +"from categoria where nome Like '" + nome + "'";
        return null;
         
     }
     
      public List<Categoria> Pesquisar_Cod_Categoria(int cod) {
         String sql = "select idcliente, Nome "
                 + "from Categoria where idCategoria = '" + cod + "'";
        return null;
                 
     }
      public boolean Testar_Categoria(int cod){
              boolean Resultado = false;
              try {
                  
                  String sql = "select * from categoria where idcategoria = " + cod + "";
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  
                  if (rs != null) {
                      while (rs.next()) {
                          Resultado = true;
                          
                      }
                  }
              } catch (SQLException ex) {
                  ex.getMessage();
                  
              }
              return Resultado;
              
              }
        public List<Categoria> CapturarCategoria(int cod) {
          String sql = "select * from categoria where idcategoria =" + cod + "";
          List<Categoria> lista = new ArrayList<>();
          try { 
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null) {
                 while (rs.next()) {
                     Categoria a = new Categoria();
                     a.setNome(rs.getString(2));
                   
                     lista.add (a);
                     
                     
                     
             
                 }
                 return lista; 
             } else {
             return null;
              
          
          }
          } catch (SQLException e) {
        return null;
              
          }
      }
       public String Alterar_Categoria(Categoria a) {
        String sql = "update categoria set nome = ?  where idcategoria = ? ";
      try { 
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getNome());
          
          if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
          }else{
             return "Erro ao atualizar";  
          }
          } catch (SQLException e) {
        return e.getMessage();
              
          }
      }
       
          public List<Categoria> ListarComboCategoria() {
           String sql = "select nome from categoria order by nome";
           List<Categoria> lista = new ArrayList<>();
           try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Categoria a = new Categoria();
                    a.setNome(rs.getNString(1));
                    lista.add(a);
                    
                }
                return lista;
            } else {
               return null; 
            }
            
           }catch (Exception e) {
                return null;
           }
           
          }
           
            public List<Categoria> ConsultaCodigoCategoria(String nome) {
              
              String sql = "select idcategoria from categoria where nome = '" + nome + "'";
              List<Categoria> lista = new ArrayList<>();
              try {
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  
                if (rs != null){
                      while (rs.next()) {
                          
                          Categoria a = new Categoria();
                          a.setCodigo(rs.getInt(1));
                          lista.add(a);
                      }
                  return lista;
                }else{
                      return null;
                }      
                      
          } catch (Exception e) {
                return null;
               }
              
          }
               
    public CadastrarCategoria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("          Cadastro de Categoria");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome:");

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(47, 47, 47)
                .addComponent(jButton3)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private Object getCon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
