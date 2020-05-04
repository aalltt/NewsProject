package NewsProject.services;

import NewsProject.repositories.PersonRepository;
import NewsProject.tables.Person;
import NewsProject.tables.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void savePerson (Person person){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        person.setPassword(encoder.encode(person.getPassword()));
        Role role = new Role("USER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        person.setRoles(roleList);
        personRepository.save(person);
    }


    public void saveAdminPerson (Person person){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        person.setPassword(encoder.encode(person.getPassword()));
        Role role = new Role("ADMIN");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        person.setRoles(roleList);
        personRepository.save(person);
    }

    public Person findPerson(String email){
        return personRepository.findById(email).orElseThrow(null);
    }


}
