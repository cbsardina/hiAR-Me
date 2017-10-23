package com.arproject.arproject.repository;

import com.arproject.arproject.model.GenericUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericUserRepository extends JpaRepository<GenericUser, Integer> {
}
