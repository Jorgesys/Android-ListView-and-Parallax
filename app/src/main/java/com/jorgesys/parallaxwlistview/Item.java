package com.jorgesys.parallaxwlistview;

/**
 * Created by jorgesys on 05/04/2014.
 */

public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }
}
