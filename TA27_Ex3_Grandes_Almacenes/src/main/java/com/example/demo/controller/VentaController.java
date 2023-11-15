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

import com.example.demo.dto.Venta;
import com.example.demo.service.VentaServiceImpl;

@RestController
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/all")
	public List<Venta> listarVentas(){
		return ventaServiceImpl.listarVentas();
	}
	
	
	@PostMapping("/add")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	
	@GetMapping("/{codigo}")
	public Venta ventaXID(@PathVariable(name="codigo") Integer id) {
		
		Venta Venta_xid= new Venta();
		
		Venta_xid=ventaServiceImpl.ventaXID(id);
		
		return Venta_xid;
	}
	
	@PutMapping("/{codigo}")
	public Venta actualizarVenta(@PathVariable(name="codigo")Integer id,@RequestBody Venta venta) {
		
		Venta Venta_seleccionada= new Venta();
		Venta Venta_actualizada= new Venta();
		
		Venta_seleccionada= ventaServiceImpl.ventaXID(id);
		
		Venta_seleccionada.setMaquina_Registradora(venta.getMaquina_Registradora());
		Venta_seleccionada.setCajero(venta.getCajero());
		Venta_seleccionada.setProducto(venta.getProducto());
		
		Venta_actualizada = ventaServiceImpl.actualizarVenta(Venta_seleccionada);
				
		return Venta_actualizada;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarVenta(@PathVariable(name="codigo")Integer id) {
		ventaServiceImpl.eliminarVenta(id);
	}
}
