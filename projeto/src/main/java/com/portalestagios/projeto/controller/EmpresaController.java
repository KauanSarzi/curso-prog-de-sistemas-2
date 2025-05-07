package com.portalestagios.projeto.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalestagios.projeto.models.Empresa;


@RestController
@RequestMapping("/api")
public class EmpresaController {

    private List<Empresa> empresas;

    public EmpresaController() {
        empresas = new ArrayList<>();
        empresas.add(new Empresa(1L, "12.345.678/0001-99", "Tech Solutions", "contato@tech.com", "Rua das Flores, 100", "Empresa de tecnologia", "11999990000", "Tecnologia"));
        empresas.add(new Empresa(2L, "98.765.432/0001-55", "EducaMais", "contato@educamais.com", "Av. Brasil, 500", "Instituição de ensino", "11888880000", "Educação"));
        empresas.add(new Empresa(3L, "11.111.111/0001-11", "Vida Saudável", "saude@vida.com", "Rua Saúde, 123", "Clínica de saúde", "11777770000", "Saúde"));
    }

    @GetMapping("/api/empresas")
    public List<Empresa> getEmpresas() {
        return empresas;
    }


  

}
