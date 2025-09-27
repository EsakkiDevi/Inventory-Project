package model;

public class Product {
    private int productId;
    private String name, sku, category;
    private double price;
    private int quantity;
    private String supplierName;

    public Product() {}
    public Product(String name, String sku, String category, double price, int quantity) {
        this.name = name;
        this.sku = sku;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    

    public Product(String name, String sku, String category, double price, int quantity, String supplierName) {
        this.name = name;
        this.sku = sku;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
    }

    // getter & setter
    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }


   
    public int getProductId() 
    { 
    	return productId; 
    }
    public void setProductId(int productId) 
    { 
    	this.productId = productId; 
    }
    public String getName() 
    { 
    	return name; 
    }
    public void setName(String name) 
    { 
    	this.name = name; 
    }
    public String getSku() 
    { 
    	return sku; 
    }
    public void setSku(String sku) 
    { 
    	this.sku = sku; 
    }
    public String getCategory() 
    { 
    	return category; 
    }
    public void setCategory(String category) 
    { 
    	this.category = category; 
    }
    public double getPrice() 
    { 
    	return price; 
    }
    public void setPrice(double price) 
    { 
    	this.price = price; 
    }
    public int getQuantity() 
    { 
    	return quantity; 
    }
    public void setQuantity(int quantity) 
    { 
    	this.quantity = quantity; 
    }
    public boolean isLowStock(int threshold) 
    {
        return this.quantity <= threshold;
    }

    
    
    
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + ", sku=" + sku +
               ", category=" + category + ", price=" + price + ", quantity=" + quantity + "]";
    }

}