package pl.simo333.task4.task2_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.simo333.task4.task2_3.dao.ProductDao;

import javax.servlet.http.HttpServletRequest;
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
    public String addToCart(@PathVariable Long id, @PathVariable Integer quantity, HttpServletRequest request) {
        Product product = productDao.getProductById(id);
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = cartItems.stream()
                .filter(c -> c.getProduct().equals(product)).findFirst()
                .orElse(new CartItem(0, product));

        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        if (!cartItems.contains(cartItem)) {
            cart.addToCart(cartItem);
            request.setAttribute("newCartItem", cartItem);
        }
        return "task4/addedToCart";
    }

    @RequestMapping("/cart")
    public String showCart(HttpServletRequest request) {
        List<CartItem> cartItems = cart.getCartItems();
        int itemsQuantity = cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
        Double totalValue = cartItems.stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();

        request.setAttribute("cartItemsQuantity", cartItems.size());
        request.setAttribute("cartProductQuantity", itemsQuantity);
        request.setAttribute("cartValue", totalValue);
        return "task4/cart";
    }
}
