public class ElectronicProduct extends Product implements Discountable {

    private static final double VAT_RATE = 0.10;

    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() * (1 + VAT_RATE);
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Phần trăm giảm giá phải trong khoảng 0 - 100");
        }
        setPrice(getPrice() * (1 - percent / 100));
    }

}