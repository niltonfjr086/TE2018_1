package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.FactoryDAO;
import model.dao.PessoaDAO;
import model.dao.PessoaFisicaDAO;
import model.dao.PessoaJuridicaDAO;
import model.entity.Pessoa;
import model.entity.PessoaFisica;
import model.entity.PessoaJuridica;

public class PessoaTest {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
//	private Pessoa pessoa = new Pessoa();
	
	private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	private PessoaFisica pf = new PessoaFisica();

	private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	private PessoaJuridica pj = new PessoaJuridica();
	
	@Test
	public void testFindAll() {
		
		List<Pessoa> pessoas = new ArrayList<>();
		
//		pessoas.addAll(FactoryDAO.sessionInstance().createQuery(("FROM " + pj.getClass().getSimpleName())).getResultList());
//		pessoas.addAll(FactoryDAO.sessionInstance().createQuery(("FROM " + pf.getClass().getSimpleName())).getResultList());
		
//		pessoas.addAll(pessoaFisicaDAO.findAll());
//		pessoas.addAll(pessoaJuridicaDAO.findAll());
		
		pessoas.addAll(pessoaDAO.findAll());
		
		if (pessoas.size() <= 0) {
			adicionarPessoas();
			updatePJ();
			deletePF();
			
			System.out.println("Adicionou, atualizou, apagou e leu Pessoas");
			pessoas = new ArrayList<>();
			pessoas.addAll(pessoaFisicaDAO.findAll());
			pessoas.addAll(pessoaJuridicaDAO.findAll());
		}
		
//		pessoas.addAll(FactoryDAO.sessionInstance().createQuery(("FROM " + pj.getClass().getSimpleName())).getResultList());
//		pessoas.addAll(FactoryDAO.sessionInstance().createQuery(("FROM " + pf.getClass().getSimpleName())).getResultList());

		
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
//		pessoaFisicaDAO.save(pf);
		pessoaDAO.save(pf);
//		FactoryDAO.sessionInstance().saveOrUpdate(pf);
		

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
//		pessoaJuridicaDAO.save(pj);
		pessoaDAO.save(pj);
//		FactoryDAO.sessionInstance().saveOrUpdate(pj);
		
		
		
		pf = new PessoaFisica();
		pf.setNome("João Matos");
		pf.setCpf("435.215.585-90");
		pf.setBairro("Centro");
		pf.setCidade("São José");
		pf.setEmail("jdweoi@jieo.com");
		pf.setEstado("SC");
		pf.setRg("34343434");
		pf.setRua("Avenida Ivo Silveira");
		pf.setTelefone("48 3232-3232");
//		pessoaFisicaDAO.save(pf);
		pessoaDAO.save(pf);
		
		
		pf = new PessoaFisica();
		pj = new PessoaJuridica();
	}
	
	private void updatePJ() {
		
		try {
			PessoaJuridica pj = pessoaJuridicaDAO.findById(1L);
			
			pj.setNome("Komunicandoit");
			
			pessoaDAO.update(pj);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void deletePF() {
		
		try {
			PessoaFisica pf = pessoaFisicaDAO.findById(2L);
			
			System.out.println("Sendo apagado: " + pf.toString());
			
			pessoaFisicaDAO.delete(pf.getId());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}