package ru.pharmacy.pharmacy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @GetMapping("/category")
    public Model loadCategory1(Model model){
        return model;
    }
    @GetMapping("/category/2")
    public String loadCategory2(Model model){

        return "";
    }
}
