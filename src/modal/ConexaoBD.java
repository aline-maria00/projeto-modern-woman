package modal;

import java.sql.*;

public class ConexaoBD {
        public Connection conexao = null;
        public Statement stmt = null;
        public ResultSet rs = null;
        private String url = "jdbc:mysql://localhost/ModernWoman";
        private String usuario = "root";
        private String senha = "";
        
        public void conectar(){//Método responsável pela conexão com o banco.
            try {
                conexao = DriverManager.getConnection(url, usuario, senha);
                System.out.println("Conectado com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Erro na conexão: " + ex);
            }
        }
        
        public void executarSQL(String sql){//Método responsável por executar o SQL.
            try {
                stmt = conexao.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                System.out.println("Erro ao execultar SQL: " + ex);
            }
            
        }
        
        public void desconectar(){//Método responsável por desconectar o banco de dados.
            try {
                conexao.close();
                System.out.println("Desconectado com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Erro na desconexão: " + ex);
            }  
        }
}
