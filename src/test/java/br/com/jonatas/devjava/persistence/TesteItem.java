package br.com.jonatas.devjava.persistence;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.jonatas.devjava.modelo.Item;
import br.com.jonatas.devjava.util.JPAUtil;

public class TesteItem {

	@Test
	public void testarInsercaoItem() {
		Item item = new Item();

		item.setDescricao("Viagem as ondas");
		item.setValor(new BigDecimal("100.0"));

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();

	}
}
