package sam.backend.Entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="citizenship")
public class CitizenShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="clan")
    private String clan;

    @Column(name="tribe")
    private String tribe;

    @Column(name="citizenShipType")
    private String citizenshiptype;


    @Column(name="country")
    private String country;
}
