package br.com.jonatas.devjava.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jonatas.devjava.modelo.Item;
import br.com.jonatas.devjava.modelo.ItemLancamento;
import br.com.jonatas.devjava.modelo.ItemLancamentoId;
import br.com.jonatas.devjava.modelo.Lancamento;
import br.com.jonatas.devjava.persistence.ItemLancamentoPersistence;
import br.com.jonatas.devjava.persistence.ItemPersistence;
import br.com.jonatas.devjava.persistence.LancamentoPersistence;

@ViewScoped
@ManagedBean
public class CadastroLancamento {
	
	private LancamentoPersistence persistence = new LancamentoPersistence();
	private ItemPersistence itemPersistence = new ItemPersistence();
	private ItemLancamentoPersistence itemLancamentoPersistence = new ItemLancamentoPersistence();
	
	private Lancamento lancamento;
	private List<Item> itens;
	private List<Lancamento> lancamentos;

	public List<Lancamento> getLancamentos() {
		if(lancamentos == null) {
			this.lancamentos = persistence.listar();
		}

		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamento getLancamento() {
		if(lancamento == null) {
			this.lancamento = new Lancamento();
			this.lancamento.setItens(new ArrayList<>());
		}
		
		return lancamento;
	}

	public List<Item> getItens() {
		if(itens == null) {
			this.itens = itemPersistence.listar();
		}
		
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
	public void reload() {
		this.lancamentos = persistence.listar();
		this.lancamento = new Lancamento();		
	}
	
	public void cadastrar() {
		persistence.salvar(this.lancamento);
		lancamento.getItens().forEach(i -> {
			ItemLancamentoId id = new ItemLancamentoId();
			id.setItem_oid(i.getOid());
			id.setLancamento_oid(lancamento.getOid());
			
			ItemLancamento it = new ItemLancamento();
			it.setId(id);
			
			itemLancamentoPersistence.salvar(it);
		
		});
		
		reload();
	}
	
	public void excluir(Lancamento lancamento) {
		itemLancamentoPersistence.excluir(lancamento.getOid());
		persistence.excluir(lancamento.getOid());

		reload();
	}
}