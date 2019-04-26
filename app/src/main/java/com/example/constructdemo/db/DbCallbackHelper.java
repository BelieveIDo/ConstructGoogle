package com.example.constructdemo.db;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.CopyOnWriteArrayList;

public class DbCallbackHelper {

    private static CopyOnWriteArrayList<AbsDbCallback> mDbCallbacks = new CopyOnWriteArrayList<>();

    public static void init() {
        mDbCallbacks.add(new EssayDbCallback());
    }

    public static void dispatchOnCreate(SupportSQLiteDatabase db) {
        for (AbsDbCallback callback : mDbCallbacks) {
            callback.create(db);
        }
    }

    private static void dispatchUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        for (AbsDbCallback callback : mDbCallbacks) {
            callback.upgrade(db, oldVersion, newVersion);
        }
    }

    public static Migration[] getUpdateConfig() {
        //每次数据库升级配置这里就可以自动分发到各业务模块的onUpgrade()方法
        return new Migration[]{
                new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        dispatchUpgrade(database, 1, 2);
                    }
                },
                new Migration(2, 3) {

                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        dispatchUpgrade(database, 2, 3);
                    }
                }
        };
    }
}
