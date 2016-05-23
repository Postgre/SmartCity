package com.smartcity.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.smartcity.config.Constant;


/**
 * Created by Yancy on 2016/4/12.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static DbHelper helper;

    public static DbHelper getInstance(Context context)
    {
        if(null == helper)
        {
            synchronized (DbHelper.class)
            {
                if(null == helper)
                {
                    helper = new DbHelper(context, Constant.DbInfo.DATABASE_NAME,null,Constant.DbInfo.DATABASE_VERSION);
                }
            }
        }
        return helper;
    }


    private DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constant.DbInfo.USER_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
