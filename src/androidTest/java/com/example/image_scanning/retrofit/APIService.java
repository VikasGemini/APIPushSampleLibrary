package com.example.image_scanning.retrofit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.RequiresApi;


import com.example.image_scanning.bean.ImageUploadBean;
import com.example.image_scanning.bean.ImageUploadResponseBean;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIService {

    String res = "";
    private Context context;
    ApiInterface apiInterface;


    public String call_save_Service(String imgBase64, String waybill, String entity) {
        /**
         GET List Resources
         **/

        try {
            Log.i("base64", imgBase64);
            Log.i("waybill", waybill);
            Log.i("entity", entity);
            apiInterface = APIClient.getClient().create(ApiInterface.class);
            ImageUploadBean imgupload = new ImageUploadBean();
            imgupload.setBase64string(imgBase64);
            imgupload.setEntity(entity);
            imgupload.setWaybill(waybill);

//            final ProgressDialog pd = new ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT);
//            pd.setMessage("Please wait");
//            pd.setCancelable(false);
//            pd.show();
            Call<ImageUploadResponseBean> call = apiInterface.uploadbase64toS3(imgupload);
            call.enqueue(new Callback<ImageUploadResponseBean>() {
                @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
                @Override
                public void onResponse(Call<ImageUploadResponseBean> call, Response<ImageUploadResponseBean> response) {
                    Log.i("upload response", "" + response);
//                    if (response != null) {
////                        pd.dismiss();
//                    }
                    Log.i("Status_code", response.body().getStatus_code() + "");
                    Log.i("Output", response.body().getOutput() + "");
                    Log.i("Message", response.body().getMessage() + "");
                    if (response.body().getMessage().equalsIgnoreCase("Uploaded to S3")) {
                        res = response.body().getOutput();
                    } else {
                        res = "";
                    }
                    //                    ImageUploadResponseBean resource = response.body();
//                    if (resource != null) {
//                        String status = resource.getStatus();
//                        if (status.equalsIgnoreCase("success")) {
//                            Log.i("Output", "" +resource.getOutput());
//                            res=resource.getOutput();
//                        } else {
//                            res="";
//
//                        }
//                    }
                }

                @Override
                public void onFailure(Call<ImageUploadResponseBean> call, Throwable t) {
//                    pd.dismiss();
                    call.cancel();
                    res = "";

                }


            });
        } catch (Exception ex) {
            ex.printStackTrace();
            res = "";
            Log.i("Error:", ex.toString());
        }
        return res;
    }

    public String getBinaryString(Bitmap photo) {
        String imageData = "";
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 50, out);
            byte[] bytes = out.toByteArray();
            imageData = Base64.encodeToString(bytes, 0);

//            CommonMethods cm = new CommonMethods(context);
//            cm.showPopup("Hi");
//            if(CheckNetworkState.isNetworkAvailable(context)){
//
//            }else{
//                cm.showPopup("Internet Not Connected.");
//            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return imageData;
    }


}
