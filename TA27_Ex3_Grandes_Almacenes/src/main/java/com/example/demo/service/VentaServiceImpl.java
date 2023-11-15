package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	IVentaDAO iVentaDAO;
	
	@Override
	public List<Venta> listarVentas(){
		return iVentaDAO.findAll();
	}
	
	@Override
	public Venta guardarVenta(Venta venta) {
		return iVentaDAO.save(venta);
	}
	
	@Override
	public Venta ventaXID(Integer id) {
		return iVentaDAO.findById(id).get();
	}
	
	@Override
	public Venta actualizarVenta(Venta venta) {
		return iVentaDAO.save(venta);
	}
	
	@Override
	public void eliminarVenta(Integer id) {
		 iVentaDAO.deleteById(id);
	}
}
