package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.model.ScShopComment;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Yancy on 2016/5/27.
 */
public interface CommentServer {

    String GET_COMMENT_LIST ="shop/commentList";

    String ADD_COMMENT="shop/addComment";

    String DEL_COMMENT="shop/delComment";
    /**
     * 评论列表
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<ScShopComment> getCommentList(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);

    /**
     * 添加评论
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<BaseModel> addComment(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);

    /**
     * 删除评论
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<BaseModel> deleteComment(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);
}
