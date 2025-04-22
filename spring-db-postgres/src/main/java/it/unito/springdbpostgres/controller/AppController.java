package it.unito.springdbpostgres.controller;
import it.unito.springdbpostgres.model.Product;
import it.unito.springdbpostgres.model.ShoppingCart;
import it.unito.springdbpostgres.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("shoppingCart")
public class AppController {

    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute("shoppingCart")
    public ShoppingCart getOrCreateCart(HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("shoppingCart", cart);
        }
        return cart;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam(value="quantity", defaultValue="1") int quantity,
                            @ModelAttribute("shoppingCart") ShoppingCart cart) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));
        cart.addItem(product, quantity);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        return "cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") Long productId,
                                 @ModelAttribute("shoppingCart") ShoppingCart cart) {
        cart.removeItem(productId);
        return "redirect:/cart";
    }
}