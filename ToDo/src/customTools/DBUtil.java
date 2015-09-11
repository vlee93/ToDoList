package customTools;
import model.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
private static final EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("ToDo");
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}


		public static void insert(Tuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(user);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}
		
		public static void insert(Todo activity) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(activity);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Tuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(user);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Todo post) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(post);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}
		
		public static void delete(Tuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(user));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
		
		public static void delete(Todo post) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(post));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
		
		public static long isValidUser(Tuser user)
		{
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "Select b.userid from Tuser b where b.username = :username and b.userpass = :userpass";
			Query q = em.createQuery(qString);
			q.setParameter("username", user.getUsername());
			q.setParameter("userpass", user.getUserpass());

			try{
				long userId = (long) q.getSingleResult();
				System.out.println("userId =" + userId);
				if (userId > 0)
				{
					return userId;
				}
				else
				{
					return 0;
					
				}
				
			}catch (Exception e){
				e.printStackTrace();
				return 0;
			}
			finally{
					em.close();		
			}		
		}
		
		public static Tuser getUser (long userID)
		{
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			Tuser user  = em.find(Tuser.class, userID);
			return user;
		}
		
		public static Todo getPost (long postID)
		{
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			Todo post  = em.find(Todo.class, postID);
			return post;
		}
		
		public static List<Todo> postTodoofUser (Tuser user){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			List<Todo> list = null;
			String qString = "select b from Todo b where b.tuser = :tuser";
			
			try{
				Query query = em.createQuery(qString);
				query.setParameter("tuser", user);
				list = query.getResultList();

			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
					em.close();
				}
			return list;
		}


}