/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Classificacao;
import Modelo.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Maria Vitória
 */
public class ClassificacaoDAO extends ExecuteSQL{
   public ClassificacaoDAO (Connection con) {
       super(con);
   
   }
   
    public String Inserir_Classificaco(Classificacao a) {
      String sql = "insert into classificaco values(0,?,?)";
      try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          
          ps.setString(1, a.getNome());
          ps.setDouble(2, a.getPreco());
       
          
          if (ps.executeUpdate() > 0) {
              return "Inserido com sucesso.";
         }else{
              return "Erro ao inserir";
          }  
          } catch (SQLException e) {
                  return e.getMessage();
                  }
          
  }  
    
     public List<Classificacao> ListarClassificacao() {
         String sql = "select idclassificaco,nome,preco";
         List<Classificacao> lista = new ArrayList<>();
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     Classificacao a = new Classificacao();
                     a.setNome(rs.getString(1));
                     a.setPreco(rs.getDouble(2));
                   
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
    
     public List<Classificacao> Pesquisar_Nome_Classificacao(String nome) {
         String sql = "select idclassificacao, nome, Preco"
                 +"from classificacao where nome Like '" + nome + "'";
        return null;
         
     }
     
      public List<Classificacao> Pesquisar_Cod_Classificacao(int cod) {
         String sql = "select idclassificacao, nome, Preco "
                 + "from Classificacao where idClassificaco = '" + cod + "'";
        return null;
                 
     }
      public boolean Testar_Classificacao(int cod){
              boolean Resultado = false;
              try {
                  
                  String sql = "select * from classificacao where idclassificao = " + cod + "";
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
    
       public List<Classificacao> CapturarClassificacao(int cod) {
          String sql = "select * from classificacao where idclassificacao =" + cod + "";
          List<Classificacao> lista = new ArrayList<>();
          try { 
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null) {
                 while (rs.next()) {
                     Classificacao a = new Classificacao();
                     a.setNome(rs.getString(1));
                     a.setPreco(2);
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
       
       public String Alterar_Classificacao(Classificacao a) {
        String sql = "update classificacao set nome = ? ,preco = ?  where idclassificacao = ? ";
      try { 
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getNome());
          ps.setInt(1, (int) a.getPreco());
          
          if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
          }else{
             return "Erro ao atualizar";  
          }
          } catch (SQLException e) {
        return e.getMessage();
              
          }
      }
       
       public List<Classificacao> ListarComboClassificacao() {
           String sql = "select nome from classificacao order by nome";
           List<Classificacao> lista = new ArrayList<>();
           try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
                if (rs != null) {
                    while (rs.next()) {

                        Classificacao a = new Classificacao();
                        a.setNome(rs.getNString(1));
                        a.setPreco(rs.getInt(2));
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
       
           
        public List<Classificacao> ConsultaCodigoClassificacao(String nome) {
              
              String sql = "select idclassificacao from classificacao where nome = '" + nome + "'";
              List<Classificacao> lista = new ArrayList<>();
              try {
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  
                  if (rs != null){
                      while (rs.next()) {
                          
                          Classificacao a = new Classificacao();
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
        
        public String Excluir_Classificacao (Classificacao a) {
        String sql = "delete from classificacao where idclassificacao = ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo ());
            ps.setString(2, a.getNome ());
            if (ps.executeUpdate() > 0) {
            return "Excluido com Sucesso";
            }else{              
                return "Erro ao excluir";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
           }
        }     

    public void Inserir_Classificacao(Classificacao a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
              
} //NÃO APAGAR  

    

