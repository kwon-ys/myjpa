package com.kys.myjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookJpaRepository extends JpaRepository<PhoneBookEntity, Long> {
}
