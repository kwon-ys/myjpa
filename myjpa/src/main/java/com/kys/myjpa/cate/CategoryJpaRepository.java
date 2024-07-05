package com.kys.myjpa.cate;

import com.kys.myjpa.ECategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAllByCategory(ECategory category);
}
