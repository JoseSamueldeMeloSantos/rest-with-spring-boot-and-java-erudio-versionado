package br.com.bthirtyeight.mapper.custom;

import br.com.bthirtyeight.data.dto.v2.PersonDTOV2;
import br.com.bthirtyeight.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service//para ser possivel injetar com @Autowired(mesmo nao sendo uma classe service)
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());//como a gente so ta simulando a o versionamento a entidade nao tem um BirthDay
        dto.setGender(person.getGender());
        dto.setAddress(person.getAddress());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 personDTOV2) {
        Person entity = new Person();
        entity.setId(personDTOV2.getId());
        entity.setFirstName(personDTOV2.getFirstName());
        entity.setLastName(personDTOV2.getLastName());
        //entity.setBirthDay(new Date());//como a gente so ta simulando a o versionamento a entidade nao tem um BirthDay
        entity.setGender(personDTOV2.getGender());
        entity.setAddress(personDTOV2.getAddress());

        return entity;
    }
}
