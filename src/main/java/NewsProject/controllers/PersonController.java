package NewsProject.controllers;

import NewsProject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public String showPersons (Model model){
        model.addAttribute("persons", personService.findAll());
        return "persons-list";
    }

//    @GetMapping("/persondel/delete/{email}")
//    public String deletePersonFromDB(@PathVariable("email") String email) {
//        personService.deletePerson(email);
//        return "redirect:/persons-list";
//    }
}
