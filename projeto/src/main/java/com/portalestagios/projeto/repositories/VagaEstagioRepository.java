package com.portalestagios.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalestagios.projeto.models.VagaEstagio;

public interface VagaEstagioRepository extends JpaRepository<VagaEstagio, Long> {

    VagaEstagio findVagaEstagioModelByTitulo(String titulo); //query(interna) para buscar na base de dados uma determinada vaga de estagio e seu titulo 

    VagaEstagio findVagaEstagioModelById(Long id);


    //@Query PARA CONSULTAS MAIS COMPLEXAS


}
