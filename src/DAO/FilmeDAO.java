/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Maria Vitória
 */
public class FilmeDAO extends ExecuteSQL {
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a) {
      String sql = "insert into filme values(0,?,?,?,?,?,?)";
      try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          
          ps.setString(1, a.getTitulo());
          ps.setInt(2, a.getAno());
          ps.setString(3, a.getDuracao());
          ps.setInt(4, a.getCod_categoria());
          ps.setInt(5,a.getCod_classificacao());
          ps.setString(6, a.getCapa());
          
          
          
          if (ps.executeUpdate() > 0) {
              return "Inserido com sucesso.";
         }else{
              return "Erro ao inserir";
          }  
          } catch (SQLException e) {
                  return e.getMessage();
                  }
          
  }  
  
    public List<Filme> ListarFilme() {
         String sql = "Select idfilme,titulo,ano, duracao,idcategoria,idclassificação,capa";
         List<Filme> lista = new ArrayList<>();
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     Filme a = new Filme();
                     a.setCodigo(rs.getInt(1));
                     a.setTitulo(rs.getString(2));
                     a.setAno(rs.getInt(3));
                     a.setDuracao(rs.getString(4));
                     a.setCod_categoria(rs.getInt(5));
                     a.setCod_classificacao(rs.getInt(6));
                     a.setCapa(rs.getString(6));
                     
                     
                     
                   
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
    
    
    
     public List<Filme> Pesquisar_Nome_Filme(String nome) {
         String sql = "select idfilme, titulo, ano,duracao, idcategoria, idclassificacao, capa"
                 +"from filme where nome Like '" + nome + "'";
        return null;
         
     }
     
     
      public List<Filme> Pesquisar_Cod_Filme(int cod) {
         String sql = "select idfilme,titulo,ano, duracao,idcategoria,idclassificacao,capa "
                 + "from filme where idfilme = '" + cod + "'";
        return null;
                 
     }
      
      
      
       public boolean Testar_Filme(int cod){
              boolean Resultado = false;
              try {
                  
                  String sql = "select * from filme where idfilme = " + cod + "";
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
      

    
         public List<Filme> CapturarFilme(int cod) {
          String sql = "select * from filme where idfilme =" + cod + "";
          List<Filme> lista = new ArrayList<>();
          try { 
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null) {
                 while (rs.next()) {
                     Filme a = new Filme();
                     a.setCodigo(rs.getInt(1));
                     a.setTitulo(rs.getString(2));
                     a.setAno(rs.getInt(3));
                     a.setDuracao(rs.getString(4));
                     a.setCod_categoria(rs.getInt(5));
                     a.setCod_classificacao(rs.getInt(6));
                     a.setCapa(rs.getString(6));
                     
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
      
       
       
         
           public String Alterar_Filme(Cliente a) {
        String sql = "update idfilme set titulo = ?, ano = ? ,duracao = ?"
                + ", idcategoria = ? ,idclassificacao = ? ,capa = ?  where idfilme = ? ";
      try { 
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getTitulo());
          ps.setInt(2, a.getAno());
          ps.setString(3, a.getDuracao());
          ps.setInt(4, a.getCod_categoria());
          ps.setInt(5,a.getCod_classificacao());
          ps.setString(6, a.getCapa());
          
        
          if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
          }else{
             return "Erro ao atualizar";  
          }
          } catch (SQLException e) {
        return e.getMessage();
              
          }
      }
      
           
              public List<Filme> ListarComboFilme() {
           String sql = "select nome from Filme order by titulo";
           List<Filme> lista = new ArrayList<>();
           try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
                if (rs != null) {
                    while (rs.next()) {

                        Filme a = new Filme();
                        a.setTitulo(rs.getNString(1));
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
      
              
           public List<Filme> ConsultaCodigoFilme(String nome) {
              
              String sql = "select idfilme from filme where nome = '" + nome + "'";
              List<Filme> = new ArrayList<>();
              try {
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  
                  if (rs != null){
                      List<Filme> lista = null;
                      while (rs.next()) {
                          
                          Filme a = new Filme();
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
      
           
           
         
                 public String Excluir_Filme (Filme a) {
        String sql = "delete from filme where idfilme = ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo ());
            ps.setString(2, a.getTitulo ());
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
