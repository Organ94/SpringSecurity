package com.example.springsecurity.controller;

import com.example.springsecurity.model.Person;
import com.example.springsecurity.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping("/by-city")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    public List<Person> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
