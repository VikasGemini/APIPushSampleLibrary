package com.example.image_scanning.retrofit;


//import com.app.ashokfoundationadmin.bean.Get_Regis_ResponseBean;
//import com.app.ashokfoundationadmin.bean.Registration_From_Af_Bean;
//import com.app.ashokfoundationadmin.bean.Registration_From_Af_ReposBean;


import com.example.image_scanning.bean.AddScanDataRequestBean;
import com.example.image_scanning.bean.AddScanDataResponseBean;
import com.example.image_scanning.bean.ImageUploadBean;
import com.example.image_scanning.bean.ImageUploadResponseBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by 80014 on 11/26/2018.
 */

public interface ApiInterface {


    //
//    @POST("login?")
//    Call<LoginResponseBean> getLogin(@Body LoginBean lb);
//
    @POST("upload")
    Call<ImageUploadResponseBean> uploadbase64toS3(@Body ImageUploadBean lb);

//
    @POST("insert")
    Call<AddScanDataResponseBean> saveScannedData(@Body AddScanDataRequestBean lb);
//
//
//
//    @POST("applog?")
//    Call<AddMemberResponseBean> saveAppLog(@Body AppLogRequestBean lb);
//
//    @GET("coming_event?")
//    Call<ComingEvent_ResponseBean> getComingEvent();
//
//    @GET("apiversion?")
//    Call<AppVersionResponseBean> getAppVersion();
//
//    @GET("member_fees?")
//    Call<MemberFees_ResponseBean> getMemberFees();
//    @GET("search_fpo_data?")
//    Call<GetKisan_FpoDataBean> getSearchKisanFpd(@Query("searchType") String searchType,@Query("searchData") String searchData);
//
//    @GET("edit_search_kisan_fpo?")
//    Call<GetKisan_FpoDataBean> getEditSearchKisanFpd(@Query("searchData") String searchData);
//
//
//    @POST("edit_kison_fpo_data?")
//    Call<Save_Kisan_Fpo_ResponseBean> saveFpoData(@Body Edit_Fpo_DataBean lb);
//
//    @GET("doc_type_look?")
//    Call<Doc_Type_Look_Bean> getLookupDetail(@Query("lookType") String lookType);
//
//    @GET("vill_lookup?")
//    Call<Doc_Type_Look_Bean> getVillIdDetail(@Query("lookType") String lookType);
//
//
//    @GET("block_lookup?")
//    Call<Doc_Type_Look_Bean> getBlockIdDetail(@Query("lookType") String lookType);
//
//    @POST("update_document?")
//    Call<UpdateDocument_ResponseBean> update_documentDetail(@Body UpdateDocument_Bean ub);
//
//    @GET("user_status?")
//    Call<UserStatusBean> getUserStatus();
//
//    @GET("gender_user_count?")
//    Call<GenderStatusBean> getGenderStatus();
//
//    @GET("villege_wise_user?")
//    Call<VillegeWiseUserBean> getVillegeList();
//
//
}
