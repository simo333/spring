package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;
import pl.coderslab.model.dao.ProductDao;

@Controller
public class CartController {

    private final Cart cart;
    private final ProductDao productDao;

    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

    @RequestMapping("/addtocart/{id}/{quantity}")
    @ResponseBody
    public String addToCart(@PathVariable Long id, @PathVariable Integer quantity) {
        Product product = productDao.getProductById(id);
        cart.addToCart(new CartItem(quantity, product));
        return "addtocart";
    }

    @RequestMapping("/cart")
    @ResponseBody
    public String showCart() {
        return cart.getCartItems().toString();
    }


}
