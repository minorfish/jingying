package com.test.jingying.datas;

/**
 * Created by guoyumei on 5/3/15.
 */
public class Bean {
    private int srcId;
    private String category;

    public String getCategory() {
        return category;
    }

    public int getSrcId() {
        return srcId;
    }

    public void setSrcId(int srcId) {
        this.srcId = srcId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Bean() {

    }

    public Bean(int srcId, String category) {
        this.srcId = srcId;
        this.category = category;
    }
}
