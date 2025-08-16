package br.com.bthirtyeight.services;

import br.com.bthirtyeight.exception.ResourceNotFoundException;
import br.com.bthirtyeight.model.Person;
import br.com.bthirtyeight.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service//para deixar a instancia da classe service a disposicao
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired//para injetar o repository
    private PersonRepository repository;

    public  List<Person> findAll() {
        logger.info("find all people");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");

        return repository.findById(id)
                //retorna uma exception caso nao ache no database
                .orElseThrow(() -> new ResourceNotFoundException(""));
    }

    public Person create(Person person) {
        logger.info("Creating one Person");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating One Person!");

        Person entity = repository.findById(person.getId())
                            .orElseThrow(() -> new ResourceNotFoundException(""));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());


        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(""));

        repository.delete(entity);
    }

}
