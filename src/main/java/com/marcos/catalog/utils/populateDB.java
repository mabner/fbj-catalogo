package com.marcos.catalog.utils;


import com.marcos.catalog.model.Music;
import com.marcos.catalog.respository.CatalogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.PostConstruct;

@Component
public class populateDB {

    @Autowired
    CatalogRepository catalogRepository;

    //@PostConstruct
    public void addDefaultMusic(){

        List<Music> listMusic = new ArrayList<>();

        Music music1 = new Music();
        Music music2 = new Music();

        music1.setAuthor("Renato Russo");
        music1.setDate(LocalDate.now());
        music1.setTitle("Serenissima");
        music1.setLyrics("Sou um animal sentimental Me apego facilmente a quem desperta meu desejo Tente me obrigar a fazer o que eu não quero E cê vai logo ver o que acontece Acho que entendo você quis me dizer Mas existem outras coisas Consegui meu equilí­brio cortejando a insanidade Tudo está perdido mas existem possibilidades Tí­nhamos a ideia, você mudou os planos Tí­nhamos um plano, você mudou de ideia Já passou, já passou - quem sabe outro dia Antes eu sonhava, agora já não durmo Quando foi que competimos pela primeira vez O que ninguém percebe é o que todo mundo sabe Não entendo terrorismo, falávamos de amizade Não estou mais interessado no que sinto.");

        music2.setAuthor("Robert Plant");
        music2.setDate(LocalDate.now());
        music2.setTitle("All My Love");
        music2.setLyrics("Should I fall out of love, my fire in the light To chase a feather in the wind  Within the glow that weaves a cloak of delight There moves a thread that has no end For many hours and days that pass ever soon The tides have caused the flame to dim At last the arm is straight, the hand to the loom Is this to end or just begin? All of my love, all of my love All of my love to you, oh All of my love, all of my love, oh All of my love to you. I get a little bit lonely");

        listMusic.add(music1);
        listMusic.add(music2);

        for (Music music : listMusic) {

            Music saveMusic = catalogRepository.save(music);
            System.out.println(saveMusic.getId());
        }

    }

}
