package com.copeika.monex.services;

import com.copeika.monex.models.Budget;
import com.copeika.monex.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget createBudget(String UserId, Integer money) {
        return budgetRepository.createBudget(UserId, money);
    }

    public void deleteBudget(String UserId) {
        budgetRepository.deleteBudget(UserId);
    }

    public Budget provideBudget(String UserId){
        return budgetRepository.fetchBudget(UserId);
    }

    public Budget updateBudget(String UserId, Integer money) {
        return budgetRepository.updateBudget(UserId, money);
    }
}
