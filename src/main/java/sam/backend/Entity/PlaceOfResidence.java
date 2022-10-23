package sam.backend.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="placeOfResidence")
public class PlaceOfResidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="country")
    private String country;

    @Column(name="district")
    private String district;

    @Column(name="county")
    private String county;

    @Column(name="sub_county")
    private String sub_county;

    @Column(name="parish")
    private String parish;

    @Column(name="village")
    private String village;

    @Column(name="street")
    private String street;

    @Column(name="plotNo")
    private int plotNo;



}
