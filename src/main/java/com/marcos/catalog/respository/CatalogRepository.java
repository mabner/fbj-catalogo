package com.marcos.catalogo.respository;

import com.marcos.catalogo.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Music, Long> {
    
}