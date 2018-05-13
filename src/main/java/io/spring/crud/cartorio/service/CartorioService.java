package io.spring.crud.cartorio.service;

import java.util.List;

import io.spring.crud.cartorio.model.Cartorio;

public interface CartorioService {

	Cartorio insertCartorio(Cartorio cartorio);
	Cartorio getCartorio(Long id);
	Cartorio updateCartorio(Cartorio cartorio);
	void deleteCartorio(Cartorio cartorio);
	void deleteCartorio(Long id);
	List<Cartorio> getAllCartorios();
}
