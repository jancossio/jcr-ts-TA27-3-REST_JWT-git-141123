package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="maquinas_registradoras")
public class MaquinaRegistradora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Integer id;
	@Column(name = "piso")
	private Integer piso;
	
	@OneToMany
	@JsonIgnoreProperties("maquinas")
    @JoinColumn(name="id")
    private List<Venta> ventas;

	
	public MaquinaRegistradora() {

	}
	
	public MaquinaRegistradora(Integer id, Integer piso, List<Venta> ventas) {
		super();
		this.id = id;
		this.piso = piso;
		this.ventas = ventas;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Maquina_Registradora [id=" + id + ", piso=" + piso + "]";
	}
}
