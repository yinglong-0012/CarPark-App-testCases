package cme;

import java.math.BigDecimal;

public class ApplyVisitorReduction {
    public static BigDecimal calculate(BigDecimal totalCost) {
        BigDecimal freeAmount = BigDecimal.TEN;
        BigDecimal reductionRate = BigDecimal.valueOf(0.5);
        if (totalCost.compareTo(freeAmount) <= 0) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal excessAmount = totalCost.subtract(freeAmount);
            return excessAmount.multiply(reductionRate);
        }
    }
}
