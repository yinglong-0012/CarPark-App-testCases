package cme;

import java.math.BigDecimal;

public class ApplyStaffReduction {
    public static BigDecimal calculate(BigDecimal totalCost) {
        BigDecimal maxPayable = BigDecimal.valueOf(10.0);
        return totalCost.compareTo(maxPayable) > 0 ? maxPayable :totalCost;

    }
}
