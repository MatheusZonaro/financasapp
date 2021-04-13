package com.zonaro.financasapp.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zonaro.financasapp.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
