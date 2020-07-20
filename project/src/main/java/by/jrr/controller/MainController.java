package by.jrr.controller;

import by.jrr.bean.Product;
import by.jrr.controller.controller_service.*;
import by.jrr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({"/", "/main"})
    public String main(Model model) {
        return MainPage.mainPage(model, productRepository);
    }

    @GetMapping("/show_product/{id}")
    public String getProductById(Model model, @PathVariable String id) {
        return ShowProductPage.showProductPage(model, productRepository, id);
    }

    @PostMapping("/show_product")
    public String getProductByIdSecond(Model model, @RequestParam("id") String id) {
        return ShowProductPage.showProductPage(model, productRepository, id);
    }

    @PostMapping("/delete")
    public String deleteProduct(Model model, @RequestParam("id") Long id) {
        return DeleteProduct.deleteProduct(model, productRepository, id);
    }

    @PostMapping("/deleteAll")
    public String deleteAllProducts(Model model) {
        return DeleteAllProducts.deleteAllProducts(model, productRepository);
    }

    @PostMapping("/set_product")
    public String setNewProduct(Model model, @RequestParam("category") String category, Product product) {
        return SetNewProduct.setNewProduct(model, productRepository, category, product);
    }

    @PostMapping("/sort")
    public String sortAllProducts(Model model, @RequestParam("sortType") String sortType) {
        return SortAllProducts.sortAllProducts(model, productRepository, sortType);
    }

    @PostMapping("/change_product_field")
    public String changeProductField(Model model,
                                     @RequestParam("field") String field,
                                     @RequestParam("newValue") String newValue,
                                     @RequestParam("id") String id) {
        return ChangeProductField.changeProductField(model, productRepository, field, newValue, Long.valueOf(id));
    }

    @PostMapping("/find_product_by")
    public String findProductsBy(Model model, @RequestParam("category") String category) {
        return FindProductBy.findProductBy(model, productRepository, category);
    }
}
