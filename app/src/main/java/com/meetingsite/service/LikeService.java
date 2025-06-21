package com.meetingsite.service;

import com.meetingsite.entity.Like;
import com.meetingsite.dto.request.LikeRequest; // Предположим, у вас есть DTO для лайка
import com.meetingsite.dto.response.LikeResponse; // Предположим, у вас есть DTO для ответа

import java.util.List;

public interface LikeService {

    LikeResponse addLike(LikeRequest likeRequest);

    void removeLike(Long likeId);

    List<LikeResponse> getLikesReceivedByUser(Long userId);

    List<LikeResponse> getLikesGivenByUser(Long userId);

    boolean hasUserLiked(Long likerId, Long likedId);
}
