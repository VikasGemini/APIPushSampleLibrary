package com.example.image_scanning.retrofit;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ASHWNI on 06-12-2018.
 */

public class HttpServiceCalls {
     Context ctx=null;
     public HttpServiceCalls(Context ctx){
         this.ctx = ctx;
     }


     public String callGetApi(String strUrl, String method) {
        String res = "";
//        if (CheckNetworkState.isNetworkAvailable(ctx)) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                res += output;
            }
            conn.disconnect();

        } catch (Exception e) {
            res = e.toString();
        }
//        } else {
//            Toast.makeText(ctx, "Network problem", Toast.LENGTH_SHORT).show();
//        }
        return res;
    }

    public String callPostApi(String urlpath,String image) {
        String res = "";
        HttpURLConnection connection = null;
//        if (CheckNetworkState.isNetworkAvailable(ctx)) {

        try {
            JSONObject obj= new JSONObject();
            obj.put("image",image);
            URL url = new URL(urlpath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(2000000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
            streamWriter.write(obj.toString());
            streamWriter.flush();
            StringBuilder stringBuilder = new StringBuilder();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String response = null;
                while ((response = bufferedReader.readLine()) != null) {
                    stringBuilder.append(response + "\n");
                }
                bufferedReader.close();
                res = stringBuilder.toString();
            } else {
                res = stringBuilder.toString();
            }
        } catch (Exception exception) {
            res = exception.toString();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
//        } else {
//            Toast.makeText(ctx, "Network problem", Toast.LENGTH_SHORT).show();
//        }
        return res;
    }


    public String callPayTmPostApi(String urlpath, String response1, String phone) {
        String res = "";
        HttpURLConnection connection = null;
//        if (CheckNetworkState.isNetworkAvailable(ctx)) {
        JSONObject obj=null;
        try {
            obj=new JSONObject();
            obj.put("response",response1);
            obj.put("phone",phone);
            URL url = new URL(urlpath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(2000000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
            streamWriter.write(obj.toString());
            streamWriter.flush();
            StringBuilder stringBuilder = new StringBuilder();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String response = null;
                while ((response = bufferedReader.readLine()) != null) {
                    stringBuilder.append(response + "\n");
                }
                bufferedReader.close();
                res = stringBuilder.toString();
            } else {
                res = stringBuilder.toString();
            }
        } catch (Exception exception) {
            res = exception.toString();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
//        } else {
//            Toast.makeText(ctx, "Network problem", Toast.LENGTH_SHORT).show();
//        }
        return res;
    }

    public String callPostApiSend_PayUResponse(String urlpath, String data) {
        String res = "";
        HttpURLConnection connection = null;
//        if (CheckNetworkState.isNetworkAvailable(ctx)) {
        try {
            URL url = new URL(urlpath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(2000000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
            streamWriter.write(data);
            streamWriter.flush();
            StringBuilder stringBuilder = new StringBuilder();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String response = null;
                while ((response = bufferedReader.readLine()) != null) {
                    stringBuilder.append(response + "\n");
                }
                bufferedReader.close();
                res = stringBuilder.toString();
            } else {
                res = stringBuilder.toString();
            }
        } catch (Exception exception) {
            res = exception.toString();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
//        } else {
//            Toast.makeText(ctx, "Network problem", Toast.LENGTH_SHORT).show();
//        }
        return res;
    }

    public static ApiInterface getApiConnection(){
        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        return apiInterface;
    }


}
