package NewsProject;

import NewsProject.services.PersonService;
import NewsProject.tables.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsProjectApplication implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(NewsProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        {
            Person admin = new Person("admin@mail.com", "admin", "1234");
            personService.saveAdminPerson(admin);
        }
    }
}


