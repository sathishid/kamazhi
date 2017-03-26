package com.addon.kamazhi.objectmodel;

import com.addon.kamazhi.db.BookTypeDB;
import com.addon.kamazhi.db.DBHelper;

import java.util.ArrayList;

/**
 * Created by sathishbabur on 3/26/2017.
 */

public class BookTypes {
    private ArrayList<BookType> bookTypes;
    public static BookTypes listofBooks;

    public BookTypes() {
        bookTypes = new ArrayList<>();
    }
    public void addBookTypes(BookType bookType)
    {
        bookTypes.add(bookType);
    }
    public static BookTypes getPreservedTypes()
    {
        if(listofBooks==null) {
            listofBooks = new BookTypes();
            listofBooks.bookTypes = BookTypeDB.listBookTypes();
        }
        return listofBooks;
    }
}
