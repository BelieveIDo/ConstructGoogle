package com.example.constructdemo.db;

import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class AbsDbCallback {

    public abstract void create(SupportSQLiteDatabase db);

    public abstract void open();

    public abstract void upgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion);

}