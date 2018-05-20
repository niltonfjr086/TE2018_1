package test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;


import model.FactoryDAO;
import model.dao.UsuarioDAO;
import model.entity.Usuario;

public class UsuarioTest {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario us = new Usuario();

	@Test
	public void test() {

		testFindAll();
		testUpdate();
//		testDelete();

		FactoryDAO.closeInstance();

	}

	private void testFindAll() {

		if (usuarioDAO.findAll().size() <= 0) {
			adicionarUsuarios();
			System.out.println("Adicionou Pessoas");
			
		}

		List<Usuario> usuarios = usuarioDAO.findAll();
		// List<Usuario> usuarios = FactoryDAO.sessionInstance().createQuery(("FROM " +
		// us.getClass().getSimpleName())).getResultList();
		assertNotNull(usuarios);
		
	}

	private void testUpdate() {

		if (usuarioDAO.findAll().size() <= 0) {
			adicionarUsuarios();
			System.out.println("Adicionou Usuários");
		}

		Usuario usuario = usuarioDAO.findById(1L);

		usuario.setLogin("pedro2020");

		// FactoryDAO.sessionInstance().createQuery(("FROM " +
		// us.getClass().getSimpleName())).getResultList();
		// FactoryDAO.sessionInstance().saveOrUpdate(us);

		usuarioDAO.save(usuario);

		System.out.println("Estado atual - dados usuário: \n" + usuario);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

	}

	private void testDelete() {

		if (usuarioDAO.findAll().size() <= 0) {
			adicionarUsuarios();
			System.out.println("Adicionou Pessoas");
		}

		// Usuario usuario = usuarioDAO.findById(2L);

		usuarioDAO.delete(2L);

		testFindAll();

	}

	private void adicionarUsuarios() {

		us = new Usuario();
		us.setLogin("pedro");
		us.setObservacao("Este usuário foi o primeiro cadastrado");
		us.setDtCadastro(new Date());
		// pessoaDAO.save(us);
		
		FactoryDAO.sessionInstance().saveOrUpdate(us);

		us = new Usuario();
		us.setLogin("maria");
		us.setObservacao("Este usuário foi o segundo cadastrado");
		us.setDtCadastro(new Date());
		usuarioDAO.save(us);
		// FactoryDAO.sessionInstance().saveOrUpdate(us);

		us = new Usuario();
	}

}
