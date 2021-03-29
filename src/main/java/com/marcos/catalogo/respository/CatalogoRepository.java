package com.marcos.catalogo.respository;

import com.marcos.catalogo.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Musica, Long> {
    
}