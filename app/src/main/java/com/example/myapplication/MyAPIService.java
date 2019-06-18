package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyAPIService<restaurant> {
    // 測試網站      https://jsonplaceholder.typicode.com/
    // GET網址      https://jsonplaceholder.typicode.com/albums/1
    // POST網址     https://jsonplaceholder.typicode.com/albums
    // ...typicode.com/[這裡就是API的路徑]

    @GET("Restaurant?api_key=key5qsDjEVRN1DjvG")    // 設置一個GET連線，路徑為albums/1
    Call<Restaurant> getRes();    // 取得的回傳資料用Albums物件接收，連線名稱取為getAlbums

    @GET("Member?api_key=key5qsDjEVRN1DjvG")    // 設置一個GET連線，路徑為albums/1
    Call<Member> getMem();    // 取得的回傳資料用Albums物件接收，連線名稱取為getAlbums

    @GET("Card?api_key=key5qsDjEVRN1DjvG")    // 設置一個GET連線，路徑為albums/1
    Call<Card> getCard();    // 取得的回傳資料用Albums物件接收，連線名稱取為getAlbums

    @GET("category?api_key=key5qsDjEVRN1DjvG")    // 設置一個GET連線，路徑為albums/1
    Call<Category> getCat();    // 取得的回傳資料用Albums物件接收，連線名稱取為getAlbums

    @GET("Restaurant/{id}") // 用{}表示路徑參數，@Path會將參數帶入至該位置
    Call<Req> getShopcarById(@Path("id") String id);

    @POST("Member?api_key=key5qsDjEVRN1DjvG ")
    @Headers({
            "Accept: application/json; charset=utf-8",
            "Content-Type: application/json; charset=utf-8"
    })
    Call<Reqregist> PostMember(@Body Reqregist fields);

    @POST("Category?api_key=key5qsDjEVRN1DjvG ")
    @Headers({
            "Accept: application/json; charset=utf-8",
            "Content-Type: application/json; charset=utf-8"
    })
    Call<Reqregist> PostCategory(@Body Reqregist fields);

    @PATCH("Member/{id}?api_key=key5qsDjEVRN1DjvG")
    @Headers({
            "Accept: application/json; charset=utf-8",
            "Content-Type: application/json; charset=utf-8"
    })
    Call<Member> UpdateMemInfor(@Body Req fields , @Path("id") String id);
}
