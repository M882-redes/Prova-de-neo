/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Cliente;
import Modelo.Filme;
import java.sql.*;
import Modelo.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO  extends ExecuteSQL{
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    public boolean Logar(String login, String senha) {
        boolean finalResult = false;
        try{ 
            String consulta = "select login, senha from funcionario "
                    + "where login = '"+ login +"admin' and senha = '"+ senha+"admin' ";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs  = ps.executeQuery();
            
            
           if(rs != null) {
               while (rs.next()) {
                   Funcionario a = new Funcionario();
                   a.setNome(rs.getString(1));
                   a.setLogin(rs.getString(2));
                   a.setSenha(rs.getString(3));
                   finalResult = true;
                  
               }
           }
                   
        } catch (SQLException ex) {
            ex.getMessage();
            
        }
         return finalResult;
                }
    
     public String Inserir_Funcionario(Funcionario a) {
      String sql = "insert into funcionario values(0,?,?,?)";
      try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          
          ps.setString(1, a.getNome());
          ps.setString(2, a.getLogin());
          ps.setString(3, a.getSenha());
        
          
          
          if (ps.executeUpdate() > 0) {
              return "Inserido com sucesso.";
         }else{
              return "Erro ao inserir";
          }  
          } catch (SQLException e) {
                  return e.getMessage();
                  }
          
  }  
   
      public List<Funcionario> ListarFuncionario() {
         String sql = "Select idfuncionario,nome,login, senha";
         List<Funcionario> lista = new ArrayList<>();
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     Funcionario a = new Funcionario();
                     a.setNome(rs.getString(1));
                     a.setLogin(rs.getString(2));
                     a.setSenha(rs.getString(3));
                   
                  }
                 return lista;
             }else{
                 return null;
                 
             }
         } catch (SQLException e) {
                     return null;
         }
    }
      
       
     public List<Funcionario> Pesquisar_Nome_Funcionario(String nome) {
         String sql = "select idfuncionario, login, senha"
                 +"from filme where nome Like '" + nome + "'";
        return null;
         
     }
    
       public List<Funcionario> Pesquisar_Cod_Funcionario(int cod) {
         String sql = "select idfuncionario, login, senha "
                 + "from filme where idfuncionario = '" + cod + "'";
        return null;
                 
     }
 
        public boolean Testar_Funcionario(int cod){
              boolean Resultado = false;
              try {
                  
                  String sql = "select * from funcionario where idfuncionario = " + cod + "";
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
        
        public List<Funcionario> CapturarFuncionario(int cod) {
          String sql = "select * from funcionario where idfuncionrio =" + cod + "";
          List<Funcionario> lista = new ArrayList<>();
          try { 
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null) {
                 while (rs.next()) {
                     Funcionario a = new Funcionario();
                     a.setNome(rs.getString(1));
                     a.setLogin(rs.getString(2));
                     a.setSenha(rs.getString(3));
                   ;
                     
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
        
            public String Alterar_Funcionario(Funcionario a) {
        String sql = "update idfuncionario set nome = ?, login = ? ,senha = ?"
                  + " where idfuncionario = ? ";
      try { 
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setString(1, a.getNome());
          ps.setString(2, a.getLogin());
          ps.setString(3, a.getSenha());
        
          
        
          if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
          }else{
             return "Erro ao atualizar";  
          }
          } catch (SQLException e) {
        return e.getMessage();
              
          }
      }
      
               public List<Funcionario> ListarComboFuncionario() {
           String sql = "select nome from Funcionario order by nome";
           List<Funcionario> lista = new ArrayList<>();
           try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
                if (rs != null) {
                    while (rs.next()) {

                        Funcionario a = new Funcionario();
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
               
                public List<Funcionario> ConsultaCodigoFuncionario(String nome) {
              
              String sql = "select idfuncionario from funcionario where nome = '" + nome + "'";
              List<Funcionario> = new ArrayList<>();
              try {
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  
                  if (rs != null){
                      List<Funcionario> lista = null;
                      while (rs.next()) {
                          
                          Funcionario a = new Funcionario();
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
      
        public String Excluir_Funcionario (Funcionario a) {
        String sql = "delete from funcionario where idfuncionario= ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome ());
            ps.setString(2, a.getLogin ());
            ps.setString(3, a.getSenha ());
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
