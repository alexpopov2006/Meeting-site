package com.meetingsite.repository;

import com.meetingsite.entity.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikeRepository extends CrudRepository<Like, UUID> {

}