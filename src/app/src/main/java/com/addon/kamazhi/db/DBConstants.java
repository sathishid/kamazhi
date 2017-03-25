package com.addon.kamazhi.db;

/**
 * Created by sathishbabur on 3/25/2017.
 */

public final class DBConstants {
    public static final int DBVersion=1;
    public static final String DBName="kamazhi-accounts.db";

    public static final String CREATE_BOOKTYPE_QUERY="CREATE TABLE BookType(id INTEGER,Name Text,Description Text)";
    public static final String INSERT_BOOKTYPE_QUERY="INSET BookType VALUES(1,'Alpha','Desc')";

}
