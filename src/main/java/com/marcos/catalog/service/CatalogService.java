package com.marcos.catalogo.service;

import java.util.List;

import com.marcos.catalogo.model.Music;


public interface CatalogService {
    List<Music> findAll();
    Music findById(long id);
    Music save(Music music);
    void delete(long id);
}