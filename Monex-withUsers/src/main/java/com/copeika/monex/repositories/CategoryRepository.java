package com.copeika.monex.repositories;

import com.copeika.monex.models.Category;

import java.util.Collection;

public interface CategoryRepository {
    Category addCategory(String UserId, String name);
    void deleteCategory(String UserId, String name);
    Category renameCategory(String UserId, String name, String after_name);
    Category fetchCategory(String UserId, String name);
    Category setLimit(String UserId, String name, Integer limit);
    Category addMonetaryExpenditures(String UserId, String name, Integer money_expenditures);
    Category refreshMonetaryExpenditures(String UserId, String name);
    Collection<Category> getAllBooks(String UserId);
}
