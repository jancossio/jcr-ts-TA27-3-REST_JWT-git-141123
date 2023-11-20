package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDAO;
import com.example.demo.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoDAO iProductoDAO;
	
	@Override
	public List<Producto> listarProductos(){
		return iProductoDAO.findAll();
	}
	
	@Override
	public Producto guardarProducto(Producto cajero) {
		return iProductoDAO.save(cajero);
	}
	
	@Override
	public Producto productoXID(Integer id) {
		return iProductoDAO.findById(id).get();
	}
	
	@Override
	public Producto actualizarProducto(Producto cajero) {
		return iProductoDAO.save(cajero);
	}
	
	@Override
	public void eliminarProducto(Integer id) {
		iProductoDAO.deleteById(id);
	}
}
