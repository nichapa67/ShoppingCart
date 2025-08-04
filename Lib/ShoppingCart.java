package Lib;
import java.util.*;

/**
 * ADT ที่เปลี่ยนแปลงได้ (Mutable) สำหรับตะกร้าสินค้า
 * เก็บรายการสินค้าแบบ CartItem และคำนวณราคาทั้งหมดได้จากPricingService
 */
public class ShoppingCart {
     private List<CartItem> items;
    private PricingService pricingService;
    private ProductCatalog catalog;
    //Rep Invariant (RI):
    // items != null และไม่มี CartItem ที่ product เป็น null หรือ quantity <= 0
    // pricingService != null
    // catalog != null
    //
    //Abstraction Function (AF):
    // AF(items, pricingService, catalog) = ตะกร้าสินค้าที่มีรายการสินค้าทั้งหมด items
    // ที่สามารถคำนวณราคารวมโดยใช้ pricingService และดึงข้อมูลสินค้าได้จาก catalog


    /**
     * สร้างตะกร้าสินค้าใหม่ โดยต้องมี PricingService และ ProductCatalog ที่ไม่เป็น null
     * @param pricingService ตัวช่วยคำนวณราคาสินค้า
     * @param catalog แหล่งข้อมูลของสินค้า
     */
    public ShoppingCart(PricingService pricingService, ProductCatalog catalog) {
        this.items = new ArrayList<>();
        this.pricingService = pricingService;
        this.catalog = catalog;
    }
    
    /**
     * คืนจำนวนรายการสินค้าที่อยู่ในตะกร้า
     * @return จำนวน CartItem ในตะกร้า
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * คำนวณราคารวมทั้งหมดของสินค้าที่อยู่ในตะกร้า โดยใช้ PricingService
     * @return ราคาทั้งหมดของสินค้าในตะกร้า
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : items) {
            total += pricingService.calculateItemPrice(item);
        }
        return total;
    }
    /**
     * เพิ่มสินค้าเข้าไปในตะกร้าตาม productId และจำนวนที่ระบุ
     * ถ้ามีอยู่แล้วจะเพิ่มจำนวนเข้าไป
     * @param productId รหัสสินค้า
     * @param quantity จำนวนที่ต้องการเพิ่ม (ต้อง > 0)
     */
    public void addItem(String productId, int quantity) {
        if (quantity <= 0) return;
            Product product = catalog.findById(productId);
        if (product == null) return;
            for (CartItem item : items) {
                if (item.getProduct().getProductId().equals(productId)) {
                    item.increaseQuantity(quantity);
                    return;
                }       
        }
        items.add(new CartItem(product, quantity));
    }

    /**
     * ลบสินค้าจากตะกร้า โดยระบุจากรหัสสินค้า
     * @param productId รหัสสินค้าที่ต้องการลบ
     */
    public void removeItem(String productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProductId().equals(productId)) {
                items.remove(i);
                return;
            }
        }
    }

    /**
     * ล้างรายการทั้งหมดในตะกร้า
     */
    public void clearCart() {
        items.clear();
    }
}