package com.naushad.SpringHibernateMysql.service;

import com.naushad.SpringHibernateMysql.model.Person;

import java.util.List;

/**
 * Created by Naushad on 4/28/2015.
 */
public interface PersonService {

    public void addPerson(Person person);
    public void updatePerson(Person person);
    public List<Person> listPerson();
    public Person getPersonById(int id);
    public void removePerson(int id);
}
