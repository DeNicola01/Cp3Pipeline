package com.example.tein8.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tein8.model.Empresa;
import com.example.tein8.service.EmpresaService;


@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {



    @Autowired
    private EmpresaService service;
    
    @GetMapping
    public List<Empresa> index(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa){
        service.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }
     
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Empresa> optional = service.getById(id);

        if(optional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id,@RequestBody Empresa newEmpresa) {
        // bucar tarefa no bf
        Optional<Empresa> optional = service.getById(id);

        // verificar se existe tarefa com esse id
        if(optional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        //atualizar os dados no objeto en
        var empresa = optional.get();
        BeanUtils.copyProperties(newEmpresa, empresa);
        empresa.setId(id);

        //salvar no bd
        service.save(empresa);

        return ResponseEntity.ok(empresa);
    }
}
