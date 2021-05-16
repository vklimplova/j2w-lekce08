package cz.czechitas.java2webapps.lekce8.controller;

import cz.czechitas.java2webapps.lekce8.entity.Osoba;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OsobaController {

  private final List<Osoba> seznamOsob = List.of(
          new Osoba(1L, "Božena", "Němcová", LocalDate.of(1820, 2, 4), "Vídeň", null, null)
  );

  @GetMapping("/")
  public Object seznam() {
    //TODO načíst seznam osob
    return new ModelAndView("seznam")
            .addObject("osoby", seznamOsob);
  }

  @GetMapping("/novy")
  public Object novy() {
    return new ModelAndView("detail")
            .addObject("osoba", new Osoba());
  }

  @PostMapping("/novy")
  public Object pridat(@ModelAttribute("osoba") Osoba osoba, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "detail";
    }
    //TODO uložit údaj o nové osobě
    return "redirect:/";
  }

  @GetMapping("/{id}")
  public Object detail(@PathVariable long id) {
    //TODO načíst údaj o osobě
    return new ModelAndView("detail")
            .addObject("osoba", seznamOsob.get(0));
  }

  @PostMapping("/{id}")
  public Object ulozit(@ModelAttribute("osoba") Osoba osoba, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "formular";
    }
    //TODO uložit údaj o osobě
    return "redirect:/";
  }

  @PostMapping("/smazat/{id}")
  public Object smazat(long id) {
    //TODO smazat údaj o osobě
    return "redirect:/";
  }

}
