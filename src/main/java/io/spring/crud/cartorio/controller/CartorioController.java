package io.spring.crud.cartorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.spring.crud.cartorio.model.Cartorio;
import io.spring.crud.cartorio.service.CartorioService;

@Controller
public class CartorioController {

	
	private CartorioService cartorioService;

	@Autowired
	public CartorioController(CartorioService cartorioService) {
		this.cartorioService = cartorioService;
	}
	
	@RequestMapping(value = "" )
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/cartorio", method = RequestMethod.GET)
	public String crud(Model model) {
		model.addAttribute("cartorio", new Cartorio());
		return "crud";
	}
	
	@RequestMapping(value = "/cartorio-inserir", method = RequestMethod.POST)
	public String insertCartorio(@ModelAttribute Cartorio cartorio, Model model) {
		try {
			cartorioService.insertCartorio(cartorio);
			model.addAttribute("cartorios", cartorioService.getAllCartorios());	
			return "browser";
		} catch (Exception e) {
			return "crud";
		}
	}
	
	@RequestMapping(value = "/cartorios-browser")
	public String browser(Model model) {
		model.addAttribute("cartorios", cartorioService.getAllCartorios());
		return "browser";
	}
	
	@RequestMapping(value = "/cartorio-editar{id}", method = RequestMethod.GET)
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("cartorio", cartorioService.getCartorio(id));
		return "update";
	}
	
	@RequestMapping(value = "/cartorio-salvar", method = RequestMethod.POST)
	public String salvarUpdate(@ModelAttribute Cartorio cartorio, Model model) {
		try {
			cartorioService.updateCartorio(cartorio);
			model.addAttribute("cartorios", cartorioService.getAllCartorios());
		} catch (Exception e) {
			return "update";
		}
		return "browser";
	}
	
	@RequestMapping(value = "/deletar{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id, Model model) {
		cartorioService.deleteCartorio(id);
		model.addAttribute("cartorios", cartorioService.getAllCartorios());
		return "browser";
	}
	
}
