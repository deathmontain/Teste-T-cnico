package br.com.jonatas.devjava.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jonatas.devjava.modelo.ItemLancamento;
import br.com.jonatas.devjava.modelo.Lancamento;
import br.com.jonatas.devjava.util.JPAUtil;

public class ItemLancamentoPersistence {

	public void salvar(ItemLancamento itemLancamento) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(itemLancamento);
		em.getTransaction().commit();
		em.close();
	}

	public List<ItemLancamento> listar(Lancamento lancamento) {
		EntityManager em = new JPAUtil().getEntityManager();
		List<ItemLancamento> itens = em
				.createQuery("SELECT it from ItemLancamento it WHERE it.lancamento = :lancamento", ItemLancamento.class)
				.setParameter("lancamento", lancamento).getResultList();
		em.close();
		return itens;
	}

	public void excluir(Integer lancamentoOid) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		List<ItemLancamento> itens = em
				.createQuery("SELECT it from ItemLancamento it WHERE it.lancamento.oid = :lancamentoId",
						ItemLancamento.class)
				.setParameter("lancamentoId", lancamentoOid).getResultList();

		for (ItemLancamento it : itens) {
			em.remove(it);
		}

		em.getTransaction().commit();
		em.close();
	}
}
