package ru.homeproject.city.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeproject.city.dao.PersonCheckDao;
import ru.homeproject.city.domain.PersonRequest;
import ru.homeproject.city.domain.PersonResponse;
import ru.homeproject.city.exception.PersonCheckException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/check")
@Singleton
public class CheckPersonService {
    public static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);

    PersonCheckDao dao;

    @PostConstruct
    public void init() {
        logger.info("START");
        dao = new PersonCheckDao();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) //Получение на вход JSON
    @Produces(MediaType.APPLICATION_JSON) //преобразовать return в JSON  (content-type header)
        public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        logger.info(request.toString());
        return dao.checkPerson(request);
    }
}

    /*//GET /city-register-1.0/rest/check/"simpleId"?name="simpleName"
    @GET
    @Path("/{id}") //параметр в строке URL
    public String checkPerson(@PathParam("id") int simpleId, @QueryParam("name") String simpleName) { //соотношение параметров (QueryParam через ?, PathParam через /)
        return simpleId + ": " + simpleName;
    }*/

