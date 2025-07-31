package Lib;
import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> products =new ArrayList<>();

    //RI: products list is not null, contain no null elements, and no duplicate products.
    //AF: AF(products) = A catalog of all available products.

    private void checkRep(){
        if(products == null){
            throw new RuntimeException("RI violated: products list cannot be null.");
        }
        //check for duplicate products
        for (int i = 0; i < products.size(); i++) {
            for (int j = i+1; j < products.size(); j++) {
                if(products.get(i).equals(products.get(j))){
                    throw new RuntimeException("RI violated:catalog contains duplicate products.");
                }
            }
        }
    }

    public ProductCatalog(){
        checkRep();
    }

    /**
     * เพิ่มสิค้าใหม่เข้าสู่catalog
     * @param product สินค้าที่ต้องการเพิ่ม
     */
    public void addProduct(Product product){
        if(product != null && !products.contains(product)){
            products.add(product);
        }
        checkRep();
    }

    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param productiId รหัสสินค้าที่ต้องการค้นหา
     * @return object Product หากพบ, หรือ null หากไม่พบ
     */
    public Product findById(String productId){
        for (Product p: products){
            if(p.getProductId().equals(productId)){
                return p;
            }
        }
        return null;
    }
}

