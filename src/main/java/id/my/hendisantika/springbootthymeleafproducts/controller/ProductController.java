package id.my.hendisantika.springbootthymeleafproducts.controller;

import id.my.hendisantika.springbootthymeleafproducts.dto.ProductAddRequest;
import id.my.hendisantika.springbootthymeleafproducts.entity.Product;
import id.my.hendisantika.springbootthymeleafproducts.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/page")
    public ModelAndView showProducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @GetMapping("/page/type")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView showAddUpdateProduct(@RequestParam("form") String form,
                                             @RequestParam(value = "id", required = false) String id) {
        ModelAndView modelAndView = new ModelAndView();
        if (form.equals("addProduct")) {
            modelAndView.setViewName("add-product");
            return modelAndView;
        } else {
            Product currentProduct = productService.findById(Integer.parseInt(id));
            modelAndView.addObject("product", currentProduct);
            modelAndView.setViewName("edit-product");
            return modelAndView;
        }
    }

    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addOrUpdateProduct(@RequestBody @Valid ProductAddRequest request) {
        System.out.println(request);
        productService.addOrUpdateProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteProductById(@RequestBody String id) {
        productService.delete(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }
}
