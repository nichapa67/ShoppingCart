package Lib;

public class CartItem {
    private final Product product;
    private int quantity;

    // Rep Invariant (RI):
    //  -product is not null.
    //  -quantity>=0
    //
    // Abstraction Function (AF):
    //  -AF(product,quantity)=An item in a shopping cart with given 'product'
    //   with the specified 'quantity'.

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if(product==null){
            throw new RuntimeException("RI violated: product cannot null");
        }
        if(quantity<=0){
            throw new RuntimeException("RI violated: quantity cannot negative and zero");
        }
    }
    /**
     * สร้างรายการสินค้าในตะกร้า
     */

    public CartItem(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
        checkRep();
    }

    public Product getProduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }

    /**
     * @return object Product
     */
    public void increaseQuantity(int amount){
        if(amount>0){
            this.quantity+=amount;
        }
        checkRep();//ตรวจสอบหลังการเปลี่ยนสถานะ
    }
}
