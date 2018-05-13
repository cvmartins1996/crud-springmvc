package io.spring.crud.cartorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.crud.cartorio.model.Cartorio;
import io.spring.crud.cartorio.repository.CartorioRepository;
@Service
public class CartorioServiceImpl implements CartorioService {

	@Autowired
	private CartorioRepository cartorioRepository;
	
	@Override
	public Cartorio insertCartorio(Cartorio cartorio) {
		if (cartorio.getNome() == null || cartorio.getNome().equals("")) {
			throw new IllegalArgumentException("Nome não pode ser nulo");
		}
		return cartorioRepository.save(cartorio);
	}

	@Override
	public Cartorio getCartorio(Long id) {
		return cartorioRepository.getOne(id);
	}

	@Override
	public Cartorio updateCartorio(Cartorio cartorio) {
		if (cartorio.getNome() == null || cartorio.getNome().equals("")) {
			throw new IllegalArgumentException("Nome não pode ser nulo");
		}
		return cartorioRepository.save(cartorio);
	}

	@Override
	public void deleteCartorio(Cartorio cartorio) {
		cartorioRepository.delete(cartorio);
	}

	@Override
	public void deleteCartorio(Long id) {
		cartorioRepository.deleteById(id);
	}

	@Override
	public List<Cartorio> getAllCartorios() {
		return cartorioRepository.findAll();
	}

	
}
