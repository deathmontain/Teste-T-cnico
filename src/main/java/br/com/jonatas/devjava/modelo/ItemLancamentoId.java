package br.com.jonatas.devjava.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemLancamentoId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer lancamento_oid;
	
	private Integer item_oid;

	public Integer getLancamento_oid() {
		return lancamento_oid;
	}

	public void setLancamento_oid(Integer lancamento_oid) {
		this.lancamento_oid = lancamento_oid;
	}

	public Integer getItem_oid() {
		return item_oid;
	}

	public void setItem_oid(Integer item_oid) {
		this.item_oid = item_oid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_oid == null) ? 0 : item_oid.hashCode());
		result = prime * result + ((lancamento_oid == null) ? 0 : lancamento_oid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLancamentoId other = (ItemLancamentoId) obj;
		if (item_oid == null) {
			if (other.item_oid != null)
				return false;
		} else if (!item_oid.equals(other.item_oid))
			return false;
		if (lancamento_oid == null) {
			if (other.lancamento_oid != null)
				return false;
		} else if (!lancamento_oid.equals(other.lancamento_oid))
			return false;
		return true;
	}

}
