package NewsProject.controllers;

import NewsProject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public String showPersons (Model model){
        model.addAttribute("persons", personService.findAll());
        return "persons-list";
    }
}
