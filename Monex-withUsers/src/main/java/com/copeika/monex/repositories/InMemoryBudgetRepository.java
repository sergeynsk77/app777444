package com.copeika.monex.repositories;

import com.copeika.monex.exception.AlreadyExistException;
import com.copeika.monex.exception.NotFoundException;
import com.copeika.monex.models.Budget;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryBudgetRepository implements BudgetRepository {
    private Map<String, Budget> budgetCache = new HashMap<>();

    public InMemoryBudgetRepository(){
    }

    @Override
    public Budget fetchBudget(String UserId) {
        if (!budgetCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        return budgetCache.get(UserId);
    }

    @Override
    public Budget createBudget(String UserId, Integer cash) {
        if (budgetCache.containsKey(UserId)) {
            throw new AlreadyExistException();
        }
        Budget budget = new Budget();
        budget.setMoney(cash);
        budgetCache.put(UserId, budget);
        return budget;
    }

    @Override
    public Budget updateBudget(String UserId, Integer cash) {
        if (!budgetCache.containsKey(UserId)) {
            throw new NotFoundException();
        }

        Budget budget = budgetCache.get(UserId);
        budget.setMoney(cash);
        budgetCache.put(UserId, budget);
        return budget;
    }

    @Override
    public void deleteBudget(String UserId) {
        if (!budgetCache.containsKey(UserId)) {
            throw new NotFoundException();
        }
        budgetCache.remove(UserId);
    }

}
