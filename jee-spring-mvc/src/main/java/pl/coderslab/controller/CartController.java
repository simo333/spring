package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.task2_3.Cart;
import pl.coderslab.model.task2_3.CartItem;
import pl.coderslab.model.task2_3.Product;
import pl.coderslab.model.task2_3.dao.ProductDao;

import java.util.List;

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
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = cartItems.stream()
                .filter(c -> c.getProduct().equals(product)).findFirst()
                .orElse(new CartItem(0, product));

        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        if (!cartItems.contains(cartItem)) {
            cart.addToCart(cartItem);
        }
        return "addtocart";
    }

    @RequestMapping("/cart")
    @ResponseBody
    public String showCart() {
        List<CartItem> cartItems = cart.getCartItems();
        int itemsQuantity = cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
        Double totalCost = cartItems.stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();

        return new StringBuilder().append("W koszyku jest ").append(cartItems.size()).append(" pozycji.\n")
                .append("W koszyku jest ").append(itemsQuantity).append(" produktów.\n")
                .append("Wartość koszyka to: ").append(totalCost).toString();
    }


}
