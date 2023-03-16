package com.pieropan.networksocial.repository;

import com.pieropan.networksocial.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String login);
}