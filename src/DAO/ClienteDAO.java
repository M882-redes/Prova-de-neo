/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Maria Vitória
 */
public class ClienteDAO {
  public String Inserir_Cliente(Cliente a) {
      String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
      try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          
          ps.setString(1, a.getNome());
          ps.setString(2, a.getNascimeto());
          ps.setString(3, a.getRG());
          ps.setString(4, a.getCPF());
          ps.setString(5, a.getEmail());
          ps.setString(6, a.getTelefone());
          ps.setString(7, a.getBairro());
          ps.setString(8, a.getRua());
          ps.setString(9, a.getaNumero());
          ps.setString(10, a.getCEP());
          
          if (ps.executeUpdate() > 0) {
              return "Inserido com sucesso.";
          }else{
              return "Erro ao inserir";
              
          }catch(SQLexception e) {
                  return e.getMessage();
                  }
          
      


     public List<Cliente> ListarCliente() {
         String sql = "Select idcliente,nome,rg,cpf,telefone,email from cliente";
         List<Cliente> lista = new ArrayList<>();
         try {
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     Cliente a = new Cliente();
                     
                 }
             }
         }


          
          
      }
  } 
}

 




  





}