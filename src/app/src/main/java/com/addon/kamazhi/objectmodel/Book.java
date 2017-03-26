package com.addon.kamazhi.objectmodel;

/**
 * Created by sathishbabur on 3/26/2017.
 */

public class Book {
    public static final String TABLE_NAME = "Book";
    public static final String COLUMN_NAME_ID = "ID";
    public static final String COLUMN_NAME_NAME = "Name";
    public static final String COLUMN_NAME_DESC = "Description";
    public static final String COLUMN_NAME_Type = "BookType";
    public static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NAME + " TEXT," +
                    COLUMN_NAME_DESC + " TEXT," +
                    COLUMN_NAME_Type + " INTEGER)";

    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BookType getBookType() {
        throw new UnsupportedOperationException("Get Book Type Not yet implemented.");
    }

    private String name;
    private String description;
    private int bookType;

    public Book(int id, String name, String description, int bookType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.bookType = bookType;
    }
}
