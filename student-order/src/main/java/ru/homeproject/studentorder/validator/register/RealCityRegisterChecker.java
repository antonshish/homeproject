package ru.homeproject.studentorder.validator.register;

import ru.homeproject.studentorder.domain.register.CityRegisterRequest;
import ru.homeproject.studentorder.domain.register.CityRegisterResponse;
import ru.homeproject.studentorder.domain.Person;
import ru.homeproject.studentorder.exception.CityRegisterException;
import ru.homeproject.studentorder.exception.TransportException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RealCityRegisterChecker implements CityRegisterChecker
{
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        Client client = ClientBuilder.newClient();
        CityRegisterRequest request = new CityRegisterRequest(person);
        CityRegisterResponse response = client.target("http://localhost:8080/city-register-1.0/rest/check")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON))
        .readEntity(CityRegisterResponse.class);
        return response;
    }
}
