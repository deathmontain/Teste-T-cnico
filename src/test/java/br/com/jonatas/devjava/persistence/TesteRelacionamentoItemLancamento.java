package br.com.jonatas.devjava.persistence;

import java.math.BigDecimal;
import javax.persistence.EntityManager;

import br.com.jonatas.devjava.modelo.Item;
import br.com.jonatas.devjava.modelo.ItemLancamento;
import br.com.jonatas.devjava.modelo.ItemLancamentoId;
import br.com.jonatas.devjava.modelo.Lancamento;
import br.com.jonatas.devjava.util.JPAUtil;

public class TesteRelacionamentoItemLancamento {

	public static void main(String[] args) {
		Item item = new Item();
		item.setDescricao("Viagem as ondas");
		item.setValor(new BigDecimal("100.0"));

		Lancamento lancamento = new Lancamento();
		lancamento.setDt_inicial(null);
		lancamento.setDt_final(null);
		lancamento.setObservacao("Viagem à SP");
		lancamento.setVl_total(new BigDecimal("100.0"));

		ItemLancamento itemLancamento = new ItemLancamento();
		ItemLancamentoId idRelacionamento = new ItemLancamentoId();
		itemLancamento.setId(idRelacionamento);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(item);
		em.persist(lancamento);
		
		idRelacionamento.setItem_oid(item.getOid());
		idRelacionamento.setLancamento_oid(lancamento.getOid());
		
		em.persist(itemLancamento);

		em.getTransaction().commit();
		em.close();
	}
}