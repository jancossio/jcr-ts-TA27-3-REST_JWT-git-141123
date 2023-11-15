package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajeroDAO;
import com.example.demo.dto.Cajero;

@Service
public class CajeroServiceImpl implements ICajeroService{

	@Autowired
	ICajeroDAO iCajeroDAO;
	
	@Override
	public List<Cajero> listarCajeros(){
		return iCajeroDAO.findAll();
	}
	
	@Override
	public Cajero guardarCajero(Cajero cajero) {
		return iCajeroDAO.save(cajero);
	}
	
	@Override
	public Cajero cajeroXID(Integer id) {
		return iCajeroDAO.findById(id).get();
	}
	
	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		return iCajeroDAO.save(cajero);
	}
	
	@Override
	public void eliminarCajero(Integer id) {
		iCajeroDAO.deleteById(id);
	}
}
