package com.smartcity.model;

import com.smartcity.http.model.ScShopComment;
import com.smartcity.model.modelImpl.CommodityModelImpl;

/**
 * Created by Yancy on 2016/5/27
 * 评论
 * <p/>
 * 获取评论列表和添加评论
 */
public interface CommodityModel extends BaseModel {

    /**
     * @param hasPicture 是否需要图片
     * @param type       //评论类型，0-商品，1-店铺
     */
    void getCommodityList(String type, String shopId, String goodId, int pageNo, int pageSize, String hasPicture, String apikey, CommodityModelImpl.GetListCommentListener listener);

    /**
     * @param shopComment 评论对象
     */
    void addCommodiy(String apikey, ScShopComment.ScShopCommentList shopComment, CommodityModelImpl.AddCommentListener listener);

    /**
     * @param id 评论条目id后台生成的
     */
    void delCommodiy(String apikey, String id, CommodityModelImpl.DeleteCommentListener listener);
}
