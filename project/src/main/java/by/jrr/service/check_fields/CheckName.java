package by.jrr.service.check_fields;

public class CheckName {
    public static boolean checkDiscount(String name) {
        return name.length() >= 3 && name.length() <= 32;
    }
}
