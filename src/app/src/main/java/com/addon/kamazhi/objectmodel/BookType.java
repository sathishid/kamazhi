package com.addon.kamazhi.objectmodel;

/**
 * Created by sathishbabur on 3/25/2017.
 */

public class BookType {

    public static final String TABLE_NAME="BookType";
    public static final String COLUMN_NAME_ID="ID";
    public  static final String COLUMN_NAME_NAME="Name";
    public static final String COLUMN_NAME_DESC="Description";

    private int id;
    private String name;
    private String description;

    public BookType(int id,String name,String description)
    {
        this.id=id;
        this.name=name;
        this.description=description;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public  String getDescription()
    {
        return description;
    }
}
