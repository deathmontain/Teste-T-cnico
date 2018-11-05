package br.com.jonatas.devjava.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oid;

	@Temporal(TemporalType.DATE)
	private Calendar dt_inicial;

	@Temporal(TemporalType.DATE)
	private Calendar dt_final;

	private BigDecimal vl_total;

	private String observacao;

	@Transient
	private List<Item> itens;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> item) {
		this.itens = item;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Calendar getDt_inicial() {
		return dt_inicial;
	}

	public void setDt_inicial(Calendar dt_inicial) {
		this.dt_inicial = dt_inicial;
	}

	public Calendar getDt_final() {
		return dt_final;
	}

	public void setDt_final(Calendar dt_final) {
		this.dt_final = dt_final;
	}

	public BigDecimal getVl_total() {
		if(this.itens != null && !this.itens.isEmpty()) {
			Double aux = 0.0;
			for(Item item:itens) {
				aux += item.getValor().doubleValue();
			}
			
			vl_total = BigDecimal.valueOf(aux);
			
		}
		
		return vl_total;
	}

	public void setVl_total(BigDecimal vl_total) {
		this.vl_total = vl_total;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}