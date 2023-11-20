package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinaRegistradoraDAO;
import com.example.demo.dto.MaquinaRegistradora;

@Service
public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraService{

	@Autowired
	IMaquinaRegistradoraDAO IMaquinaRegistradoraDAO;
	
	@Override
	public List<MaquinaRegistradora> listarMaquinasRegistradoras(){
		return IMaquinaRegistradoraDAO.findAll();
	}
	
	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return IMaquinaRegistradoraDAO.save(maquinaRegistradora);
	}
	
	@Override
	public MaquinaRegistradora maquinaRegistradoraXID(Integer id) {
		return IMaquinaRegistradoraDAO.findById(id).get();
	}
	
	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return IMaquinaRegistradoraDAO.save(maquinaRegistradora);

	}
	
	@Override
	public void eliminarMaquinaRegistradora(Integer id) {
		IMaquinaRegistradoraDAO.deleteById(id);
	}
}
