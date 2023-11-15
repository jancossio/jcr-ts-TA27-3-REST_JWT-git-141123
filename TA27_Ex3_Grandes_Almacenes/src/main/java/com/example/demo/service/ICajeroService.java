package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajero;

public interface ICajeroService {

	public List<Cajero> listarCajeros(); 
	
	public Cajero guardarCajero(Cajero cajero);	
	
	public Cajero cajeroXID(Integer id); 
	
	public Cajero actualizarCajero(Cajero cajero); 
	
	public void eliminarCajero(Integer id);
}
