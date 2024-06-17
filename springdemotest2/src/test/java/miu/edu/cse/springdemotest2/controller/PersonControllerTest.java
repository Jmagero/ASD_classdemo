package miu.edu.cse.springdemotest2.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import miu.edu.cse.springdemotest2.model.Person;
import miu.edu.cse.springdemotest2.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    void getPersons() throws Exception {
        List<Person> persons = List.of(
                new Person(1L,"user1", "pass1"),
                new Person(2L,"user2", "pass1"),
                new Person(3L,"user2", "pass1"),
                new Person(4L,"user2", "pass1"),
                new Person(5L,"user2", "pass1")
        );
        Mockito.when(personService.getAllPersons()).thenReturn(Optional.of(persons));
//        mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        List<Person> personList = new Gson().fromJson(response, new TypeToken<List<Person>>() {});
        assertNotNull(response);
        System.out.println(personList);
    }

    @Test
    void getPersonById() {
    }

    @Test
    void createPerson() throws Exception {
        Person person = new Person("user1", "pass1");
        Mockito.when(personService.savePerson(Mockito.any(Person.class)))
                        .thenReturn(Optional.of(person));
        mockMvc.perform(
                MockMvcRequestBuilders.post("/persons")
                        .contentType("application/json")
                        .content(new Gson().toJson(person))
                )
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    void getPersonByUsername() throws Exception {
        Person person = new Person("user1", "pass1");
        Mockito.when(personService.getPersonByName("user1")).thenReturn(Optional.of(person));
        mockMvc.perform(
                MockMvcRequestBuilders.get("/persons/user1")
                        .contentType("application/json")
                        .content(new Gson().toJson(person)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    void updatePerson() throws Exception {
        Person person = new Person(1L,"user1", "pass1");
        Person newPerson = new Person(1L,"user1", "pass3");
        Mockito.when(personService.updatePerson(1L, newPerson))
                .thenReturn(Optional.of(person));
        mockMvc.perform(
                MockMvcRequestBuilders.patch("/persons/1")
                        .contentType("application/json")
                        .content(new Gson().toJson(newPerson)))
                        .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()
        );
    }
}