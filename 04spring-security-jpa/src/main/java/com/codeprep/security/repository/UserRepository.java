package com.codeprep.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeprep.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User getByUsername(String username);
}
