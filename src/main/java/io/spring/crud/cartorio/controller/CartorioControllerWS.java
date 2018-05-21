package io.spring.crud.cartorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.crud.cartorio.model.Cartorio;
import io.spring.crud.cartorio.service.CartorioService;

@RestController
@CrossOrigin
public class CartorioControllerWS {
	
	private CartorioService cartorioService;
	
	@Autowired
	public CartorioControllerWS(CartorioService cartorioService) {
		this.cartorioService = cartorioService;
	}
	
	@RequestMapping(value = "/api-todos")
	public List<Cartorio> getTodosCartorios(){
		return cartorioService.getAllCartorios();
	}
	
	@RequestMapping(value = "/inserir")
	@CrossOrigin
	public void insertCartorio(@RequestBody Cartorio cartorio) {
		cartorioService.insertCartorio(cartorio);
	}
	
}
