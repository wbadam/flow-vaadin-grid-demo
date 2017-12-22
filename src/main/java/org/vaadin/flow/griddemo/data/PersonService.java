package org.vaadin.flow.griddemo.data;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.vaadin.flow.griddemo.data.Person.Address;

import com.vaadin.flow.util.JsonUtils;

import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.impl.JsonUtil;

public class PersonService {

    private static PersonService instance;

    private final List<Person> people;

    private PersonService() {
        people = fetchAll();
    }

    public static PersonService getInstance() {
        if (instance == null) {
            instance = new PersonService();
        }
        return instance;
    }

    public List<Person> getAll() {
        return people;
    }

    private List<Person> fetchAll() {

        String dataJson = "";

        // Data originally from "https://demo.vaadin.com/demo-data/1.0/people"
        try {
            dataJson = FileUtils.readFileToString(new File(
                    getClass().getClassLoader().getResource("persons.json")
                            .getFile()), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject data = JsonUtil.parse(dataJson);
        JsonArray result = data.get("result");

        return JsonUtils.objectStream(result).map(p -> {
            Person person = new Person();

            person.setFirstName(p.getString("firstName"));
            person.setLastName(p.getString("lastName"));
            person.setEmail(p.getString("email"));

            Address address = new Address();
            person.setAddress(address);

            JsonObject a = p.getObject("address");
            address.setStreet(a.getString("street"));
            address.setCity(a.getString("city"));
            address.setState(a.getString("state"));
            address.setZip(a.getString("zip"));
            address.setCountry(a.getString("country"));
            address.setPhone(a.getString("phone"));

            return person;
        }).collect(Collectors.toList());
    }
}
