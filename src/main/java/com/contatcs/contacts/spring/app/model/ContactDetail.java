package com.contatcs.contacts.spring.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetail {

    private enum ContactType {
        LANDLINE,
        MOBILE,
        EMAIL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @JsonProperty(value = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    @JsonProperty(value = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    @JsonProperty( value = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty( value = "contact_type")
    private ContactType contactType;

    @Column(name = "contact_detail")
    @JsonProperty( value = "contact_detail")
    private String contactDetail;

}
