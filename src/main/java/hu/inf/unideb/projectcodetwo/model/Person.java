package hu.inf.unideb.projectcodetwo.model;


import com.fasterxml.jackson.annotation.*;
import hu.inf.unideb.projectcodetwo.views.Views;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name="id")
    @JsonView(Views.Base.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @JsonView(Views.Base.class)
    @Column
    private String firstName;

    @JsonView(Views.Base.class)
    @Column
    private String lastName;

    @JsonView(Views.Base.class)
    @Column
    private Date birthDate;

    @JsonView(Views.Base.class)
    @Column
    private String adress;

    @javax.persistence.OrderBy("loandate DESC ")
    @OneToMany(cascade=CascadeType.ALL)
    @JsonView(Views.FromPerson.class)
    @JoinColumn(name="person_id")
    private Set<Loan> loans;

    public Person(Long id, String firstName, String lastName, Date birthDate, String adress, Set<Loan> loans) {
        this.personId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.adress = adress;
        this.loans = loans;
    }

    public Person(Long id) {
        this.personId = id;
    }

    public Person() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Long getId() {
        return personId;
    }

    public void setId(Long id) {
        this.personId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
