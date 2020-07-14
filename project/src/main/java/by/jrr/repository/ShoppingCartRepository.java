package by.jrr.repository;

import by.jrr.bean.Product;
import java.util.List;

public interface ShoppingCartRepository {
    void saveShoppingCart();
    void removeShoppingCart();
    void setProductInShoppingCart(Product product);
    Long getFullPriceOfProductsAtShoppingCart();
    List<Product> getShoppingCart();

}