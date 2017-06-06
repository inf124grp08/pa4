package app;

public class Product {
  public int id;
  public String price;
  public String brand;
  public String description;
  public String image;

  public Product(int id, String price, String brand, String description, String image) {
    this.id = id;
    this.price = price;
    this.brand = brand;
    this.description = description;
    this.image = image;
  }

  public int getId() {
    return this.id;
  }

  public String getPrice() {
    return this.price;
  }

  public String getBrand() {
    return this.brand;
  }

  public String getDescription() {
    return this.description;
  }

  public String getImage() {
    return this.image;
  }
}
