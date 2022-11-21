package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/people")
public class PeopleController {

    // Автоматически заполняем значение поля
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return this.personRepository.findById(id);
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }

    // BEGIN
    @PostMapping(path = "")
    public void addPerson(@RequestBody Map<String, String> person) {
        Person newPerson = new Person(person.get("firstName"), person.get("lastName"));
        personRepository.save(newPerson);
    }
    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
    @PatchMapping(path = "/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Map<String, String> person) {
        Person updatePerson = personRepository.findById(id).get();
        updatePerson.setFirstName(person.get("firstName"));
        updatePerson.setLastName(person.get("lastName"));
        personRepository.save(updatePerson);
    }

    // END
}
