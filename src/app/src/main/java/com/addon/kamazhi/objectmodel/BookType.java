package com.addon.kamazhi.objectmodel;

/**
 * Created by sathishbabur on 3/25/2017.
 */

public class BookType {

    public static final String TABLE_NAME="BookType";
    public static final String COLUMN_NAME_ID="ID";
    public  static final String COLUMN_NAME_NAME="Name";
    public static final String COLUMN_NAME_DESC="Description";
    public static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NAME+ " TEXT," +
                    COLUMN_NAME_DESC + " TEXT)";

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
