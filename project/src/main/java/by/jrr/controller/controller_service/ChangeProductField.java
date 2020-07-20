package by.jrr.controller.controller_service;

import by.jrr.repository.ProductRepository;
import by.jrr.service.ProductService;
import by.jrr.service.check_fields.CheckDiscount;
import by.jrr.service.check_fields.CheckName;
import by.jrr.service.check_fields.CheckPrice;
import by.jrr.stat.Attributes;
import by.jrr.stat.HTTP;
import by.jrr.stat.Mistake;
import by.jrr.stat.Success;
import org.springframework.ui.Model;

import java.math.BigDecimal;

public class ChangeProductField {
    private static ProductService productService = new ProductService();
    private static String message;

    public static String changeProductField(Model model, ProductRepository productRepository, String field, String newValue, Long id) {
        if(checkField(productRepository, field, newValue, id)) {
            model.addAttribute(Attributes.MESSAGE, Success.FIELD_CHANGED);
            return HTTP.SUCCESS;
        } else {
            model.addAttribute(Attributes.MESSAGE, message);
            return HTTP.EXCEPTION;
        }
    }

    private static boolean checkField(ProductRepository productRepository, String field, String newValue, Long id) {
        switch (field) {
            case "name" :
                if(CheckName.checkName(newValue)) {
                    productService.changeName(id, newValue, productRepository);
                    return true;
                } else {
                    message = Mistake.MISTAKE_NAME;
                    return false;
                }
            case "price" :
                if(CheckPrice.checkPrice(BigDecimal.valueOf(Long.parseLong(newValue)))) {
                    productService.changePrice(id, newValue, productRepository);
                    return true;
                } else {
                    message = Mistake.MISTAKE_PRICE;
                    return false;
                }
            case "discount" :
                if(CheckDiscount.checkDiscount(BigDecimal.valueOf(Long.parseLong(newValue)))) {
                    productService.changeDiscount(id, newValue, productRepository);
                    return true;
                }
                else {
                    message = Mistake.MISTAKE_DISCOUNT;
                    return false;
                }
            case "description" :
                productService.changeDescription(id, newValue, productRepository);
                return true;
            case "category" :
                productService.changeCategory(id, newValue, productRepository);
                return true;
        }
        return false;
    }
}
