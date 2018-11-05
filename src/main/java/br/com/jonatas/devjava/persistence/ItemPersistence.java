package br.com.jonatas.devjava.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jonatas.devjava.modelo.Item;
import br.com.jonatas.devjava.util.JPAUtil;

public class ItemPersistence {

	public void salvar(Item item) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Item> listar() {
		EntityManager em = new JPAUtil().getEntityManager();
		List<Item> itens = em.createQuery("SELECT i from Item i", Item.class).getResultList();
		em.close();
		return itens;
	}

	public Object encontrar(Integer itemId) {
		EntityManager em = new JPAUtil().getEntityManager();
		Item item = new Item();
		item = em.find(Item.class, itemId);
		em.close();
		return item;
	}
}
