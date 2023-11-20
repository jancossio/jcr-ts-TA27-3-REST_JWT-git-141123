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

import com.example.demo.dto.Cajero;
import com.example.demo.service.CajeroServiceImpl;

@RestController
@RequestMapping("/cajero")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	@GetMapping("/all")
	public List<Cajero> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	
	@PostMapping("/add")
	public Cajero salvarCajero(@RequestBody Cajero cajero) {
		
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	
	
	@GetMapping("/{codigo}")
	public Cajero cajeroXID(@PathVariable(name="codigo") Integer id) {
		
		Cajero Cajero_xid= new Cajero();
		
		Cajero_xid=cajeroServiceImpl.cajeroXID(id);
		
		return Cajero_xid;
	}
	
	@PutMapping("/{codigo}")
	public Cajero actualizarCajero(@PathVariable(name="codigo")Integer id,@RequestBody Cajero cajero) {
		
		Cajero Cajero_seleccionado= new Cajero();
		Cajero Cajero_actualizado= new Cajero();
		
		Cajero_seleccionado= cajeroServiceImpl.cajeroXID(id);
		
		Cajero_seleccionado.setNombreApellidos(cajero.getNombreApellidos());
		
		Cajero_actualizado = cajeroServiceImpl.actualizarCajero(Cajero_seleccionado);
				
		return Cajero_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarCajero(@PathVariable(name="codigo")Integer id) {
		cajeroServiceImpl.eliminarCajero(id);
	}
}
