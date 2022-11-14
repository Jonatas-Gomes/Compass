package com.compass.api.repository;

import com.compass.api.modelo.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

    Regiao findByNome(String nomeRegiao);
}
