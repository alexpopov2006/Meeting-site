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
public class Block {
    @Id
    private UUID id;
    private User blocker;
    private User blockedUser;
    private LocalDateTime blockDate;
    public Block(UUID id, User blocker, User blockedUser, LocalDateTime blockDate) {
        this.id = id;
        this.blocker = blocker;
        this.blockedUser = blockedUser;
        this.blockDate = blockDate;
    }
}