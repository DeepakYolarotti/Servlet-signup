package dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class userdeo 
{
   EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
   EntityManager entityManager=entityManagerFactory.createEntityManager();
   EntityTransaction entityTransaction=entityManager.getTransaction();
   
   
   public <User> List<User> find(){
	return entityManager.createQuery("select x from user x").getResultList();
	   
   }
   
   
   
     
   public void save(user user)
   {
	   entityTransaction.begin();
	   entityManager.persist(user);
	   entityTransaction.commit();
   }
   
   public user find(String email){
	   return entityManager.find(user.class,email);
   }
   public void delete(user user)
   {
	   entityTransaction.begin();
	   entityManager.remove(user);
	   entityTransaction.commit();
   }
   public List<user> fetchAll() 
   {
	
	   return entityManager.createQuery("select x from user x").getResultList();
   } 
   public void update(user user)
   {
	   entityTransaction.begin();
	   entityManager.merge(user);
	   entityTransaction.commit();
   }
}