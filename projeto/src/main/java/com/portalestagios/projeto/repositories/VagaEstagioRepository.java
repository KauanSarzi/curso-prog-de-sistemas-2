package com.portalestagios.projeto.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.portalestagios.projeto.models.VagaEstagioModel;

public interface VagaEstagioRepository extends JpaRepository<VagaEstagioModel, UUID> {

    VagaEstagioModel findVagaEstagioModelByTitulo(String titulo); //query(interna) para buscar na base de dados uma determinada vaga de estagio e seu titulo 

    VagaEstagioModel findVagaEstagioModelById(UUID id);


    //@Query PARA CONSULTAS MAIS COMPLEXAS


}
