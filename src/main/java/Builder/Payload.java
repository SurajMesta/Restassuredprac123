package Builder;

public class Payload {



    public Payload(double price, String title, String description, String image, String category) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
    }



    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
