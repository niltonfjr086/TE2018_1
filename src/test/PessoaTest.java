package test;

import java.util.List;

import org.junit.Test;

import model.dao.PessoaDAO;
import model.entity.Pessoa;

public class PessoaTest {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private Pessoa pessoa = new Pessoa();
	
	@Test
	public void testFindAll() {
		
		if (pessoaDAO.findAll().size() <= 0) {
			adicionarPessoas();
		}
		
		List<Pessoa> pessoas = pessoaDAO.findAll();		
		System.out.println("Todas as pessoas cadastradas: \n" + pessoas);
		
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		
		List<Pessoa> funcionarios = pessoaDAO.findAllFuncionarios();
		System.out.println("Todos os funcionários cadastrados: \n" + funcionarios);
		
	}
	
	private void adicionarPessoas() {

		pessoa = new Pessoa();
		pessoa.setNome("Pedro Silva");
		pessoa.setCpf("345.345.345-32");
		pessoa.setFuncionario(true);
		pessoa.setDatanascimento(ConsoleTest.defineData("01/10/1990"));
		pessoaDAO.save(pessoa);

		pessoa = new Pessoa();
		pessoa.setNome("João Matos");
		pessoa.setCpf("435.215.585-90");
		pessoa.setFuncionario(false);
		pessoa.setDatanascimento(ConsoleTest.defineData("10/12/1985"));
		pessoaDAO.save(pessoa);

		pessoa = new Pessoa();
		pessoa.setNome("Maria Oliveira");
		pessoa.setCpf("211.432.954-21");
		pessoa.setFuncionario(false);
		pessoa.setDatanascimento(ConsoleTest.defineData("15/02/1982"));
		pessoaDAO.save(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setNome("Marcos Gonçalves");
		pessoa.setCpf("213.444.954-48");
		pessoa.setFuncionario(true);
		pessoa.setDatanascimento(ConsoleTest.defineData("12/02/2005"));
		pessoaDAO.save(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setNome("Adriana Pedrozo");
		pessoa.setCpf("303.201.673-33");
		pessoa.setFuncionario(true);
		pessoa.setDatanascimento(ConsoleTest.defineData("12/02/2005"));
		pessoaDAO.save(pessoa);
		
		pessoa = new Pessoa();
	}

}