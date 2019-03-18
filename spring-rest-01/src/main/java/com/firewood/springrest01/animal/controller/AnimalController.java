package com.firewood.springrest01.animal.controller;

import com.firewood.springrest01.animal.domain.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimalController {

    @GetMapping("/view/animal")
    public String getXmlAnimal(Model model) {
        System.out.println("dd");
        model.addAttribute("animal", new Animal("cat"));
        return "viewAnimal";
    }

    @GetMapping("/response/animal")
    @ResponseBody
    public Animal getBodyAnimal() {
        return new Animal("dog");
    }
}
