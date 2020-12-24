package com.jay.crud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;
import org.springframework.data.repository.query.Param;
import java.util.List;

@SpringBootApplication
public class Crud1Application {

	public static void main(String[] args) {
		SpringApplication.run(Crud1Application.class, args);
	}


	@RequestMapping("/")
	public String index() {
		return "Greetings from Heroku !";
	}


	@RequestMapping("/jay")
	public String jay()
	{
		return "test";
	}


	//public String showAll(Model model) {
		//model.addAttribute("User", service.findAll());
	//	model.addAttribute("User",service.listAll1());

		//return "users";
	//}

}