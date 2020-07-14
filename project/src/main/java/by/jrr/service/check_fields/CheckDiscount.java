package by.jrr.service.check_fields;

import java.math.BigDecimal;

public class CheckDiscount {
    public static boolean checkDiscount(BigDecimal discount) {
        return discount.compareTo(BigDecimal.valueOf(0)) >= 0 &&
                discount.compareTo(BigDecimal.valueOf(100)) <= 0;
    }
}
