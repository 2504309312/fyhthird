package com.example.admin.day04.app;

import android.app.Application;

import com.example.admin.day04.DaoMaster;
import com.example.admin.day04.DaoSession;

/**
 * Created by admin on 2018/3/6.
 */

public class MyApp extends Application {

    private static MyApp mApp;
    private DaoSession mDaoSession;

    public static MyApp getMyApp() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        createDataBase();
    }

    /**
     * 1、DevOpenHelper：创建SQLite数据库的SQLiteOpenHelper的具体实现。
     * 2、DaoMaster：GreenDao的顶级对象，作为数据库对象、用于创建表和删除表。
     * 3、DaoSession：管理所有的Dao对象，Dao对象中存在着增删改查等API。
     */
    private void createDataBase() {
        //创建数据库
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(mApp, "sc");
        //用数据库框架进行包装
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        //提供一个Session
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
