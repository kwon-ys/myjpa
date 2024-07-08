package com.kys.myjpa.icate;

import com.kys.myjpa.ECategory;
import com.kys.myjpa.IPhoneBook;

import java.io.Serializable;

public interface ICategory extends Serializable {
    Long getId();
    void setId(Long id);

    ECategory getCategory();
    void setCategory(ECategory category);

    default void copyFields(IPhoneBook from) {
        if (from == null) {
            return;
        }
        if (from.getId() != null) {
            this.setId(from.getId());
        }
        if (from.getCategory() != null) {
            this.setCategory(from.getCategory());
        }
    }
}
