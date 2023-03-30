package cme;

import java.math.BigDecimal;

public class ApplyManagementReduction {
    public static BigDecimal calculate(BigDecimal totalCost) {
        BigDecimal minPayable = BigDecimal.valueOf(5.0);
        return totalCost.max(minPayable);
    }
}
