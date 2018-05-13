package io.spring.crud.cartorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.crud.cartorio.model.Cartorio;
import io.spring.crud.cartorio.service.CartorioService;

@RestController
public class CartorioControllerWS {
	
	private CartorioService cartorioService;
	private Cartorio cartorio;

	@Autowired
	public CartorioControllerWS(CartorioService cartorioService) {
		this.cartorioService = cartorioService;
	}
	
	@RequestMapping(value = "/api-todos")
	@ResponseBody
	public List<Cartorio> getTodosCartorios(){
		cartorio = new Cartorio();
		cartorio.setId(1l);
		cartorio.setNome("sao vicente");
		cartorioService.insertCartorio(cartorio);
		return cartorioService.getAllCartorios();
	}
}
