package framework;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError("Initial SessionFactory creation failed." + ex);
		}
	}

	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	public static Session currentSession() throws HibernateException {
		Session s = session.get(); // Open a new Session, if this Thread has none yet
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = session.get();
		session.set(null);
		if (s != null) {
			s.close();
		}
	}
}
