package test;

import java.util.List;

import org.junit.Test;

import model.FactoryDAO;
import model.dao.PessoaDAO;
import model.entity.Pessoa;
import model.entity.PessoaFisica;
import model.entity.PessoaJuridica;

public class PessoaTest {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private Pessoa pessoa;
		
	private PessoaFisica pf = new PessoaFisica();
	private PessoaJuridica pj = new PessoaJuridica();
	
	@Test
	public void testFindAll() {
		
		if (pessoaDAO.findAll().size() <= 0) {
			adicionarPessoas();
			System.out.println("Adicionou Pessoas");
		}
		
//		List<PessoaFisica> pessoas = pessoaDAO.findAll();	
		List<Pessoa> pessoas = FactoryDAO.sessionInstance().createQuery(("FROM " + pj.getClass().getSimpleName())).getResultList();
		
		System.out.println("Todas as pessoas cadastradas: \n" + pessoas);
		
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		
//		List<PessoaFisica> funcionarios = pessoaDAO.findAllFuncionarios();
//		System.out.println("Todos os funcionários cadastrados: \n" + funcionarios);
		
		FactoryDAO.closeInstance();
		
	}
	
	private void adicionarPessoas() {

		pf = new PessoaFisica();
		pf.setNome("Pedro Silva");
		pf.setCpf("345.345.345-32");
		pf.setBairro("São Pedro");
		pf.setCidade("Florianópolis");
		pf.setEmail("jdweoi@jieo.com");
		pf.setEstado("SC");
		pf.setRg("34343434");
		pf.setRua("Avenida Ivo Silveira");
		pf.setTelefone("48 3232-3232");
//		pessoaDAO.save(pf);
		FactoryDAO.sessionInstance().saveOrUpdate(pf);

		pj = new PessoaJuridica();
		pj.setNome("Comunicandus");
		pj.setCnpj("30.301.301/3000-20");
		pj.setBairro("Centro");
		pj.setCidade("São José");
		pj.setEmail("jdweoi@jieo.com");
		pj.setEstado("SC");
		pj.setInscricaoEstadual("34343434");
		pj.setRua("Avenida Ivo Silveira");
		pj.setTelefone("48 3232-3232");
////		pessoaDAO.save(pj);
		FactoryDAO.sessionInstance().saveOrUpdate(pj);
		
		
//		pf = new PessoaFisica();
//		pf.setNome("João Matos");
//		pf.setCpf("435.215.585-90");
//		pf.setBairro("Centro");
//		pf.setCidade("São José");
//		pf.setEmail("jdweoi@jieo.com");
//		pf.setEstado("SC");
//		pf.setRg("34343434");
//		pf.setRua("Avenida Ivo Silveira");
//		pf.setTelefone("48 3232-3232");
//		pessoaDAO.save(pf);
		
		
		pf = new PessoaFisica();
		pj = new PessoaJuridica();
	}

}