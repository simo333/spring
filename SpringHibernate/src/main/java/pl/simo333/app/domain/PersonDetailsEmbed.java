package pl.simo333.app.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PersonDetailsEmbed {

    private String firstName;
    private String lastName;
    private Integer streetNumber;
    private String street;
    private String city;
}