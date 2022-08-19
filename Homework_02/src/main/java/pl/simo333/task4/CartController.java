package pl.simo333.task4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.simo333.task4.dao.ProductDao;

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

        request.setAttribute("cart", cart.getCartItems());
        request.setAttribute("cartItemsQuantity", cartItems.size());
        request.setAttribute("cartProductQuantity", itemsQuantity);
        request.setAttribute("cartValue", totalValue);
        return "task4/cart";
    }

    @GetMapping("/add-product")
    public String addProduct() {
        return "task4/addProduct";
    }

    @PostMapping("/add-product")
    public String addProduct(@RequestParam String name, @RequestParam Double price) {

        Product product = new Product(name, price);
        System.out.println(product);
        productDao.addProduct(product);
        return "task4/addProduct";
    }

    @GetMapping("/cart-items/{id}/increase-quantity")
    public String increaseQuantity(@PathVariable Long id) {
        cart.getCartItems().stream()
                .filter(cartItem -> id.equals(cartItem.getProduct().getId()))
                .forEach(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + 1));
        return "redirect:/cart";
    }

    @GetMapping("/cart-items/{id}/decrease-quantity")
    public String deceaseQuantity(@PathVariable Long id) {
        cart.getCartItems().stream()
                .filter(cartItem -> id.equals(cartItem.getProduct().getId()))
                .forEach(cartItem -> cartItem.setQuantity(cartItem.getQuantity() - 1));
        return "redirect:/cart";
    }

    @GetMapping("cart-items/{id}")
    public String deleteCartItem(@PathVariable Long id) {
        cart.getCartItems().removeIf(cartItem -> id.equals(cartItem.getProduct().getId()));
        return "redirect:/cart";
    }
}
