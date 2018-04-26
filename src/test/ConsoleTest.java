package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.FactoryDAO;

public class ConsoleTest {

	public static void main(String[] args) {

		// Session db = FactoryDAO.sessionInstance();

		// System.out.println("OK");
		//
		// Date dtTeste = defineData("01/01/2000");
		// SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		// System.out.println(simpleDate.format(dtTeste));
		// System.out.println(dtTeste);

		Configuration cfg;
		SessionFactory sessionFactory;
		Session session;

		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		
//		session.createSQLQuery("").executeUpdate();
		session.createNamedQuery("");

		session.close();
		sessionFactory.close();

	}

	static Date defineData(String date) {

		Date retorno = new Date();

		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			retorno = simpleDate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retorno;
	}

}