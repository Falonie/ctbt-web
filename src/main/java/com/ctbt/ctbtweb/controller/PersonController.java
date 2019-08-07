package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.domain.Person;
import com.ctbt.ctbtweb.forms.PersonForm;
import com.ctbt.ctbtweb.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Resource
    private PersonService personService;

    @GetMapping("/list")
    public ServerResponse personList() {
        List<Person> personList = personService.findAll();
        return ServerResponse.success(personList);
    }

    @PostMapping("/addPerson")
    public ServerResponse addPerson(@Valid PersonForm personForm, BindingResult bindingResult) {
        Person person = new Person();
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(personForm, person);
        Person result = personService.save(person);
        return ServerResponse.success(result);
    }

    @PutMapping("/updatePerson")
    public ServerResponse editPerson(@RequestParam("id") int id, @Valid PersonForm personForm, BindingResult bindingResult) {
        Person person = personService.findOneById(id);
        if (person == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(personForm, person);
        Person result = personService.save(person);
        return ServerResponse.success(result);
    }

    @DeleteMapping("/deletePerson")
    public ServerResponse deletePerson(@RequestParam("id") int id) {
        Person person = personService.findOneById(id);
        if (person == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        personService.delete(person);
        return ServerResponse.successByMsg("删除成功");
    }
}
