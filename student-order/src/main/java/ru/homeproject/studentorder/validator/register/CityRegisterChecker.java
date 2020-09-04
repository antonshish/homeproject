package ru.homeproject.studentorder.validator.register;

import ru.homeproject.studentorder.domain.register.CityRegisterResponse;
import ru.homeproject.studentorder.domain.Person;
import ru.homeproject.studentorder.exception.CityRegisterException;
import ru.homeproject.studentorder.exception.TransportException;

public interface CityRegisterChecker
{
    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException;
}
