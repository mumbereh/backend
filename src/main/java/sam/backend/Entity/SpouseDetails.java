package sam.backend.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SpouseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="surname")
    private String surName;

    @Column(name="given_name")
    private String givenName;

    @Column(name="other_name")
    private String otherName;

    @Column(name="maiden_name")
    private String maidenName;

    @Column(name="place_of_marriage")
    private String placeOfMarriage;

    @Column(name="date_of_marriage")
    private String dateOfMarriage;

    @Column(name="type_of_marriage")
    private String typeOfMarriage;
}
