package com.meetingsite.dto.response;

import java.util.UUID;

public class LikeResponse {

    private UUID id;
    private UUID likerId;
    private UUID likedId;

    public LikeResponse() {
    }

    public LikeResponse(UUID id, UUID likerId, UUID likedId) {
        this.id = id;
        this.likerId = likerId;
        this.likedId = likedId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getLikerId() {
        return likerId;
    }

    public void setLikerId(UUID likerId) {
        this.likerId = likerId;
    }

    public UUID getLikedId() {
        return likedId;
    }

    public void setLikedId(UUID likedId) {
        this.likedId = likedId;
    }
}