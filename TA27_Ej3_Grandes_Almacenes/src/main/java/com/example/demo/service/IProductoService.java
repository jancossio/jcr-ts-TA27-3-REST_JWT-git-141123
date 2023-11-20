package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Producto;

public interface IProductoService {

	public List<Producto> listarProductos(); 
	
	public Producto guardarProducto(Producto producto);	
	
	public Producto productoXID(Integer id); 
	
	public Producto actualizarProducto(Producto producto); 
	
	public void eliminarProducto(Integer id);
}
