package com.kys.myjpa.cate;

import com.kys.myjpa.ECategory;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements ICategory {
    private Long id;
    private ECategory category;

    @Override
    public String toString(){
        return String.format("ID:%6d, 이름:%s, 분류:%s}",
                this.id, this.category);
    }
}