package app;

public class Category {
  public String name;
  public String label;
  public String description;
  public String image;

  public Category(String name, String label, String description, String image) {
    this.name = name;
    this.label = label;
    this.description = description;
    this.image = image;
  }

  public String getName() {
    return this.name;
  }

  public String getLabel() {
    return this.label;
  }

  public String getDescription() {
    return this.description;
  }

  public String getImage() {
    return this.image;
  }
}
