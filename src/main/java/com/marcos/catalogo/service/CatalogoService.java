package com.marcos.catalogo.service;

import java.util.List;
import com.marcos.catalogo.model.Musica;


public interface CatalogoService {
    List<Musica> findAll();
    Musica findById(long id);
    Musica save(Musica musica);
    void excluir(long id);
}