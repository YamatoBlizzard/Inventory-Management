package project.projectf1g3;
//Class Product

class ProjectF1G3Product {
    private String id;
    private String name;
    private String category;
    private double price;

    public ProjectF1G3Product(String id, String name, 
            String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
    
    //Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}