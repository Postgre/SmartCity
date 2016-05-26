package com.smartcity.inter;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: UpLoadListener.java
 * @author: fengliang
 * @date: 2016-05-26 14:47
 */
public interface UpLoadListener<T> {

    void upLoading(long currentSize, long totalSize);

    void upLoadSuccess(T result, String uploadPath);

    void upLoadSuccess(T result, String thumbnailPath, String uploadPath);

    void upLoadError(String msg);

}
