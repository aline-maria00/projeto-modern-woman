import org.junit.Rule;
import org.mockito.Mockito;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import controller.Controller;
import modal.*;
import org.junit.Assert;

public class CadastroTeste {
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Test
    public void testCadastrarFuncionarioComOController(){
        Controller controlador = Mockito.mock(Controller.class);
        Mockito.when(controlador.cadastroFuncionario("nome", "121.111.236-10", "12223-5", "9999-9999", "test@test.com", "Rua", "1", "a", "cidade", "estado)")).thenReturn(Boolean.TRUE);
    }
    
    @Test
    public void testBairro(){
        Bairro bairro = new Bairro("Nome do bairro");
        Assert.assertEquals("Nome do bairro", bairro.getBairro());
    }
    
    @Test
    public void testCidade(){
        Cidade cidade = new Cidade("Nome da cidade");
        Assert.assertEquals("Nome da cidade", cidade.getCidade());
    }
    
    @Test
    public void testEstado(){
        Estado estado = new Estado("Nome do estado");
        Assert.assertEquals("Nome do estado", estado.getEstado());
    }
    
    //String logradouro, String numero, Bairro bairro, Cidade cidade, Estado estado
    @Test
    public void testEndereco(){
        Bairro bairro = new Bairro("Nome do bairro");
        Cidade cidade = new Cidade("Nome da cidade");
        Estado estado = new Estado("Nome do estado");
        Endereco endereco = new Endereco("logradouro", "numero", bairro, cidade, estado);
        
        Assert.assertEquals("logradouro", endereco.getLogradouro());
        Assert.assertEquals("numero", endereco.getNumero());
        Assert.assertEquals(bairro, endereco.getBairro());
        Assert.assertEquals(cidade, endereco.getCidade());
        Assert.assertEquals(estado, endereco.getEstado());
        
    }
    
    @Test
    public void testTelefone(){
        Telefone telefone = new Telefone("111", "9999-9999");
        Assert.assertEquals("9999-9999", telefone.getTelefone());
    }
    
    @Test
    public void testEmail(){
        Email email = new Email("111", "test@test.com");
        Assert.assertEquals("test@test.com", email.getEmail());
    }
    
    @Test
    public void testFuncionario(){
        Telefone telefone = new Telefone();
        Email email = new Email();
        Endereco endereco = new Endereco();
        Funcionario funcionario = new Funcionario("nome", "111.111.111-11", "1111-1", telefone, email, endereco);
        Assert.assertEquals("nome", funcionario.getNome());
        Assert.assertEquals("111.111.111-11", funcionario.getCpf());
        Assert.assertEquals("1111-1", funcionario.getRg());
    }
    
}
