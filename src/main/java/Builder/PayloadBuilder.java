package Builder;

public class PayloadBuilder {

    private PayloadBuilder(){};

    public static PayloadBuilder build(){
        return new PayloadBuilder();
    }

    public Payload perform(){
        return new Payload(this.price,this.category,this.description,this.image,this.title);
    }

    public PayloadBuilder and(){
        return this;
    }

    public PayloadBuilder with(){
        return this;
    }

    public PayloadBuilder setTitle(String title) {
        this.title = title;
        return this;

    }

    public PayloadBuilder setPrice(double price) {
        this.price = price;
        return this;

    }

    public PayloadBuilder setDescription(String description) {
        this.description = description;
        return this;

    }

    public PayloadBuilder setImage(String image) {
        this.image = image;
        return this;

    }

    public PayloadBuilder setCategory(String category) {
        this.category = category;
        return this;

    }




    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
