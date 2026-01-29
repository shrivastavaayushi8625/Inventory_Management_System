import java.util.List;

public class Inventory {

    private List<Product> products;

    public Inventory() {
        products = FileUtil.loadProducts();
    }

    public void addProduct(Product product) {
        products.add(product);
        FileUtil.saveProducts(products);
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }

    public Product searchProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
        FileUtil.saveProducts(products);
    }
}
