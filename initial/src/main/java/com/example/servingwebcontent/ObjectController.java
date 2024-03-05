package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ObjectController {

     @RequestMapping("/hello")
     private String hello() {
      return "hello";
     }

    @RequestMapping("/todo/{id}")
    private ModelAndView getTodot(@PathVariable Integer id, Model model) {
        String uri = "https://jsonplaceholder.typicode.com/todos/" + id;
        RestTemplate restTemplate = new RestTemplate();

        Todos todo = restTemplate.getForObject(uri, Todos.class);
        System.out.println("todo: " + todo);

        ModelAndView modelAndView = new ModelAndView("todo");
        modelAndView.addObject("todo", todo);

        return modelAndView;
    }
}