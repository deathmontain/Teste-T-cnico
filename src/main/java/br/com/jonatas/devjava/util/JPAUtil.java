package br.com.jonatas.devjava.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("devjava");
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
