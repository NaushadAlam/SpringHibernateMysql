package com.naushad.SpringHibernateMysql.service;

import com.naushad.SpringHibernateMysql.dao.PersonDao;
import com.naushad.SpringHibernateMysql.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Naushad on 4/28/2015.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void addPerson(Person person) {
        try {
            personDao.addPerson(person);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public List<Person> listPerson() {

        return  personDao.listPerson();
    }

    @Override
    public Person getPersonById(int id) {

        return personDao.getPersonById(id);
    }

    @Override
    public void removePerson(int id) {
        personDao.removePerson(id);
    }
}
