package NewsProject.repositories;

import NewsProject.tables.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String > {
}
