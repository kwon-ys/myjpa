package com.kys.myjpa.icate;

import com.kys.myjpa.ECategory;

import java.util.List;

public interface ICategoryService<T> {
    T findById(Long id);
    List<T> getAllList();
    ICategory insert(ECategory category) throws Exception;
    ICategory insert(T category) throws Exception;
    boolean remove(Long id) throws Exception;
    ICategory update(Long id, T category) throws Exception;
    List<T> getListFromCategory(ECategory category);
}
