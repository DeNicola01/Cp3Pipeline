package com.example.tein8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tein8.model.Empresa;
import com.example.tein8.repository.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    EmpresaRepository repository;

    public List<Empresa> listAll(){
       return repository.findAll();
    }

    public void save(Empresa empresa) {
        repository.save(empresa);
    }

    public Optional<Empresa> getById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}