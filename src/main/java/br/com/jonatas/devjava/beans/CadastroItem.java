package br.com.jonatas.devjava.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jonatas.devjava.modelo.Item;
import br.com.jonatas.devjava.persistence.ItemPersistence;

@ManagedBean
@ViewScoped
public class CadastroItem {

	private ItemPersistence persistence = new ItemPersistence();

	private Item item = new Item();

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void cadastrar() {
		persistence.salvar(this.item);
	}
}