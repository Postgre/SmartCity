package com.smartcity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.smartcity.config.Constant;
import com.smartcity.http.model.UserInfo;

/**
 * Created by Yancy on 2016/4/12.
 */
public class UserDao {

    private DbHelper helper;

    public UserDao(Context context) {
        helper = DbHelper.getInstance(context);
    }


    /**
     * 保存用户信息
     */
    public void saveUser(UserInfo.DataBean.ScSysUserBean userInfo) {
        if (null == userInfo) {
            throw new RuntimeException("userInfo is not null");
        }
        SQLiteDatabase sqLiteDatabase = null;
        try {
            sqLiteDatabase = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Constant.TableUserInfo.COLUMN_USER_ID, userInfo.getId());
            values.put(Constant.TableUserInfo.COLUMN_USER_NAME, userInfo.getUsername());
            values.put(Constant.TableUserInfo.COLUMN_USER_PRICE, userInfo.getUserpic());
            values.put(Constant.TableUserInfo.COLUMN_USER_BIRTH, userInfo.getUserbirth());
            values.put(Constant.TableUserInfo.COLUMN_USER_CODE, userInfo.getUsercode());
            values.put(Constant.TableUserInfo.COLUMN_USER_SEX, userInfo.getUsersex());
            values.put(Constant.TableUserInfo.COLUMN_USER_SIGNATURE, userInfo.getSignature()+"");
            values.put(Constant.TableUserInfo.COLUMN_USER_MESSAGE_NOTIFY,1);
            sqLiteDatabase.insert(Constant.DbInfo.USER_TABLE_NAME, null, values);
            sqLiteDatabase.close();
        } finally {
            closeDb(sqLiteDatabase);
        }

    }


    /**
     * 获取用户信息
     */
    public UserInfo.DataBean.ScSysUserBean getUser(String usercode) {

        SQLiteDatabase readableDatabase = null;
        UserInfo.DataBean.ScSysUserBean userBean = null;
        Cursor cursor = null;
        try {
            readableDatabase = helper.getReadableDatabase();
            cursor = readableDatabase.rawQuery(Constant.TableUserInfo.QUERY_USER_INFO, new String[]{usercode});
            if (cursor.getCount() > 0) {
                userBean = new UserInfo.DataBean.ScSysUserBean();
                while (cursor.moveToNext()) {
                    userBean.setId(cursor.getInt(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_ID)));
                    userBean.setUsercode(cursor.getString(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_CODE)));

                    userBean.setUsername(cursor.getString(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_NAME)));
                    userBean.setUserpic(cursor.getString(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_PRICE)));

                    userBean.setUsersex(cursor.getString(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_SEX)));
                    userBean.setUserbirth(cursor.getString(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_BIRTH)));

                    userBean.setSignature(cursor.getString(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_SIGNATURE)));
                }
            }
        } finally {
            closeDb(cursor, readableDatabase);
        }
        return userBean;
    }


    /**
     * 根据ID修改用户信息
     * 返回值小于零  则说明  修改出错
     */

    public int upDataUserInfoBuId(String id, String key, Object value) {

        if (TextUtils.isEmpty(key) || null == value) {
            throw new RuntimeException("update info is not null");
        }
        SQLiteDatabase writableDatabase = null;
        int update = -1;
        try {
            writableDatabase = helper.getWritableDatabase();
            if (null != writableDatabase) {
                ContentValues values = new ContentValues();

                if(value instanceof  String)
                {
                    values.put(key, (String)value);
                }
                else if(value instanceof  Integer)
                {
                    values.put(key, (Integer)value);
                }
                update = writableDatabase.update(Constant.DbInfo.USER_TABLE_NAME, values, Constant.TableUserInfo.UPDATA_BY_ID, new String[]{id});
            }
        } finally {
            closeDb(writableDatabase);
        }
        return update;
    }


    /**
     * 删除用户
     */

    public int deleteUser(String id)
    {
        SQLiteDatabase writableDatabase = null;
        int update = -1;
        try {
            writableDatabase = helper.getWritableDatabase();
            if (null != writableDatabase) {
               writableDatabase.delete(Constant.DbInfo.USER_TABLE_NAME,Constant.TableUserInfo.DELETE_BY_ID,new String[]{id});
            }
        } finally {
            closeDb(writableDatabase);
        }
        return update;
    }

    private void closeDb(Cursor cursor, SQLiteDatabase database) {
        if (null != cursor) {
            cursor.close();
            cursor = null;
        }
        closeDb(database);
    }


    private void closeDb(SQLiteDatabase sqLiteDatabase) {
        if (null != sqLiteDatabase) {
            sqLiteDatabase.close();
            sqLiteDatabase = null;
        }
    }


    /**
     * 获取用户 是否接受消息提示
     * return
     *  >0  表示开启
     * */
    public int isMessageNotify(String id)
    {
        int result = -1;
        SQLiteDatabase readableDatabase = helper.getReadableDatabase();
        if(null != readableDatabase)
        {
            Cursor cursor = readableDatabase.rawQuery(Constant.TableUserInfo.QUERY_USER_MESSAGE_NOTIFY, new String[]{id});
            if(cursor.moveToFirst())
            {
                result = cursor.getInt(cursor.getColumnIndex(Constant.TableUserInfo.COLUMN_USER_MESSAGE_NOTIFY));
            }
            closeDb(cursor,readableDatabase);
        }
        return result;
    }

}
