package com.marcos.catalog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.marcos.catalog.model.Music;
import com.marcos.catalog.service.CatalogService;

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

    // *** List all ***
    @RequestMapping(value="/music", method=RequestMethod.GET)
    public ModelAndView getMusic() {
        ModelAndView mv = new ModelAndView("music");
        List<Music> music = catalogService.findAll();
        mv.addObject("music", music);
        return mv;
    }

    // *** Lista specific ***
    @RequestMapping(value="/music/{id}", method=RequestMethod.GET)
    public ModelAndView getMusicDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("musicDetails");
        Music music = catalogService.findById(id);
        mv.addObject("music", music);
        return mv;
    }

    // *** Add music ***
    @RequestMapping(value="/addMusic", method=RequestMethod.GET)
    public String getForm() {
        return "musicForm";
    }

    @RequestMapping(value="/addMusic", method=RequestMethod.POST)
    public String saveMusic(@Valid Music music, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Favor preencher os campos obrigatórios!");
            return "redirect:/addMusic";
        }
        music.setDate(LocalDate.now());
        catalogService.save(music);
        return "redirect:/music";
    }

    // *** Edit music ***
    @RequestMapping(value = "/editMusic/{id}", method = RequestMethod.GET)
    public ModelAndView getEditMusic(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("editMusic");
        Music music = catalogService.findById(id);
        mv.addObject("music", music);
        return mv;
    }

    @RequestMapping(value = "/editMusic/{id}", method = RequestMethod.POST)
    public String editMusic(@PathVariable("id") long id, @Valid Music music, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Favor preencher os campos obrigatórios!");
            return "redirect:/editMusic/" + id;
        }
        music.setId(id);
        music.setDate(LocalDate.now());
        catalogService.save(music);
        return "redirect:/music";
    }

    // *** Delete music ***
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String getDeleteMusic(@PathVariable("id") long id) {
        catalogService.delete(id);
        return "redirect:/music";
    }






}
