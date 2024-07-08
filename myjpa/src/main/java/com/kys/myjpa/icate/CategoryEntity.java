package com.kys.myjpa.icate;

import com.kys.myjpa.ECategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category_tbl")
public class CategoryEntity implements ICategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private ECategory category;

    @Override
    public String toString(){
        return String.format("ID:%6d, 분류:%s}",
                this.id, this.category);
    }
}
