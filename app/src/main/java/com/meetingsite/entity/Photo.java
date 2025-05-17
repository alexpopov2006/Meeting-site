package com.meetingsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class Photo {
    @Id
    private UUID id;
    private Profile profile;
    private String url;
    private Boolean isMain;

    public Photo(UUID id, Profile profile, String url, Boolean isMain) {
        this.id = id;
        this.profile = profile;
        this.url = url;
        this.isMain = (isMain != null) ? isMain : false;
    }
}