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
    private User liker_id;
    private User liked_user_id;
    private LocalDateTime likeDate;

    public Like(UUID id, User liker, User likedUser, LocalDateTime likeDate) {
        this.id = id;
        this.liker_id = liker;
        this.liked_user_id = likedUser;
        this.likeDate = likeDate;
    }
}

//Подбор(мэтчи), чат.