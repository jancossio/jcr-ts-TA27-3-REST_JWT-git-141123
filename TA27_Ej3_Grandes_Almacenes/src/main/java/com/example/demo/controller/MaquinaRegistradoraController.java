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

import com.example.demo.dto.MaquinaRegistradora;
import com.example.demo.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/maquina")
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraServiceImpl maquinaServiceImpl;
	
	@GetMapping("/all")
	public List<MaquinaRegistradora> listarMaquinasRegistradoras(){
		
		return maquinaServiceImpl.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/add")
	public MaquinaRegistradora salvarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquina) {	
		
		return maquinaServiceImpl.guardarMaquinaRegistradora(maquina);
	}
	
	
	@GetMapping("/{codigo}")
	public MaquinaRegistradora maquinaRegistradoraXID(@PathVariable(name="codigo") Integer id) {
		
		MaquinaRegistradora MaquinaRegistradora_xid= new MaquinaRegistradora();
		
		MaquinaRegistradora_xid=maquinaServiceImpl.maquinaRegistradoraXID(id);
		
		return MaquinaRegistradora_xid;
	}
	
	@PutMapping("/{codigo}")
	public MaquinaRegistradora actualizarVenta(@PathVariable(name="codigo")Integer id,@RequestBody MaquinaRegistradora maquina) {
		
		MaquinaRegistradora Maquina_seleccionada= new MaquinaRegistradora();
		MaquinaRegistradora Maquina_actualizada= new MaquinaRegistradora();
		
		Maquina_seleccionada= maquinaServiceImpl.maquinaRegistradoraXID(id);
		
		Maquina_seleccionada.setPiso(maquina.getPiso());
		Maquina_seleccionada.setVentas((maquina.getVentas()));
		
		Maquina_actualizada = maquinaServiceImpl.actualizarMaquinaRegistradora(Maquina_seleccionada);
				
		return Maquina_actualizada;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarVenta(@PathVariable(name="codigo")Integer id) {
		maquinaServiceImpl.eliminarMaquinaRegistradora(id);
	}
}
