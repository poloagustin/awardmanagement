package ar.com.donpepe.awardmanagement.daos.session;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8960570148142942807L;

	private HibernateSessionFactory() {
		this.factory = new Configuration().configure().buildSessionFactory();
	}
	
	private SessionFactory factory;
	
	private static HibernateSessionFactory instance;
	
	private static Object lockObj = new Object();
	
	public static HibernateSessionFactory getInstance() {
		synchronized (lockObj) {
			if (instance == null) {
				instance = new HibernateSessionFactory();
			}
		}
		return instance;
	}
	
	public Session createSession() {
		return this.factory.openSession();
	}
	
	public void destroySession(Session session) {
		session.close();
	}
}
