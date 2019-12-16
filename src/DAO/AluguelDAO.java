/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluguel;
import Modelo.Categoria;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Maria Vitória
 */
public class AluguelDAO extends ExecuteSQL {
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a) {
      String sql = "insert into Aluguel values(0,?,?,?,?,?)";
      try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          
          ps.setString(1, a.getiddvd());
          ps.setString(2, a.getidcliente());
          ps.setString(3, a.gethora_aluguel());
          ps.setString(4, a.getData_aluguel());
          ps.setString(5, a.getData_devolucao());
          
          
       
          
          if (ps.executeUpdate() > 0) {
              return "Inserido com sucesso.";
         }else{
              return "Erro ao inserir";
          }  
          } catch (SQLException e) {
                  return e.getMessage();
                  }
          
  }  
    
      public List<Aluguel> ListarAluguel() {
         String sql = "Select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel"
                 + "data_devolucao";
         List<Aluguel> lista = new ArrayList<>();
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     Aluguel a = new Aluguel();
                     a.setiddvd(rs.getString(1));
                     a.setidcliente(rs.getString(2));
                     a.sethora_aluguel(rs.getString(3));
                     a.setData_aluguel(rs.getString(4));
                     a.getData_devolucao(rs.getString(5));
                     
                   
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
      
      
         public List<Aluguel> Pesquisar_Nome_Aluguel(String nome) {
         String sql = "select idaluguel, iddvd, idcliente, hora_aluguel, data_aluguel"
                 + "data_devolucao"
                 +"from aluguel where nome Like '" + nome + "'";
        return null;
         
     }
     
      public List<Aluguel> Pesquisar_Cod_Aluguel(int cod) {
         String sql = "select idaluguel, idcliente, hora_aluguel, data_aluguel"
                 + "data_devolucao "
                 + "from Aluguel where idaluguel = '" + cod + "'";
        return null;
                 
     }
      
      
           public boolean Testar_Aluguel(int cod){
              boolean Resultado = false;
              try {
                  
                  String sql = "select * from aluguel where idaluguel = " + cod + "";
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
           
           
          public List<Aluguel> CapturarAluguel(int cod) {
          String sql = "select * from aluguel where idaluguel =" + cod + "";
          List<Aluguel> lista = new ArrayList<>();
          try { 
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null) {
                 while (rs.next()) {
                     Aluguel a = new Aluguel();
                     a.setiddvd(rs.getString(1));
                     a.setidcliente(rs.getString(2));
                     a.sethora_aluguel(rs.getString(3));
                     a.setData_aluguel(rs.getString(4));
                     a.getData_devolucao(rs.getString(5));
                     
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
          
           public String Alterar_Aluguel(Aluguel a) {
        String sql = "update aluguel set nome = ?  where idaluguel = ? ";
      try { 
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getiddvd());
          ps.setString(2, a.getidcliente());
          ps.setString(3, a.gethora_aluguel());
          ps.setString(4, a.getData_aluguel());
          ps.setString(5, a.getData_devolucao());
          
          if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
          }else{
             return "Erro ao atualizar";  
          }
          } catch (SQLException e) {
        return e.getMessage();
              
          }
      }
       
       
          public List<Aluguel> ListarComboAluguel() {
           String sql = "select nome from aluguel order by nome";
           List<Aluguel> lista = new ArrayList<>();
           try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
                if (rs != null) {
                    while (rs.next()) {

                        Aluguel a = new Aluguel();
                     a.setiddvd(rs.getString(1));
                     a.setidcliente(rs.getString(2));
                     a.sethora_aluguel(rs.getString(3));
                     a.setData_aluguel(rs.getString(4));
                     a.getData_devolucao(rs.getString(5));
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
            public List<Aluguel> ConsultaCodigoAluguel(String nome) {
              
              String sql = "select idaluguel from aluguel where nome = '" + nome + "'";
              List<Aluguel> lista = new ArrayList<>();
              try {
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  
                  if (rs != null){
                      while (rs.next()) {
                          
                          Aluguel a = new Aluguel();
                     a.setiddvd(rs.getString(1));
                     a.setidcliente(rs.getString(2));
                     a.sethora_aluguel(rs.getString(3));
                     a.setData_aluguel(rs.getString(4));
                     a.getData_devolucao(rs.getString(5));
                     
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
        
       public String Excluir_Aluguel(Aluguel a) {
        String sql = "delete from cliente where idaluguel = ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getiddvd());
          ps.setString(2, a.getidcliente());
          ps.setString(3, a.gethora_aluguel());
          ps.setString(4, a.getData_aluguel());
          ps.setString(5, a.getData_devolucao());
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
          
      
       
      
 
 
 
    
    
    
    

