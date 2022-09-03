package pl.simo333.app.domain;

import javax.persistence.*;

@Table(name = "person_embed")
@Entity
public class PersonEmbed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    @Embedded
    private PersonDetailsEmbed personDetails;
}