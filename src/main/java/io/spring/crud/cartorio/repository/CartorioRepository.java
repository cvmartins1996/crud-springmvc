package io.spring.crud.cartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.spring.crud.cartorio.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long>{
}
