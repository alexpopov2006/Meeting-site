package com.meetingsite.entity;

import com.meetingsite.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class Profile {
    @Id
    private UUID id;
    private User user;
    private Gender gender;
    private LocalDate birthDate;
    private String aboutMe;
    private Photo[] photos;


    public Profile(UUID id, User user, Gender gender, LocalDate birthDate, String aboutMe, Photo[] photos) {
        this.id = id;
        this.user = user;
        this.gender = gender;
        this.birthDate = birthDate;
        this.aboutMe = aboutMe;
        this.photos = (photos != null) ? photos : new Photo[0];
    }
}