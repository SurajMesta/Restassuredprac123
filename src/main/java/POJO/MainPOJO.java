package POJO;

import java.util.List;

public class MainPOJO {


    public MainPOJO(String name, String place, List<String> abcd, FavsPOJO favs) {
        this.name = name;
        this.place = place;
        this.abcd = abcd;
        this.favs = favs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getAbcd() {
        return abcd;
    }

    public void setAbcd(List<String> abcd) {
        this.abcd = abcd;
    }

    public FavsPOJO getFavs() {
        return favs;
    }

    public void setFavs(FavsPOJO favs) {
        this.favs = favs;
    }

    private String name;
    private String place;
    private List<String> abcd;
    private FavsPOJO favs;
}
