package POJO;

import java.util.List;

public class FavsPOJO {






    public FavsPOJO(String xyz, List<String> list, AbcPOJO abc1) {
        this.xyz = xyz;
        this.list = list;
        this.abc1 = abc1;
    }

    public String getXyz() {
        return xyz;
    }

    public void setXyz(String xyz) {
        this.xyz = xyz;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public AbcPOJO getAbc1() {
        return abc1;
    }

    public void setAbc1(AbcPOJO abc1) {
        this.abc1 = abc1;
    }

    private String xyz;
    private List<String> list;
    private AbcPOJO abc1;

}
