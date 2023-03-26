package com.pieropan.networksocial.repository;

import com.pieropan.networksocial.domain.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestServiceRepository extends JpaRepository<Interest, Long> {
}