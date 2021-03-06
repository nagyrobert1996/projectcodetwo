package hu.inf.unideb.projectcodetwo.service;

import hu.inf.unideb.projectcodetwo.dto.BookList;
import hu.inf.unideb.projectcodetwo.dto.PersonDTO;
import hu.inf.unideb.projectcodetwo.dto.PersonList;
import hu.inf.unideb.projectcodetwo.dto.ResponseDTO;
import hu.inf.unideb.projectcodetwo.model.Person;
import hu.inf.unideb.projectcodetwo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonList getPersons(String page) {
        PersonList personList = new PersonList();
        int i = Integer.parseInt(page);
        personList.setData(personRepository.findAll(PageRequest.of(i, 10)).getContent());
        return personList;
    }

    public ResponseDTO addPerson(Person resource) {
        Long id = personRepository.save(resource).getId();
        return new ResponseDTO(id, "Tag sikeresen hozzáadva.");
    }

    public ResponseDTO updatePerson(Long id, Person resource) {
        if( personRepository.existsById(id) ){
            resource.setId(id);
            personRepository.save(resource);
            return new ResponseDTO(id, "Tag sikeresen frissítve.");
        }
        else {
            return new ResponseDTO(id, "Nincs tag ilyen azonosítóval!");
        }
    }

    public ResponseDTO deletePerson(Long id) {
        if( personRepository.existsById(id) ){
            personRepository.deleteById(id);
            return new ResponseDTO(id,"A tag sikeresen törölve.");
        }
        else {
            return new ResponseDTO(id, "Nincs tag ilyen azonosítóval!");
        }
    }

    public long count() {
        return personRepository.count();
    }
}