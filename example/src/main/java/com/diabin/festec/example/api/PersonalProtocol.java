package com.diabin.festec.example.api;

import com.diabin.festec.example.bean.BaseBean;
import com.diabin.festec.example.bean.CarouselBean;
import com.diabin.festec.example.bean.HomeCategoryBean;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PersonalProtocol {

    /**
     *  首页轮播
     * @return
     */
    @FormUrlEncoded
    @POST("contentCategory/information")
    Call<BaseBean<HomeCategoryBean>> homeData(@Field("categoryId") long categoryId,
                                              @Field("time") String time,
                                              @Field("pnum") int pnum,
                                              @Field("psize") int psize);
    /**
     *  首页轮播
     * @return
     */
    @FormUrlEncoded
    @POST("contentCategory/information")
    Call<BaseBean<CarouselBean>> carouselData(@Field("categoryId") long categoryId,
                                          @Field("time") String time,
                                          @Field("pnum") int pnum,
                                          @Field("psize") int psize);

}
