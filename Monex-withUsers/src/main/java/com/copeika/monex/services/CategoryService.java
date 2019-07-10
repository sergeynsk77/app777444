package com.copeika.monex.services;


import com.copeika.monex.models.Category;
import com.copeika.monex.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

     public Category addCategory(String UserId, String name) {
         return categoryRepository.addCategory(UserId, name);
     }

     public Category renameCategory(String UserId, String name, String after_name){
        return categoryRepository.renameCategory(UserId, name, after_name);
     }

     public Category fetchCategory(String UserId, String name){
        return categoryRepository.fetchCategory(UserId, name);
     }

     public Category setLimit(String UserId, String name, Integer limit) {
         return categoryRepository.setLimit(UserId ,name, limit);
     }

     public Category addMonetaryExpenditures(String UserId, String name, Integer money_expenditures) {
         return categoryRepository.addMonetaryExpenditures(UserId ,name, money_expenditures);
     }

     public void deleteCategory(String UserId, String name){
        categoryRepository.deleteCategory(UserId, name);
     }

     public Category refreshMonetaryExpenditures(String UserId, String name) {
         return categoryRepository.refreshMonetaryExpenditures(UserId, name);
     }

     public Collection<Category> getAllCategories(String UserId ){
        return categoryRepository.getAllBooks(UserId);
     }
}
