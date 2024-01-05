package com.crud.repository;

import com.crud.entity.OnlineRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineRepository extends JpaRepository<OnlineRegistration,Long> {
}
