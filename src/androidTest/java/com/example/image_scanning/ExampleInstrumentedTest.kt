package com.example.image_scanning

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.image_scanning.bean.AddScanDataRequestBean
import com.example.image_scanning.bean.AddScanDataRequestBean.ReqBody
import com.example.image_scanning.bean.AddScanDataResponseBean
import com.example.image_scanning.retrofit.APIClient
import com.example.image_scanning.retrofit.ApiInterface
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.image_scanning.test", appContext.packageName)
    }

    fun SaveDataOnlineDB(
//        obj: JSONObject,
//        fullImgURL: String,
//        snsdImgURL: String,
//        stampImgURL: String,
//        arraylength: Int,
//        currentIndex: Int
    ) {
        Log.i("","Save Data OnlineDB")
//        Log.i("txtwaybill",txtwaybill)
//        Log.i("fullImageS3Path",fullImageS3Path)
//        Log.i("validationModelResult",validationModelResult)
//        Log.i("snsdImageS3Path",snsdImageS3Path)
//        Log.i("snsdModelResult",snsdModelResult)
//        Log.i("stampImageS3Path",stampImageS3Path)
//        Log.i("stampModelResult",stampModelResult)

        val systemsyncDate = Date()
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val timeformatter = SimpleDateFormat("HH:mm:ss")
        val currentsyncdate = formatter.format(systemsyncDate)
        val currentsynctime = timeformatter.format(systemsyncDate)
        var apiInterface = APIClient.getClient().create(ApiInterface::class.java);
        val asd = AddScanDataRequestBean()
        val list: MutableList<ReqBody> = ArrayList()
        val rb = asd.ReqBody()
        rb.created_date = "30-01-2022"; //obj.getString("createddate");    //result from SqlLite
        rb.created_time = "17:03:51"; //obj.getString("createdtime");  //result from SqlLite
        rb.sync_date = currentsyncdate;
        rb.sync_time = currentsynctime;
        rb.validation_output = "PACKAGE CALL"; //obj.getString("validationoutput");
        rb.waybill = "PACKAGE CALL"; //obj.getString("waybillno");
        rb.s3path = "PACKAGE CALL"; //fullImgURL;
        rb.validation_result = "PACKAGE CALL"; //obj.getString("validationresult");
        rb.validation_type = "VALIDATION";
//        val rb1 = asd.ReqBody()
//        rb1.created_date = "PACKAGE CALL"; //obj.getString("createddate");
//        rb1.created_time = "PACKAGE CALL"; //obj.getString("createdtime");
//        rb1.sync_date = currentsyncdate;
//        rb1.sync_time = currentsynctime;
//        rb1.validation_output = "PACKAGE CALL"; //obj.getString("snsdoutput");
//        rb1.waybill = "PACKAGE CALL"; //obj.getString("waybillno");
//        rb1.s3path = "PACKAGE CALL"; //snsdImgURL;
//        rb1.validation_result = "PACKAGE CALL"; //obj.getString("snsdresult");
//        rb1.validation_type = "SNSD";
//        val rb2 = asd.ReqBody()
//        rb2.created_date = "PACKAGE CALL"; //obj.getString("createddate");
//        rb2.created_time = "PACKAGE CALL"; //obj.getString("createdtime");
//        rb2.sync_date = currentsyncdate;
//        rb2.sync_time = currentsynctime;
//        rb2.validation_output = "PACKAGE CALL"; //obj.getString("stampoutput");
//        rb2.waybill = "PACKAGE CALL"; //obj.getString("waybillno");
//        rb2.s3path = "PACKAGE CALL"; //stampImgURL;
//        rb2.validation_result = "PACKAGE CALL"; //obj.getString("stampresult");
//        rb2.validation_type = "STAMP";
        list.add(rb);
//        list.add(rb1);
//        list.add(rb2);
        asd.input = list

//        objScanData.input = List<AddScanDataRequestBean.ReqBody>();
//
//        imgupload.entity = txtwaybill;
//        imgupload.waybill = "STAMP";
        //Log.i("RequestList",asd.toString())
        val call: Call<AddScanDataResponseBean> = apiInterface.saveScannedData(asd);
        call.enqueue(object : Callback<AddScanDataResponseBean> {
            @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
            override fun onResponse(
                call: Call<AddScanDataResponseBean>,
                response: Response<AddScanDataResponseBean>
            ) {
                Log.i("Response", "")
                if (response.body().message == "successfully_inserted") {
                    Log.i("upload ScanData Response", "" + response)
                    Log.i("Status_code", response.body().success_code)
                    Log.i("Message", response.body().message);
//                    var dba = MyDba(this@MainActivity);
//                    dba.open();
//                    dba.remove_pod_by_id(obj.getString("stampresult"));

//                    if(arraylength == (currentIndex+1)) {
//                        var cm = CommonMethods(this@MainActivity);
//                        cm.showPopup("Data Uploaded. Please check Portal to verify.");
//                        Log.i("FinalDB","")
//                        dba.podDetails;
//                    }
//                    dba.close();
                }
            }
            override fun onFailure(call: Call<AddScanDataResponseBean>, t: Throwable) {
                call.cancel()
            }
        })
    }
}