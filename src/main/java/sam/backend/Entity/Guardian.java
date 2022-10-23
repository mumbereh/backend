package sam.backend.Entity;

import lombok.Data;

import javax.persistence.*;


    @Data
    @Entity
    @Table(name = "Guardian")
    public class Guardian {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name="first_name")
        private String firstName;

        @Column(name="last_Name")
        private String lastName;

        @Column(name="other_name")
        private String otherName;
        @Column(name="clan")
        private String clan;

        @Column(name="tribe")
        private String tribe;

        @Column(name = "country")
        private String country;

        @Column(name = "district")
        private String district;

        @Column(name = "county")
        private String county;

        @Column(name = "sub_county")
        private String sub_county;

        @Column(name = "parish")
        private String parish;

        @Column(name = "village")
        private String village;

        @Column(name="phone_Number")
        private String phoneNumber;

        @Column(name = "street")
        private String street;

        @Column(name = "plotNo")
        private int plotNo;
}
