package com.naushad.SpringHibernateMysql.dao;

import com.naushad.SpringHibernateMysql.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Naushad on 4/28/2015.
 */
@Transactional
@Repository
public class PersonDaoImpl implements PersonDao {

    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        logger.info("Person save successfully, Person Details : " + person);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person updated successfully, Person Details : " + person);
    }

    @Override
    public List<Person> listPerson() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from Person").list();
        for(Person person : personList){
            logger.info("Person List :: " + person);
        }
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person Loadded Successfully :: " + person);

        return person;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        if(person != null){
            session.delete(person);
        }
        logger.info("Person deleted successfully, person details="+person);
    }
}
