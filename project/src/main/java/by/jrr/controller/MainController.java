package by.jrr.controller;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import by.jrr.sort.Sort;
import by.jrr.stat.Mistake;
import by.jrr.stat.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;
    private Product productTransferredBetweenControllers;

    @GetMapping({"/", "/main"})
    public String main(Model model) {
        Iterable<Product> iterable = productRepository.findAll();
        model.addAttribute("products", iterable);
        model.addAttribute("categories", Category.values());
        model.addAttribute(new Product());
        return "main";
    }

    @PostMapping("/show_product")
    public String mainGetProductById(@ModelAttribute("id") Long id, Model model) {
        Optional<Product> iterable = productRepository.findById(id);
        ArrayList<Product> product = new ArrayList<>();
        iterable.ifPresent(product::add);
        productTransferredBetweenControllers = product.get(0);

        model.addAttribute("product", product.get(0));
        model.addAttribute("categories", Category.values());
        return "show_product";
    }

    @PostMapping("/delete")
    public String deleteProduct(Model model) {

        if(productTransferredBetweenControllers != null) {
            productRepository.delete(productTransferredBetweenControllers);
            productTransferredBetweenControllers = null;

            model.addAttribute("message", Success.PRODUCT_DELETE);
            return "success";
        }
        else {
            model.addAttribute("message", Mistake.MISTAKE_NO_SUCH_PRODUCT_EXISTS);
            return "exception";
        }
    }

    @PostMapping("/set_product")
    public String setNewProduct(Product product, @RequestParam("category") String category, Model model) {
        product.setCategory(category);
        productRepository.save(product);

        model.addAttribute("message", Success.PRODUCT_ADDED);
        return "success";
    }

    @PostMapping("/sort")
    public String sortAllProducts(@RequestParam("sortType") String sortType, Model model) {
        Iterable<Product> iterable = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();
        for (Product product: iterable) {
            products.add(product);
        }
        switch (sortType) {
            case "price" : products.sort(Sort.sortByPrice); break;
            case "discount" : products.sort(Sort.sortByDiscount); break;
            case "category" : products.sort(Sort.sortByCategory); break;
        }
        Collections.reverse(products);
        model.addAttribute("products", products);
        model.addAttribute("categories", Category.values());
        model.addAttribute(new Product());

        return "main";
    }

}
