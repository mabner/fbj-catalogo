package com.marcos.catalogo.service.serviceimpl;

import java.util.List;

import com.marcos.catalogo.model.Music;
import com.marcos.catalogo.respository.CatalogRepository;
import com.marcos.catalogo.service.CatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogRepository catalogRepository;


    @Override
    public List<Music> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Music findById(long id) {
        return catalogRepository.findById(id).get();
    }

    @Override
    public Music save(Music music) {
        return catalogRepository.save(music);
    }

    @Override
    public void delete(long id) {
        catalogRepository.deleteById(id);
    }
    
}