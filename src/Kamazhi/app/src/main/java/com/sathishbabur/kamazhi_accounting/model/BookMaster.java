package com.sathishbabur.kamazhi_accounting.model;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public final class BookMaster
{
    private int bookId;
    private String name;
    private String desc;
    private int bookTypeId;
    private BookTypeMaster bookTypeMaster;

    public BookMaster(int bookId, String name, String desc, int bookTypeId) {
        this.bookId = bookId;
        this.name = name;
        this.desc = desc;
        this.bookTypeId = bookTypeId;
    }
    public int getBookTypeId()
    {
        return bookTypeMaster.getTypeId();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
