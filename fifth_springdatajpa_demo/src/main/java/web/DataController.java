package web;

import dao.PersonRepository;
import domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){

        Person p = personRepository.save(new Person(null,name,age,address));

        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address){
        List<Person> people = personRepository.findByAddress(address);

        return people;
    }

    @RequestMapping("/q2")
    public Person q2(String name,String address){

        Person people = personRepository.findByNameAndAddress(name,address);

        return people;
    }

    @RequestMapping("/q3")
    public Person q3(String name,String address){

        Person p = personRepository.withNameAndAddressNamedQuery(name,address);

        return p;
    }

    @RequestMapping("/q4")
    public Person q4(String name,String address){

        Person p = personRepository.withNameAndAddressNamedQuery(name,address);

        return p;
    }

    @RequestMapping("/sort")
    public List<Person> sort(String name,String address){

        List<Person> p = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));

        return p;
    }

    @RequestMapping("/page")
    public Page<Person> page(String name, String address){

        Page<Person> p = personRepository.findAll(new PageRequest(1,2));

        return p;
    }
}
