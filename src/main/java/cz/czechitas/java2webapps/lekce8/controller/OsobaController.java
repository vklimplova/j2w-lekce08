package cz.czechitas.java2webapps.lekce8.controller;

import cz.czechitas.java2webapps.lekce8.entity.Osoba;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
  public Object pridat(@ModelAttribute("osoba") @Valid Osoba osoba, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "detail";
    }
    //TODO uložit údaj o nové osobě
    return "redirect:/";
  }

  @GetMapping("/{id:[0-9]+}")
  public Object detail(@PathVariable long id) {
    //TODO načíst údaj o osobě
    return new ModelAndView("detail")
            .addObject("osoba", seznamOsob.get(0));
  }

  @PostMapping("/{id:[0-9]+}")
  public Object ulozit(@PathVariable long id, @ModelAttribute("osoba") @Valid Osoba osoba, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "detail";
    }
    //TODO uložit údaj o osobě
    return "redirect:/";
  }

  @PostMapping(value = "/{id:[0-9]+}", params = "akce=smazat")
  public Object smazat(@PathVariable long id) {
    //TODO smazat údaj o osobě
    return "redirect:/";
  }

}
