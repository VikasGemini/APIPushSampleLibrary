package com.example.image_scanning.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

//import com.vehiclerps.alert.CommonMethods;


public class MyDba {
	private Context ctx;
	private MyHelper helper;
	public static SQLiteDatabase db;
	public MyDba(Context ctx) {
		this.ctx = ctx;
		helper = new MyHelper(ctx, "podscanner.db", null, 1);
	}

	public void open() {
		db = helper.getWritableDatabase();
	}

	public void close() {
		db.close();
	}

	
	public String insertpod(String waybillno,String createddate,String createdtime,
						String validationoutput,String validationresult,String validationimage,
						String snsdoutput,String snsdresult,String snsdimage,
						String stampoutput,String stampresult,String stampimage) {
		String res = "";
	
		try {
			
			ContentValues cv = new ContentValues();
			cv.put("waybillno", waybillno);
			cv.put("createddate", createddate);
			cv.put("createdtime", createdtime);
			cv.put("validationoutput", validationoutput);
			cv.put("validationresult", validationresult);
			cv.put("validationimage", validationimage);
			cv.put("snsdoutput", snsdoutput);
			cv.put("snsdresult", snsdresult);
			cv.put("snsdimage", snsdimage);
			cv.put("stampoutput", stampoutput);
			cv.put("stampresult", stampresult);
			cv.put("stampimage", stampimage);

			double x = db.insert("poddetails", null, cv);
			if (x > 0) {
				res = "success :" + x;
				Log.i("success :",res);
				getPODDetails();
//				Log.i("",select * from )
			}
			
		} catch (Exception ex) {
			res=ex.toString();
		}
		return res;
	}
	
	public String appinstalldt(String installdt) {
	
	
	String res = "";

	try {
		
		ContentValues cv = new ContentValues();
		cv.put("installdt", installdt);
				
		
		double x = db.insert("appdt", null, cv);
		if (x > 0) {
			res = "success :" + x;
		}
		
	} catch (Exception ex) {
		res=ex.toString();
	}
	return res;
}

	public String remove_pod_by_id(String id){
		String res="";
		Cursor cur = null;
		try {
			cur = db.rawQuery("delete from poddetails where _id = " + id, null);
			Log.i("Deleting object with id = ",id);
			Log.i("cur",cur.toString());
			res="success";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	public String emptypoddetails(){
		String res="";
		Cursor cur = null;
		try {
			cur = db.rawQuery("delete from poddetails", null);
				cur.moveToFirst();
				res="success";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

//	public static String getStHeader(String batchNo) {
	public JSONArray  getPODDetails() {
		JSONArray arr =new JSONArray();
			String result="";
		int count=0;
		try {
			Cursor c = MyDba.db.rawQuery(
					"select * from  poddetails", null);
//					"select * from  poddetails where batchno='"+batchNo+"'", null);
			c.moveToFirst();
			count=c.getInt(0);
			if(c.getCount()>0){

				do {
					JSONObject ojb= new JSONObject();
					ojb.put("_id", c.getString(c.getColumnIndex("_id")));
					ojb.put("waybillno", c.getString(c.getColumnIndex("waybillno")));
					ojb.put("createddate", c.getString(c.getColumnIndex("createddate")));
					ojb.put("createdtime", c.getString(c.getColumnIndex("createdtime")));
					ojb.put("validationoutput", c.getString(c.getColumnIndex("validationoutput")));
					ojb.put("validationresult",  c.getString(c.getColumnIndex("validationresult")));
					ojb.put("validationimage", c.getString( c.getColumnIndex("validationimage")));
					ojb.put("snsdoutput",  c.getString(c.getColumnIndex("snsdoutput")));
					ojb.put("snsdresult", c.getString(c.getColumnIndex("snsdresult")));
					ojb.put("snsdimage",  c.getString(c.getColumnIndex("snsdimage")));
					ojb.put("stampoutput",  c.getString(c.getColumnIndex("stampoutput")));
					ojb.put("stampresult", c.getString(c.getColumnIndex("stampresult")));
					ojb.put("stampimage",  c.getString(c.getColumnIndex("stampimage")));
//					ojb.put("syncdate", c.getString(c.getColumnIndex("syncdate")));
//					ojb.put("synctime", c.getString(c.getColumnIndex("synctime")));
//					ojb.put("scanqty",countScanpkg(batchNo));

					arr.put(ojb);

				} while (c.moveToNext());

				//result = arr.toString();
				Log.i("POD Table Result",arr.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arr;

	}
	
	
	
}
