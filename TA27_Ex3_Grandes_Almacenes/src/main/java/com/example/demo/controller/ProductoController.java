package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoServiceImpl;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/all")
	public List<Producto> listarProductos(){
		return productoServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/add")
	public Producto salvarProducto(@RequestBody Producto producto) {
		
		return productoServiceImpl.guardarProducto(producto);
	}
	
	
	@GetMapping("/{codigo}")
	public Producto productoXID(@PathVariable(name="codigo") Integer id) {
		
		Producto producto_xid= new Producto();
		
		producto_xid=productoServiceImpl.productoXID(id);
		
		return producto_xid;
	}
	
	@PutMapping("/{codigo}")
	public Producto actualizarProducto(@PathVariable(name="codigo")Integer id,@RequestBody Producto producto) {
		
		Producto Producto_seleccionado= new Producto();
		Producto Producto_actualizado= new Producto();
		
		Producto_seleccionado= productoServiceImpl.productoXID(id);
		
		Producto_seleccionado.setNombre(producto.getNombre());
		Producto_seleccionado.setPrecio(producto.getPrecio());

		Producto_actualizado = productoServiceImpl.actualizarProducto(Producto_seleccionado);
				
		return Producto_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarProducto(@PathVariable(name="codigo")Integer id) {
		productoServiceImpl.eliminarProducto(id);
	}
}
