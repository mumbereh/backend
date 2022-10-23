package sam.backend.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="enrolmentOfficer")
public class EnrolmentOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_Name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="NIN")
    private String nin;

    @Column(name="card_number")
    private String cardNo;

    @Column(name="PhoneNumber")
    private int phoneNumber;
}
