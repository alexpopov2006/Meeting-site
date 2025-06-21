package com.meetingsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    private UUID id;

    @Column("city")
    private String city;

    @Column("region")
    private String region;

    @Column("country")
    private String country;

    public Address(String city, String region, String country) {
        this.city = city;
        this.region = region;
        this.country = country;
    }
}