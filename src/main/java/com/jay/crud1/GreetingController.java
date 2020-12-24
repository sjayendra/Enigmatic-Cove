package com.jay.crud1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private PrabhvnaService prabhvnaService;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }


    @RequestMapping("/prabhavna")
    public String viewPrabhaPage(Model model, @Param("keyword") String keyword) {
        List<Prabhvna> listPrabhavna = prabhvnaService.listAll(keyword);
        model.addAttribute("listPrabhavna", listPrabhavna);
        model.addAttribute("keyword", keyword);

        return "prabhavna";
    }

    @RequestMapping("/prabhavna01")
    public String viewPrabha01Page(Model model, @Param("keyword") String keyword) {
        List<Prabhvna> listPrabhavna = prabhvnaService.listAll(keyword);
        model.addAttribute("listPrabhavna", listPrabhavna);
        model.addAttribute("keyword", keyword);

        return "prabhavna01";
    }

    @RequestMapping("/prabhavna01/edit/{ecn}")
    public ModelAndView showEditPrabhavnaForm(@PathVariable(name = "ecn") String ecn) {
        ModelAndView mav = new ModelAndView("edit_Prabhavna");

        //Product product = service1.get(id);
        Prabhvna prabhvna = prabhvnaService.get(ecn);
        mav.addObject("prabhvna", prabhvna);

        return mav;
    }

    @RequestMapping(value = "/savePrabhavna", method = RequestMethod.POST)
    public String savePrabhavna(@ModelAttribute("prabhvna") Prabhvna prabhvna) {

        //service1.save(product);
        prabhvnaService.save(prabhvna);

        return "redirect:/prabhavna01";
    }
}