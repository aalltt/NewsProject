package NewsProject.controllers;

import NewsProject.services.PersonService;
import NewsProject.tables.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;



@Controller
public class RegistrationController {

    @Autowired
    private PersonService personService;

    @GetMapping("/registration")
    public String Register (Model model){
        model.addAttribute("person", new Person());
        return "registration-page";
    }

    @PostMapping("/registration")
    public String getRegister (@Valid Person person, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "registration-page";
        }
        if(personService.isPersonPresent(person.getEmail())) {
            model.addAttribute("check",true);
            return "registration-page";
        }
        personService.savePerson(person);
        return "confirm";
    }



}
