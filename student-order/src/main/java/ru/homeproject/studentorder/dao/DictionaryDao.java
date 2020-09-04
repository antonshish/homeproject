package ru.homeproject.studentorder.dao;

import ru.homeproject.studentorder.domain.CountryArea;
import ru.homeproject.studentorder.domain.PassportOffice;
import ru.homeproject.studentorder.domain.RegisterOffice;
import ru.homeproject.studentorder.domain.Street;
import ru.homeproject.studentorder.exception.DaoException;

import java.util.List;

public interface DictionaryDao
{
    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException;
    List<CountryArea> findAreas(String areaId) throws DaoException;
}
