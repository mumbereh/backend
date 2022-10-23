package sam.backend.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Recommender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="NiN")
    private String nin;

    @Column(name="CardNo")
    private String cardNo;

    @Column(name="phoneNumber")
    private int phoneNumber;

    @Column(name="designation")
    private String designation;
}
