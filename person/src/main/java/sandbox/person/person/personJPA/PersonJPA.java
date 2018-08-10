package sandbox.person.person.personJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQuery(name = "find_all_persons", query = "select p from PersonJPA p")
public class PersonJPA {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String location;
    private Date birthDate;
    private Date addDate;

    public PersonJPA() {
    }

    public PersonJPA(String name, String location, Date birthDate, Date addDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
        this.addDate = addDate;
    }

    public PersonJPA(int id, String name, String location, Date birthDate, Date addDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
        this.addDate = addDate;
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
        return "PersonJPA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                ", addDate=" + addDate +
                '}';
    }
}
