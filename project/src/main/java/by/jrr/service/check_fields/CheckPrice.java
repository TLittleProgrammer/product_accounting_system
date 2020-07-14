package by.jrr.service.check_fields;

import java.math.BigDecimal;

public class CheckPrice {
    public static boolean checkPrice(BigDecimal price) {
        return price.signum() > 0;
    }
}
