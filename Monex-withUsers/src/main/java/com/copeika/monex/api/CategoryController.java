package com.copeika.monex.api;

import com.copeika.monex.models.Category;
import com.copeika.monex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CategoryController {
    private static final String CATEGORY_PATH = "/api/v001/categories";

    @Autowired
    private CategoryService service;

    @PostMapping(value = CATEGORY_PATH)
    public ResponseEntity<?> addCategory(
            @RequestHeader String UserId,
            @RequestParam String name
    ) {
        Category result = service.addCategory(UserId, name);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(CATEGORY_PATH + "/{name}")
    public ResponseEntity<?> deleteCategory(
            @RequestHeader String UserId,
            @PathVariable String name) {
        service.deleteCategory(UserId, name);
        return ResponseEntity.ok().build();
    }

    @GetMapping(CATEGORY_PATH + "/{name}")
    public ResponseEntity<Category> fetchCategory(
            @RequestHeader String UserId,
            @PathVariable String name) {
        Category result = service.fetchCategory(UserId, name);
        return ResponseEntity.ok(result);
    }

    @GetMapping(CATEGORY_PATH )
    public ResponseEntity<Collection<Category>> getAllCategories(
            @RequestHeader String UserId
    ) {
        Collection<Category> categories = service.getAllCategories(UserId);
        return ResponseEntity.ok(categories);
    }

    @PatchMapping(value = CATEGORY_PATH + "/{name}", params = "after_name")
    public ResponseEntity<Category> renameCategory(
            @RequestHeader String UserId,
            @PathVariable String name,
            @RequestParam String after_name
            ) {
        Category result = service.renameCategory(UserId, name, after_name);
        return ResponseEntity.ok(result);
    }

    @PatchMapping(value = CATEGORY_PATH + "/{name}", params = "limit")
    public ResponseEntity<Category> setLimit(
            @RequestHeader String UserId,
            @PathVariable String name,
            @RequestParam Integer limit
    ) {
        Category result = service.setLimit(UserId, name, limit);
        return ResponseEntity.ok(result);
    }

   @PatchMapping(value = CATEGORY_PATH + "/{name}")
    public ResponseEntity<Category> addMonetaryExpenditures(
           @RequestHeader String UserId,
            @PathVariable String name,
            @RequestBody Integer money
    ) {
        Category result = service.addMonetaryExpenditures(UserId, name, money);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = CATEGORY_PATH + "/{name}", params = "refresh_money")
    public ResponseEntity<Category> refreshMonetaryExpenditures(
            @RequestHeader String UserId,
            @PathVariable String name
    ) {
        Category result = service.refreshMonetaryExpenditures(UserId, name);
        return ResponseEntity.ok(result);
    }
}
