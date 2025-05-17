package com.meetingsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class Like {
    @Id
    private UUID id;
    private User liker;
    private User likedUser;
    private LocalDateTime likeDate;

    public Like(UUID id, User liker, User likedUser, LocalDateTime likeDate) {
        this.id = id;
        this.liker = liker;
        this.likedUser = likedUser;
        this.likeDate = likeDate;
    }
}