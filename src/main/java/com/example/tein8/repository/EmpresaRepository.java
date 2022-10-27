package com.example.tein8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tein8.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    
}

