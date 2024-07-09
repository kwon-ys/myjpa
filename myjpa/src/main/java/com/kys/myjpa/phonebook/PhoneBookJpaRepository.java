package com.kys.myjpa.phonebook;

import com.kys.myjpa.category.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookJpaRepository extends JpaRepository<PhoneBookEntity, Long> {
    List<PhoneBookEntity> findAllByNameContains(String name);
    List<PhoneBookEntity> findAllByCategory(CategoryEntity category);
    List<PhoneBookEntity> findAllByPhoneNumberContains(String findPhone);
    List<PhoneBookEntity> findAllByEmailContains(String findEmail);
}
