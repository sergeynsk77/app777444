package com.copeika.monex.repositories;

import com .copeika.monex.models.Budget;

public interface BudgetRepository {
    Budget fetchBudget(String UserId);
    Budget createBudget(String UserId, Integer cash);
    Budget updateBudget(String UserId, Integer cash);
    void deleteBudget(String UserId);
}
