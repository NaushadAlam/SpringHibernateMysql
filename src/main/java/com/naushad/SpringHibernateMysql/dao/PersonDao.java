package com.naushad.SpringHibernateMysql.dao;

import com.naushad.SpringHibernateMysql.model.Person;

import java.util.List;

/**
 * Created by Naushad on 4/28/2015.
 */
public interface PersonDao {

    public void addPerson(Person person);
    public void updatePerson(Person person);
    public List<Person> listPerson();
    public Person getPersonById(int id);
    public void removePerson(int id);
}
