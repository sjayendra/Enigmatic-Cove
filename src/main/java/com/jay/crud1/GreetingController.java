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
    private UserRepository userRepository;

    @Autowired
    private ProductService service1;

    @Autowired
    private UserService service;

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

    @GetMapping("/adduser")
    public String userForm(Model model) {
        model.addAttribute("adduser", new User());
        return "adduser";
    }

    @PostMapping("/adduser")
    public String adduserSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("User", user);
        userRepository.save(user);
        return "success";
    }

    @RequestMapping("/user01")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<User> listUsers = service.listAll(keyword);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("keyword", keyword);

        return "user01";
    }

    @RequestMapping("/product")
    public String viewHomePage1(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = service1.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);

        return "product";
    }

    @RequestMapping("/product/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service1.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/allProducts")
    public String viewHomePage4(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = service1.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);

        return "allProducts";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service1.save(product);

        return "redirect:/product";
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