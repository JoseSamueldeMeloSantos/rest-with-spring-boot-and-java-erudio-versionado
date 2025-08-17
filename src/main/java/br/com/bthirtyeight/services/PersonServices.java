package br.com.bthirtyeight.services;

import br.com.bthirtyeight.data.dto.v1.PersonDTO;
import br.com.bthirtyeight.data.dto.v2.PersonDTOV2;
import br.com.bthirtyeight.exception.ResourceNotFoundException;
import br.com.bthirtyeight.mapper.custom.PersonMapper;
import br.com.bthirtyeight.model.Person;
import br.com.bthirtyeight.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

//import para metodos estaticos(nao precisa ficar declarando o metodo)
import static br.com.bthirtyeight.mapper.ObjectMapper.parseListObjects;
import static br.com.bthirtyeight.mapper.ObjectMapper.parseObeject;

@Service//para deixar a instancia da classe service a disposicao
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired//para injetar o repository
    private PersonRepository repository;

    @Autowired
    private PersonMapper converter;

    public  List<PersonDTO> findAll() {
        logger.info("find all people");

        return parseListObjects(repository.findAll(),PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                        //retorna uma exception caso nao ache no database
                        .orElseThrow(() -> new ResourceNotFoundException(""));

        return parseObeject(entity,PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one Person");

        var entity = parseObeject(person,Person.class);

        //ta salvando no banco usando o save apos isso converte novamente para DTO e retorna o DTO
        //     obs:o save retorna o obj que ele salvou
        return parseObeject(repository.save(entity),PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one Person V2!");

        var entity = converter.convertDTOToEntity(person);

        //ta salvando no banco usando o save apos isso converte novamente para DTO e retorna o DTO
        //     obs:o save retorna o obj que ele salvou
        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating One Person!");

        Person entity = repository.findById(person.getId())
                            .orElseThrow(() -> new ResourceNotFoundException(""));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        //ta salvando no banco usando o save apos isso converte novamente para DTO e retorna o DTO
        return parseObeject(repository.save(entity),PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(""));

        repository.delete(entity);
    }

}
