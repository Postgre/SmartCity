package com.smartcity.model.modelImpl;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.model.ScShopComment;
import com.smartcity.http.service.CommentServer;
import com.smartcity.model.CommodityModel;
import com.smartcity.utils.GsonUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yancy on 2016/5/27.
 */
public class CommodityModelImpl extends BaseModelImpl implements CommodityModel {
    private final CommentServer commentServer;

    public CommodityModelImpl() {
        commentServer = HttpApi.getInstance().create(CommentServer.class);
    }

    @Override
    public void getCommodityList(String type, String shopId, String goodId, int pageNo, int pageSize, String hasPicture, String apikey, final GetListCommentListener listener) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("type", type);//评论类型，0-商品，1-店铺
        params.put("shopId", shopId);
        params.put("goodsId", goodId);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        params.put("hasPicture", hasPicture);
        commentServer.getCommentList(Constant.VALUE_VERSION, CommentServer.GET_COMMENT_LIST, GsonUtils.objectToJson(params), apikey).enqueue(new Callback<ScShopComment>() {
            @Override
            public void onResponse(Call<ScShopComment> call, Response<ScShopComment> response) {
                ScShopComment body = response.body();
                if (null != body) {
                    if (ResCode.STATUS_SUCCESS_CODE == body.getCode()) {
                        listener.getCommentSuccess(body);
                    } else {
                        listener.getCommentError(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<ScShopComment> call, Throwable t) {
                listener.getCommentError(t.getMessage());
            }
        });
    }

    @Override
    public void addCommodiy(String apikey, ScShopComment.ScShopCommentList shopComment, final AddCommentListener listener) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("type", shopComment.getType());//评论类型，0-商品，1-店铺
        params.put("shopId", shopComment.getShopId());
        params.put("goodsId", shopComment.getGoodsId());
        params.put("userId", shopComment.getUserId());
        params.put("userCode", shopComment.getUserCode());
        params.put("score", shopComment.getScore());
        params.put("scoreDesc", shopComment.getScoreDesc());
        params.put("scoreService", shopComment.getScoreService());
        params.put("scoreDelivery", shopComment.getScoreDelivery());
        params.put("commentTitle", shopComment.getCommentTitle());
        params.put("commentContent", shopComment.getCommentContent());
        params.put("orderNo", shopComment.getOrederNo());
        commentServer.addComment(Constant.VALUE_VERSION, CommentServer.ADD_COMMENT, GsonUtils.objectToJson(params), apikey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                BaseModel body = response.body();
                if (null != body) {
                    if (ResCode.STATUS_SUCCESS_CODE == body.getCode()) {
                        listener.addCommentSuccess();
                    } else {
                        listener.addCommentError(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                listener.addCommentError(t.getMessage());
            }
        });

    }

    @Override
    public void delCommodiy(String apikey, String id, final DeleteCommentListener listener) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        commentServer.deleteComment(Constant.VALUE_VERSION, CommentServer.DEL_COMMENT, GsonUtils.objectToJson(params), apikey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                BaseModel body = response.body();
                if (null != body) {
                    if (ResCode.STATUS_SUCCESS_CODE == body.getCode()) {
                        listener.delCommentSuccess();
                    } else {
                        listener.delCommentError(null);
                    }
                }

            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                listener.delCommentError(t.getMessage());
            }
        });
    }


    public interface GetListCommentListener<T> {
        void getCommentSuccess(T t);

        void getCommentError(String msg);
    }

    public interface AddCommentListener {
        void addCommentSuccess();

        void addCommentError(String msg);
    }

    public interface DeleteCommentListener {
        void delCommentSuccess();

        void delCommentError(String msg);
    }
}
