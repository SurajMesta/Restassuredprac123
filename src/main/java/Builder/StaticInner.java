package Builder;

public class StaticInner {


    public StaticInner(String title, double price, String description, String category, String image) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
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




    public static class StaticInnerBuilder{
        private String title;

        public static StaticInnerBuilder build(){
            return new StaticInnerBuilder();
        }

        public StaticInner perform(){
            return new StaticInner(this.title,this.price,this.description,this.category,this.image);
        }

        public StaticInnerBuilder and(){
            return this;
        }

        public StaticInnerBuilder with(){
            return this;
        }

        public StaticInnerBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public StaticInnerBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public StaticInnerBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public StaticInnerBuilder setImage(String image) {
            this.image = image;
            return this;
        }

        public StaticInnerBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        private double price;
        private String description;
        private String image;
        private String category;
    }
}
