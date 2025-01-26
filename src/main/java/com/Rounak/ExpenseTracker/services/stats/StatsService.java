package com.Rounak.ExpenseTracker.services.stats;

import com.Rounak.ExpenseTracker.dto.GraphDTO;
import com.Rounak.ExpenseTracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getChartData();
    public StatsDTO getStats();
}
