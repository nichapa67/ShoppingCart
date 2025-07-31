package Lib;

public final class Product {
    private final String productId;
    private final String productName;
    private final double price;

    //Rep Invariant (RI):
    //  -productId and productName are not null or blank
    //  -price>=0
    //
    //Abstraction Function (AF):
    //  -AF(productId,productName,price)=A product with the given ID, name, and price.
    //

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if(productId==null || productId.isBlank()){
            throw new RuntimeException("RI violated: productId cannot null or blank");
        }
        if(productName==null || productName.isBlank()){
            throw new RuntimeException("RI violated: productName cannot null or blank");
        }
        if(price<0){
            throw new RuntimeException("RI violated: price cannot negative and zero");
        }
    }

    /**
     * @param productId รหัสสินค้า ห้ามเป็นค่าว่าง
     * @param productName ชื่อสินค้า ห้ามเป็นค่าว่าง
     * @param price ราคา ต้องไม่ติดลบ
     */
    public Product (String productId, String productName,double price){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        checkRep();
    }

    /**
     * @return รหัสสินค้า
     */
    public String getProductId(){
        return productId;
    }

    /**
     * @return ชื่อสินค้า
     */
    public String getProductName(){
        return productName;
    }

    /**
     * @return ราคาสินค้า
     */
    public double getPrice(){
        return price;
    }

    /**
     * เปรียบเทียบ Product 2ชิ้นโดยใช้ productId
     * @param obj objectที่ต้องการเปรียบเทียบ
     * @return true หาก ProductId เหมือนกัน
     */

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null || getClass()!= obj.getClass()) return false;
        Product product =(Product) obj;
        return productId.equals(product.productId);
    }


}
