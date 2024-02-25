package id.my.hendisantika.springbootthymeleafproducts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {

    @RequestMapping("")
    private String redirectIndex() {
        return "redirect:products/page";
    }
}
