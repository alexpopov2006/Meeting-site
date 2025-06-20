package com.meetingsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    private UUID id;

    private String country;
    private String region;
    private String city;

    public Address(String country, String region, String city) {
        this.country = country;
        this.region = region;
        this.city = city;
    }
}