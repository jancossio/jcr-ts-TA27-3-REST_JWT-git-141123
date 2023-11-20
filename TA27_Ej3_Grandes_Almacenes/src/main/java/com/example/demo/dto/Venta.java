package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JsonIgnoreProperties("maquinas")
    @JoinColumn(name = "cod_producto")
    Producto producto;
 
    @ManyToOne
    @JsonIgnoreProperties("maquinas")
    @JoinColumn(name = "cod_cajero")
    Cajero cajero;
    
    @ManyToOne
    @JsonIgnoreProperties("maquinas")
    @JoinColumn(name = "cod_maquina")
    MaquinaRegistradora maquina_Registradora;
    
    
    public Venta() {
    	
    }

	public Venta(Integer id, Producto producto, Cajero cajero, MaquinaRegistradora maquina_Registradora) {
		super();
		this.id = id;
		this.producto = producto;
		this.cajero = cajero;
		this.maquina_Registradora = maquina_Registradora;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public MaquinaRegistradora getMaquina_Registradora() {
		return maquina_Registradora;
	}

	public void setMaquina_Registradora(MaquinaRegistradora maquina_Registradora) {
		this.maquina_Registradora = maquina_Registradora;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", producto=" + producto + ", cajero=" + cajero + ", maquina_Registradora="
				+ maquina_Registradora + "]";
	}
}
