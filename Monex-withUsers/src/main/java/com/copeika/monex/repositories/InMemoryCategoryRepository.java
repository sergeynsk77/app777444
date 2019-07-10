package com.copeika.monex.repositories;


import com.copeika.monex.exception.AlreadyExistException;
import com.copeika.monex.exception.NotFoundException;
import com.copeika.monex.models.Category;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository {

    private Map<String, Map<String, Category>> categoryCache = new HashMap<>();

    public InMemoryCategoryRepository(){

    }

    @Override
    public Category addCategory(String UserId, String name) {
        if (!categoryCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        if (categoryMap.containsKey(name)) {
            throw new AlreadyExistException();
        }
        Category category = categoryMap.get(name);
        category.setName(name);
        category.setMonetaryExpenditures(0);
        categoryMap.put(name, category);
        categoryCache.put(UserId, categoryMap);
        return category;
    }

    @Override
    public void deleteCategory(String UserId, String name) {
        if (!categoryCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        if (!categoryMap.containsKey(name)) {
            throw new NotFoundException();
        }
        categoryMap.remove(name);
        categoryCache.put(UserId, categoryMap);
    }

    @Override
    public Category renameCategory(String UserId, String name, String after_name) {
        if (!categoryCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        if (!categoryMap.containsKey(name)) {
            throw new NotFoundException();
        }
        Category category = categoryMap.get(name);
        category.setName(after_name);
        categoryMap.remove(name);
        categoryMap.put(after_name, category);
        categoryCache.put(UserId, categoryMap);
        return category;
    }

    @Override
    public Category fetchCategory(String UserId, String name) {
        if (!categoryCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        if (!categoryMap.containsKey(name)) {
            throw new NotFoundException();
        }
        return categoryMap.get(name);
    }

    @Override
    public Category setLimit(String UserId, String name, Integer limit) {
        if (!categoryCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        if (!categoryMap.containsKey(name)) {
            throw new NotFoundException();
        }
        Category category = categoryMap.get(name);
        category.setLimit(limit);
        categoryMap.put(name, category);
        categoryCache.put(UserId, categoryMap);
        return  category;
    }

    @Override
    public Category addMonetaryExpenditures(String UserId, String name, Integer money_expenditures) {
        if (!categoryCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        if (!categoryMap.containsKey(name)) {
            throw new NotFoundException();
        }
        Category category = categoryMap.get(name);
        category.addMonetaryExpenditures(money_expenditures);
        categoryMap.put(name, category);
        categoryCache.put(UserId, categoryMap);
        return category;
    }

    @Override
    public Category refreshMonetaryExpenditures(String UserId, String name) {
        if (!categoryCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        if (!categoryMap.containsKey(name)) {
            throw new NotFoundException();
        }
        Category category = categoryMap.get(name);
        Integer temp = 0;
        category.setMonetaryExpenditures(temp);
        categoryMap.put(name, category);
        categoryCache.put(UserId, categoryMap);
        return category;
    }

    @Override
    public Collection<Category> getAllBooks(String UserId) {
        Map<String, Category> categoryMap = categoryCache.get(UserId);
        return categoryMap.values();
    }

}
