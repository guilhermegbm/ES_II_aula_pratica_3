package com.esii.aulapratica3.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	// insert into EMPRESA values (1, 'abc', '2022-06-17');

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "cnpj", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "data_abertura")
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

}
