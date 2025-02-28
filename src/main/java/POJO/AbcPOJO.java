package POJO;

public class AbcPOJO {
    public AbcPOJO(String name, String lname) {
        this.name = name;
        this.lname = lname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    private String name;
    private String lname;

}
