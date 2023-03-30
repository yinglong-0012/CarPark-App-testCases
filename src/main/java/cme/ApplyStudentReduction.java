package cme;

import java.math.BigDecimal;

public class ApplyStudentReduction {
    public static BigDecimal calculate(BigDecimal totalCost) {
        BigDecimal reduceDomain = BigDecimal.valueOf(5.5);
          BigDecimal reductionRate = BigDecimal.valueOf(0.33);
        if (totalCost.compareTo(reduceDomain) <= 0) {
            return totalCost;
        } else {

            BigDecimal excessAmount = totalCost.subtract(reduceDomain);
            BigDecimal reducedExcessAmount = excessAmount.multiply(BigDecimal.ONE.subtract(reductionRate));
            return reduceDomain.add(reducedExcessAmount);


        }
    }
}
