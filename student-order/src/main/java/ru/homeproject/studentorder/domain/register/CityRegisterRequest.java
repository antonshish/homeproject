package ru.homeproject.studentorder.domain.register;

import ru.homeproject.studentorder.domain.Address;
import ru.homeproject.studentorder.domain.Person;
import ru.homeproject.studentorder.util.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class CityRegisterRequest {
    private Long streetCode;
    private String surName;
    private String givenName;
    private String patronymic;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class) //конкретнок преобразование LocalDate в String (для JSON)
    private LocalDate dateOfBirth;
    private String building;
    private String extension;
    private String apartment;

    public CityRegisterRequest() {

    }

    public CityRegisterRequest(Person person) {
        surName = person.getSurName();
        givenName = person.getGivenName();
        patronymic = person.getPatronymic();
        dateOfBirth = person.getDateOfBirth();
        Address address = person.getAddress();
        building = address.getBuilding();
        streetCode = address.getStreet().getStreetCode();
        extension = address.getExtension();
        apartment = address.getApartment();
    }

    public Long getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Long streetCode) {
        this.streetCode = streetCode;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "CityRegisterRequest{" +
                "streetCode=" + streetCode +
                ", surName='" + surName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", building='" + building + '\'' +
                ", extension='" + extension + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
