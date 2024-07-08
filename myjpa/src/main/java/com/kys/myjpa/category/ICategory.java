package com.kys.myjpa.category;

import com.kys.myjpa.phonebook.IPhoneBook;

public interface ICategory {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    default void copyFields(ICategory from) {
        if (from == null) {
            return;
        }
        if (from.getId() != null) {
            this.setId(from.getId());
        }
        if (from.getName() != null && !from.getName().isEmpty()) {
            this.setName(from.getName());
        }
    }
}
