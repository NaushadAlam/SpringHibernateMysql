package com.naushad.SpringHibernateMysql.controller;

import com.naushad.SpringHibernateMysql.model.Person;
import com.naushad.SpringHibernateMysql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Naushad on 4/28/2015.
 */

@Controller
@RequestMapping("/")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/addPerson" , method = RequestMethod.GET)
    public void addPerson(HttpServletRequest request, HttpServletResponse response){
        Person person = new Person();
        logger.info("Person making process is starting********");
        person.setFirstName("Md. Naushad");
        person.setLastName("Alam");
        person.setEmail("naushad@yahoo.com");
        person.setAddress("Gulshan Badda");
        person.setCreationDate(new Date(System.currentTimeMillis()));
        person.setLastUpdateDate(new Date(System.currentTimeMillis()));
        personService.addPerson(person);
        logger.debug("Person added in Database***********");

    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String showForm(Person person ){
        logger.info("The registration form will show here :");
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkInformation(@Valid Person person, BindingResult bindingResult){
         if(bindingResult.hasErrors()){
             return "form";
         }
        person.setCreationDate(new Date(System.currentTimeMillis()));
        person.setLastUpdateDate(new Date(System.currentTimeMillis()));
        personService.addPerson(person);
        return "form";
    }

}
