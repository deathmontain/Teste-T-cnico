package br.com.jonatas.devjava.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemLancamento {
	
	@EmbeddedId
	private ItemLancamentoId id;

	@ManyToOne
	@JoinColumn(name="lancamento_oid", insertable = false, updatable = false)
	private Lancamento lancamento;

	@ManyToOne
	@JoinColumn(name="item_oid", insertable = false, updatable = false)
	private Item item;

	public ItemLancamentoId getId() {
		return id;
	}

	public void setId(ItemLancamentoId id) {
		this.id = id;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}