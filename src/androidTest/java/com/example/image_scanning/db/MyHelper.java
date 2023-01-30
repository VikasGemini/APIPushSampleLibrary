package com.example.image_scanning.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper{

	public MyHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
//		db.execSQL("create table stocktransfer(_id integer primary key autoincrement, waybillno varchar, pktid varchar,pktcond varchar,frombr varchar,tobr varchar, crdate varchar,crby varchar,image Text)");
		db.execSQL("create table poddetails(_id integer primary key autoincrement, waybillno varchar, createddate varchar,createdtime varchar,validationoutput varchar,validationresult varchar,validationimage text,snsdoutput varchar,snsdresult varchar,snsdimage text,stampoutput varchar,stampresult varchar,stampimage text)");

//		db.execSQL("create table vdetails(_id integer primary key autoincrement, ids varchar, rpsno varchar,vhlno varchar, rtecd varchar,deptime varchar, depdate varchar,trhs varchar, trmns varchar,trtime varchar, ceta varcharr,lat varchar,log varchar,devicedt varchar, img text,brid varchar,scandt varchar)");
		db.execSQL("create table appdt(_id integer primary key autoincrement, installdt varchar)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub		
	}
}
