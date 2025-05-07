package com.portalestagios.projeto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portalestagios.projeto.dtos.EmpresaDTO;
import com.portalestagios.projeto.models.Empresa;
import com.portalestagios.projeto.repositories.EmpresaRepository;


@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;


    // CADATRO NOVA EMPRESA
    @PostMapping
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody EmpresaDTO dto) { // DTO VAI GRAVAR OS DADOS PASSADOS PELO USUARIO
        Empresa empresa = new Empresa();
        empresa.setNomeFantasia(dto.nomeFantasia());
        empresa.setCnpj(dto.cnpj());
        empresa.setEmailContato(dto.emailContato());
        empresa.setEndereco(dto.endereco());
        empresa.setDescricao(dto.descricao());
        empresa.setTelefoneContato(dto.telefoneContato()); 
        empresa.setRamoAtuacao(dto.ramoAtuacao());         
        return ResponseEntity.ok(empresaRepository.save(empresa));
    }



    //BUSCA A EMPRESA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);

        if (empresa.isEmpty()){
            return ResponseEntity.notFound().build(); //reponse entity vai construir manualmente uma reposta http de status 404
            //ou criar uma exceçao
        }else{
            return ResponseEntity.ok(empresa.get());

        }


    }


    //deleta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!empresaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }else{
            empresaRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }
    }




     

      






   





    

    


  

}
