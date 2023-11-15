package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	public List<MaquinaRegistradora> listarMaquinasRegistradoras(); 
	
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);	
	
	public MaquinaRegistradora  maquinaRegistradoraXID(Integer id); 
	
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora); 
	
	public void eliminarMaquinaRegistradora(Integer id);
}
