package com.marcos.catalogo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.marcos.catalogo.model.Music;
import com.marcos.catalogo.service.CatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @RequestMapping(value="/musicas", method=RequestMethod.GET)
    public ModelAndView getMusicas() {
       ModelAndView mv = new ModelAndView("musicas");
        List<Music> music = catalogService.findAll();
        mv.addObject("musicas", music);
        return  mv;
    }

    @RequestMapping(value="/musicas/{id}", method=RequestMethod.GET)
    public ModelAndView getMusicasDetalhes(@PathVariable("id") long id) {
       ModelAndView mv = new ModelAndView("musicasDetalhes");
        Music music = catalogService.findById(id);
        mv.addObject("musica", music);
        return  mv;
    }

    @RequestMapping(value="/addMusica", method=RequestMethod.GET)
    public String getForm() {
        return "musicaForm";
    }

    @RequestMapping(value="/addMusica", method=RequestMethod.POST)
    public String salvarMusica(@Valid Music music, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Campos obrigatórios não preechidos!");
            return "redirect:/addMusica";
        }
        music.setData(LocalDate.now());
        catalogService.save(music);
        return "redirect:/musicas";
    }

    @RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
    public String getExcluirMusicas(@PathVariable("id") long id) {
        catalogService.delete(id);
        return "redirect:/musicas";
    }






}
