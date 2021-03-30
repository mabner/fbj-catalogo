package com.marcos.catalog.respository;

import com.marcos.catalog.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Music, Long> {
    
}