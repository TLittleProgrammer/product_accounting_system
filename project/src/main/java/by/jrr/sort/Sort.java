package by.jrr.sort;

import by.jrr.bean.Product;

import java.util.Comparator;

public class Sort {
    public static final Comparator<Product> sortByPrice = Comparator.comparing(Product::getPrice);
    public static final Comparator<Product> sortByDiscount = Comparator.comparing(Product::getDiscount);
    public static final Comparator<Product> sortByCategory = Comparator.comparing(Product::getCategory);
    public static final Comparator<Product> sortByName = Comparator.comparing(Product::getName);
}
