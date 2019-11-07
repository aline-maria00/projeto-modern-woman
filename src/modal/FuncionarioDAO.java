package modal;

import java.sql.*;

public class FuncionarioDAO {

    ConexaoBD cone = new ConexaoBD();

    public void cadastroDeFuncionario(Funcionario funcionario) {//Método responsável pelo cadastro dos dados da classe 'cadastrarMedico'.
        cone.conectar();
        try {
            String selectEstado = "SELECT * FROM `estados` WHERE  `estado` = ?";
            PreparedStatement prst = cone.conexao.prepareStatement(selectEstado);
            prst.setString(1, funcionario.getEndereco().getEstado().getEstado());
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                funcionario.getEndereco().getEstado().setId(rs.getInt("ID_estado"));
                System.out.println("FindByState01 execultado com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro no findByState01: " + ex);
        }
        if (funcionario.getEndereco().getEstado().getId() != 0) {
            try {
                String insertEstado = "INSERT INTO `estados`(`estado`) VALUES (?);";
                PreparedStatement prstEstado = cone.conexao.prepareStatement(insertEstado);
                prstEstado.setString(1, funcionario.getEndereco().getEstado().getEstado());
                prstEstado.execute();
                System.out.println("SUCESSO: "+funcionario.getEndereco().getEstado().getId() +"; "+ funcionario.getEndereco().getEstado().getEstado());
            } catch (SQLException ex) {
                System.out.println("Erro no insertState: " + ex);
            }

            try {
                String selectEstado = "SELECT * FROM `estados` WHERE  `estado` = ?";
                PreparedStatement prst = cone.conexao.prepareStatement(selectEstado);
                prst.setString(1, funcionario.getEndereco().getEstado().getEstado());
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    funcionario.getEndereco().getEstado().setId(rs.getInt("ID_estado"));
                    funcionario.getEndereco().getEstado().setEstado(rs.getString("estado"));
                    System.out.println("FindByState02 execultado com sucesso!");
                }
            } catch (SQLException ex) {
                System.out.println("Erro no findByState02: " + ex);
            }
        }
        try {
            String selectCidade = "SELECT * FROM `cidades` WHERE  `cidade` = ?";
            PreparedStatement prst = cone.conexao.prepareStatement(selectCidade);
            prst.setString(1, funcionario.getEndereco().getCidade().getCidade());
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                funcionario.getEndereco().getCidade().setId(rs.getInt("ID_cidade"));
                System.out.println("FindByCity01 execultado com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro no findByCity01: " + ex);
        }
        if (funcionario.getEndereco().getEstado().getId() != 0) {
            try {
                String insertCidade = "INSERT INTO `cidades`(`cidade`) VALUES (?);";
                PreparedStatement prstCidade = cone.conexao.prepareStatement(insertCidade);
                prstCidade.setString(1, funcionario.getEndereco().getCidade().getCidade());
                prstCidade.execute();
            } catch (SQLException ex) {
                System.out.println("Erro no insertCity: " + ex);
            }
            try {
                String selectCidade = "SELECT * FROM `cidades` WHERE  `cidade` = ?";
                PreparedStatement prst = cone.conexao.prepareStatement(selectCidade);
                prst.setString(1, funcionario.getEndereco().getCidade().getCidade());
                ResultSet rs = prst.executeQuery();
                if(rs.next()){
                    funcionario.getEndereco().getCidade().setId(rs.getInt("ID_cidade"));
                }
            } catch (SQLException ex) {
                System.out.println("Erro no findByCity02: " + ex);
            }
        }
        try {
            String selectBairro = "SELECT * FROM `bairros` WHERE  `bairro` = ?";
            PreparedStatement prst = cone.conexao.prepareStatement(selectBairro);
            prst.setString(1, funcionario.getEndereco().getBairro().getBairro());
            ResultSet rs = prst.executeQuery();
            if(rs.next()){
                funcionario.getEndereco().getBairro().setId(rs.getInt("ID_bairro"));
                System.out.println("FindByNeighborhood01 execultado com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro no findByNeighborhood01: " + ex);
        }
        if (funcionario.getEndereco().getEstado().getId() != 0) {
            try {
                String insertBairro = "INSERT INTO `bairros`(`bairro`) VALUES (?);";
                PreparedStatement prstBairro = cone.conexao.prepareStatement(insertBairro);
                prstBairro.setString(1, funcionario.getEndereco().getBairro().getBairro());
                prstBairro.execute();
            } catch (SQLException ex) {
                System.out.println("Erro no insertNeighborhood: " + ex);
            }
            try {
                String selectBairro = "SELECT * FROM `bairros` WHERE  `bairro` = ?";
                PreparedStatement prst = cone.conexao.prepareStatement(selectBairro);
                prst.setString(1, funcionario.getEndereco().getBairro().getBairro());
                ResultSet rs = prst.executeQuery();
                if(rs.next()){
                    funcionario.getEndereco().getBairro().setId(rs.getInt("ID_bairro"));
                    System.out.println("FindByNeighborhood02 execultado com sucesso!");
                }
            } catch (SQLException ex) {
                System.out.println("Erro no findByNeighborhood02: " + ex);
            }
        }
        try {
            String insertEndereco = "INSERT INTO `enderecos`(`logradouro`, `numero`, `END_ID_bairro`, `END_ID_cidade`, `END_ID_estado`) VALUES (?,?,?,?,?);";
            PreparedStatement prstEndereco = cone.conexao.prepareStatement(insertEndereco);
            prstEndereco.setString(1, funcionario.getEndereco().getLogradouro());
            prstEndereco.setString(2, funcionario.getEndereco().getNumero());
            prstEndereco.setInt(3, funcionario.getEndereco().getBairro().getId());
            prstEndereco.setInt(4, funcionario.getEndereco().getCidade().getId());
            prstEndereco.setInt(5, funcionario.getEndereco().getEstado().getId());
            prstEndereco.execute();
            System.out.println("InsertAddress executado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro no InsertAddress: " + ex);
        }
        
        try {
            String selectEndereco = "SELECT * FROM enderecos WHERE logradouro = ? AND numero = ? AND END_ID_bairro = ? AND END_ID_cidade = ? AND END_ID_estado = ?;";
            PreparedStatement prst = cone.conexao.prepareStatement(selectEndereco);
            prst.setString(1, funcionario.getEndereco().getLogradouro());
            prst.setString(2, funcionario.getEndereco().getNumero());
            prst.setInt(3, funcionario.getEndereco().getBairro().getId());
            prst.setInt(4, funcionario.getEndereco().getCidade().getId());
            prst.setInt(5, funcionario.getEndereco().getEstado().getId());
            ResultSet rs = prst.executeQuery();
            if(rs.next()){
                funcionario.getEndereco().setId(rs.getInt("ID_endereco"));
            }
            System.out.println("FindByAdress execultado com sucesso!");
        } catch(SQLException ex){
            System.out.println("Erro no FindByAdress: " + ex);
        }
        
        try {
            String insertFuncionario = "INSERT INTO `funcionarios` (`nome`, `cpf`, `rg`,`FUN_ID_endereco`) VALUES (?, ?, ?, ?);";
            PreparedStatement prstFuncionario = cone.conexao.prepareStatement(insertFuncionario);
            prstFuncionario.setString(1, funcionario.getNome());
            prstFuncionario.setString(2, funcionario.getCpf());
            prstFuncionario.setString(3, funcionario.getRg());
            prstFuncionario.setInt(4, funcionario.getEndereco().getId());
            prstFuncionario.execute();
            System.out.println("InsertEmployee executado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro no InsertEmployee: " + ex);
        }
        
        try {
            String selectFuncionario = "SELECT * FROM Funcionarios WHERE nome = ? AND CPF = ? AND RG = ? AND FUN_ID_endereco = ?;";
            PreparedStatement prst = cone.conexao.prepareStatement(selectFuncionario);
            prst.setString(1, funcionario.getNome());
            prst.setString(2, funcionario.getCpf());
            prst.setString(3, funcionario.getRg());
            prst.setInt(4, funcionario.getEndereco().getId());
            ResultSet rs = prst.executeQuery();
            if(rs.next()){
                funcionario.setId(rs.getInt("ID_funcionario"));
            }
            System.out.println("FindByAdress execultado com sucesso!");
        } catch(SQLException ex){
            System.out.println("Erro no FindByAdress: " + ex);
        }
        
        try {
            String insertTelefone = "INSERT INTO `telefones_funcionarios` VALUES (?, ?);";
            PreparedStatement prstTelefone = cone.conexao.prepareStatement(insertTelefone);
            prstTelefone.setString(1, funcionario.getTelefone().getTelefone());
            prstTelefone.setInt(2, funcionario.getId());
            prstTelefone.execute();
            System.out.println("InsertPhone executado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro no InsertPhone: " + ex);
        }
        
        try {
            String insertEmail = "INSERT INTO `emails_funcionarios` VALUES (?, ?);";
            PreparedStatement prstEmail = cone.conexao.prepareStatement(insertEmail);
            prstEmail.setString(1, funcionario.getEmail().getEmail());
            prstEmail.setInt(2, funcionario.getId());
            prstEmail.execute();
            System.out.println("InsertEmail executado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro no InsertEmail: " + ex);
        }
        cone.desconectar();
    }
    /*
    public void editarMedico(Medicos cadm){// Método utilizado para editar as informações do médico.
        cone.conectar();
        try {
            String ent = "update Medicos set Nome=?,Sexo=?,Especializacao=?,Telefone=?,Cidade=?,Bairro=?,Logradouro=?,Numero=? where CRM=?";
            PreparedStatement prst = cone.conexao.prepareStatement(ent);
            prst.setString(1, cadm.getNome());
            prst.setString(2, cadm.getSexo());
            prst.setString(3, cadm.getEspecializacao());
            prst.setString(4, cadm.getTelefone());
            prst.setString(5, cadm.getCidade());
            prst.setString(6, cadm.getBairro());
            prst.setString(7, cadm.getLogradouro());
            prst.setString(8, cadm.getNumero());
            prst.setString(9, cadm.getCRM());
            prst.execute();
            System.out.println("Dados modificados com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao modificar dados: " +ex);
        }
        cone.desconectar();;
    }
    
    public void excluirMedico(String crm){//Método utilizado para excluir médicos.
        cone.conectar();
        try {
            String ent = "delete from Medicos where CRM=?";
            PreparedStatement prst = cone.conexao.prepareStatement(ent);
            prst.setString(1, crm);
            prst.execute();
            System.out.println("Dados excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao exclusão dos dados: " +ex);
        }
        cone.desconectar();
    }
    
    public Medicos findById(String crm){//Método responsável por retornar os dados necessários para preencher os campos da tela 'EditarMedicos'.
        Medicos cadMed = null;
        cone.conectar();
        String query = "select * from Medicos where CRM = ?";
        try{
            PreparedStatement ps = cone.conexao.prepareStatement(query);
            ps.setString(1, crm);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cadMed = new Medicos();
                cadMed.setCRM(crm);
                cadMed.setNome(rs.getString("Nome"));
                cadMed.setSexo(rs.getString("Sexo"));
                cadMed.setEspecializacao(rs.getString("Especializacao"));
                cadMed.setTelefone(rs.getString("Telefone"));
                cadMed.setCidade(rs.getString("Cidade"));
                cadMed.setBairro(rs.getString("Bairro"));
                cadMed.setLogradouro(rs.getString("Logradouro"));
                cadMed.setNumero(rs.getString("Numero"));
                System.out.println("FindByld execultado com sucesso!");
            }
        }catch(SQLException ex){
            System.out.println("Erro no findByld: " +ex);
        }
        cone.desconectar();
        return cadMed;
    }*/
}
