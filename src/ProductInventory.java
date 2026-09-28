import java.util.ArrayList;
import java.util.List;

public class ProductInventory {

    private List<Product> product;

    public ProductInventory() {
        this.product = new ArrayList<>();
    }

    public void addProduct(Product p) {
        if (p != null) {
            product.add(p);
        }
    }

    public boolean removeProduct(String id) {
        if (id == null) {
            return false;
        }
        return product.removeIf(p -> id.equals(p.getId()));
    }

    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        if (name == null) {
            return result;
        }
        String keyword = name.toLowerCase();
        for (Product p : product) {
            if (p.getName() != null && p.getName().toLowerCase().contains(keyword)) {
                result.add(p);
            }
        }
        return result;
    }

    public double calculateTotalValue() {
        double total = 0;
        for (Product p : product) {
            total += p.calculateFinalPrice();
        }
        return total;
    }
}