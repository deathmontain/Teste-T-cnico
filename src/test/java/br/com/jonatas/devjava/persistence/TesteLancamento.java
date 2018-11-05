package br.com.jonatas.devjava.persistence;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.jonatas.devjava.modelo.Lancamento;
import br.com.jonatas.devjava.util.JPAUtil;

public class TesteLancamento {
	@Test
	public void testarInsercaoLancamento() {
		Lancamento lancamento = new Lancamento();
		
		lancamento.setDt_inicial(null); 
		lancamento.setDt_final(null);
		lancamento.setObservacao("Viagem à SP");
		lancamento.setVl_total(new BigDecimal("100.0"));
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(lancamento);
		em.getTransaction().commit();
	}
}