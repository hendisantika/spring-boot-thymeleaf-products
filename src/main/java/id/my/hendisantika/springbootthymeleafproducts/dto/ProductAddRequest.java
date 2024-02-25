package id.my.hendisantika.springbootthymeleafproducts.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
@Data
public class ProductAddRequest {

    private Integer idProduct;

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @NotEmpty
    private String productPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productExpire;
}
