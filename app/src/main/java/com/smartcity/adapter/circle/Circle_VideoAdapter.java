package com.smartcity.adapter.circle;

import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.smartcity.R;
import com.smartcity.bean.VideoModel;
import com.smartcity.http.model.CircleVideo;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class Circle_VideoAdapter extends
		CommonAdapter<CircleVideo.DataBean> {
	public Circle_VideoAdapter(Context context,
							   List<CircleVideo.DataBean> list, int view) {
		super(context, list, view);
	}

	@Override
	public void convert(ViewHolder holder, CircleVideo.DataBean t) {
		// TODO Auto-generated method stub
		holder.setImageURI(R.id.video_image, t.getVideoAlbumUrl())
				.setText(R.id.video_introduce, t.getVideoAlbumDescription())
				.setImageURI(R.id.video_img, t.getScSysUser().getUserpic())
				.setText(R.id.video_title, t.getVideoAlbumTypeName())
				.setText(R.id.video_number, t.getVideoAlbumTimes() + "");
		JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) holder.getView(R.id.custom_videoplayer_standard);
		jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4"
				, "你好啊");
		ImageLoader.getInstance().displayImage("http://img4.jiecaojingxuan.com/2016/5/1/3430ec64-e6a7-4d8e-b044-9d408e075b7c.jpg",
				jcVideoPlayerStandard.ivThumb);
//		jcVideoPlayerStandard.ivStart.performClick();
	}
}
