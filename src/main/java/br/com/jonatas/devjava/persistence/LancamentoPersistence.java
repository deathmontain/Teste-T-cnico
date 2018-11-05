package br.com.jonatas.devjava.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jonatas.devjava.modelo.Lancamento;
import br.com.jonatas.devjava.util.JPAUtil;

public class LancamentoPersistence {
	
	public void salvar(Lancamento lancamento) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(lancamento);
		
		em.getTransaction().commit();
		em.close();
	}

	public List<Lancamento> listar() {
		EntityManager em = new JPAUtil().getEntityManager();
		List<Lancamento> lancamentos = em.createQuery("SELECT l from Lancamento l", Lancamento.class).getResultList();
		em.close();
		return lancamentos;
	}

	public void excluir(Integer lancamentoId) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Lancamento lancamento = new Lancamento();
		lancamento = em.find(Lancamento.class, lancamentoId);
		
		em.remove(lancamento);
		em.getTransaction().commit();

		em.close();
	}
}