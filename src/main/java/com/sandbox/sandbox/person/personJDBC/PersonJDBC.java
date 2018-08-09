package com.sandbox.sandbox.person.personJDBC;

import java.util.Date;


public class PersonJDBC {

    private int id;
    private String name;
    private String location;
    private Date birthDate;
    private Date addDate;

    public PersonJDBC() {
    }

    public PersonJDBC(int id, String name, String location, Date birthDate, Date addDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
        this.addDate = addDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "PersonJDBC{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                ", addDate=" + addDate +
                '}';
    }
}
