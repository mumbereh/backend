package sam.backend.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persnonalinformation")
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="other_name")
    private String otherName;

    @Column(name="clan")
    private String clan;

    @Column(name="tribe")
    private String tribe;

    @Column(name="dateOfBirth")
    private String dateOfBirth;

    @Column(name="phoneNumber")
    private int phoneNumber;

    @Column(name="maritalStatus")
    private String maritalStatus;

    @Column(name="email")
    private String email;

    @Column(name="levelOfEducation")
    private String levelOfEducation;

    @Column(name="professional")
    private String professional;

    @Column(name="occupation")
    private String occupation;

    @Column(name="religion")
    private String religion;

    @Column(name="numberOfDependants")
    private int numberOfDependants;




}
