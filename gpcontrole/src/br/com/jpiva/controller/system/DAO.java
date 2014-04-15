package br.com.jpiva.controller.system;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class DAO<T> {
	
	/*Classe para consulta geral, nessa classe determinamos
	 * a consulta genérica de todos os objetos
	 * 
	 */
	protected SessionFactory sf;
	
	public DAO(){
		sf = HibernateUtil.getSessionFactory();
	}
	
	public String insertObject(T o){
		
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try{
		    session.save(o);
	        transaction.commit();
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
			transaction.rollback();
		}finally{
			session.close();
		}
        return null;		
	}
	
	public List<T> getObjectList(String strfilter){
		
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
        try{
        	List<T>obj = session.createQuery(strfilter).list();		
	        transaction.commit();
	        return obj;
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
			transaction.rollback();
		}finally{
			session.close();
		}
		return null;
	}
	
	public Object getObjectId(T obj, String campo, int id){
		
		
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
		
        try{
	        //Filtro conforme o id do parametro
	        Criteria filter = session.createCriteria(obj.getClass());
			filter.add(Restrictions.eq(campo, id));
			obj = (T) filter.uniqueResult();
			transaction.commit();
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
			transaction.rollback();
		}finally{
			session.close();
		}
     	return obj;
	}
}
