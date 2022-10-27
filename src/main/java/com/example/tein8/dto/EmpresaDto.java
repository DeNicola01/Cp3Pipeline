package com.example.tein8.dto;

public record EmpresaDto (

     Long id,
     String empresa

) {

     public EmpresaDto(String empresa){
          this(0l, empresa);
     }

}