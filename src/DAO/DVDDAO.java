/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Maria Vitória
 */
public class DVDDAO extends ExecuteSQL{
    
    public DVDDAO(Connection con) {
        super(con);
    }
    
     public String Inserir_DVD(DVD a){
      String sql = "insert into DVD values(0,?,?,?,?)";
      try {
          PreparedStatement ps = getCon().prepareStatement(sql);

          ps.setString(1, a.getdvd());
          ps.setString(2, a.getPreco_compra());
          ps.setString(3, a.getData_compra());
          ps.setString(4, a.getSituacao());
       
          if (ps.executeUpdate() > 0) {
              return "Inserido com sucesso.";
         } else {
              return "Erro ao inserir";
          }  
          } catch (SQLException e) {
                  return e.getMessage();
                  }
       
          }
     
      public List<DVD> ListarDVD() {
         String sql = "Select iddvd,idfilme,preco_compra,data_compra,situacao from dvd";
         List<DVD> lista = new ArrayList<>();
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     DVD a = new DVD();
                     a.setCodigo(rs.getInt(1));
                     a.setPreco(2);
                     a.setData_compra(rs.getString(3));
                     a.setSituacao(rs.getString(4));
                    
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

        
     public List<DVD> Pesquisar_Nome_DVD(String nome) {
         String sql = "select idfilme, titulo, ano,duracao, idcategoria, idclassificacao, capa"
                 +"from filme where nome Like '" + nome + "'";
        return null;
         
     }
     
     public List<DVD> Pesquisar_Cod_DVD(int cod) {
         String sql = "select iddvd,idfilme ,preco_compra, data_compra, situcao "
                 + "from DVD where iddvd = '" + cod + "'";
        return null;
                 
     }
     
     public boolean Testar_DVD(int cod){
              boolean Resultado = false;
              try {
                  
                  String sql = "select * from dvd where iddvd = " + cod + "";
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
     
     
     public List<DVD> CapturarDVD(int cod) {
          String sql = "select * from dvd where iddvd =" + cod + "";
          List<DVD> lista = new ArrayList<>();
          try { 
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null) {
                 while (rs.next()) {
                     DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                     a.setPreco(2);
                     a.setData_compra(rs.getString(3));
                     a.setSituacao(rs.getString(4));
                     
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
     
     
       public String Alterar_DVD(DVD a) {
        String sql = "update iddvd set idfilme = ?, preco_compra = ? ,data_compra = ?"
                + ", situacao = ? where idfilme = ? ";
      try { 
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getdvd());
          ps.setString(2, a.getPreco_compra());
          ps.setString(3, a.getData_compra());
          ps.setString(4, a.getSituacao());
        
          if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
          }else{
             return "Erro ao atualizar";  
          }
          } catch (SQLException e) {
        return e.getMessage();
              
          }
      }
       
       
         public List<DVD> ListarComboDVD() {
           String sql = "select nome from dvd order by nome";
           List<DVD> lista = new ArrayList<>();
           try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
                if (rs != null) {
                    while (rs.next()) {

                        DVD a = new DVD();
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
      
         
            public List<DVD> ConsultaCodigoDVD(String nome) {
              
              String sql = "select iddvd from dvd where nome = '" + nome + "'";
              List<DVD> lista = new ArrayList<>();
              try {
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  
                  if (rs != null){
                      while (rs.next()) {
                          
                          DVD a = new DVD();
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
            
        public String Excluir_DVD (DVD a) {
        String sql = "delete from dvd where iddvd = ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getdvd());
          ps.setString(2, a.getPreco_compra());
          ps.setString(3, a.getData_compra());
          ps.setString(4, a.getSituacao());
        
            
            if (ps.executeUpdate() > 0) {
            return "Excluido com Sucesso";
            }else{              
                return "Erro ao excluir";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
           }
        }     
      
         
      
       
     
     
}


