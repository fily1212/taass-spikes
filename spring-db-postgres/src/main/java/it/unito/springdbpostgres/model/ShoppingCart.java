package it.unito.springdbpostgres.model;

import lombok.Getter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<Long, CartItem> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        CartItem existingItem = items.get(product.getId());
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            items.put(product.getId(), new CartItem(product.getId(), product.getName(), quantity, product.getPrice()));
        }
    }

    public void removeItem(Long productId) {
        items.remove(productId);
    }

    public BigDecimal getTotal() {
        return items.values().stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public int getItemCount() {
        return items.values().stream().mapToInt(CartItem::getQuantity).sum();
    }
}