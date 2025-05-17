package com.meetingsite.repository;

import com.meetingsite.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID>, PagingAndSortingRepository<User, UUID> {
    boolean existsByEmail(String email);
}
