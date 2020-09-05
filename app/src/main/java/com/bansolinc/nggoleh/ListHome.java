package com.bansolinc.nggoleh;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

//import com.android.volley.Request;
import com.android.volley.RequestQueue;
//import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ListHome extends AppCompatActivity {

    String urladdress = "http://192.168.43.153/connectandroid/includes/tampilpembelian.php";
    //    String[] id;
//    String[] nama_umkm;
//    String[] hasil_produksi;
//    String[] imagepath;
    String[] id_hewan;
    String[] nama_kategori;
    String[] harga_beli;
    String[] bobot_beli;
    String[] tinggi_hewan;
    String[] jenis_kelamin;
    String[] tanggal_beli;
    ListView listView;
    BufferedInputStream is;
    String line = null;
    String result = null;
    private final OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_home_activity);

        listView = (ListView) findViewById(R.id.lview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        collectData();
        //CustomListView customListView=new CustomListView(this,id,nama_umkm,hasil_produksi,imagepath);
        CustomListView customListView = new CustomListView(this, id_hewan, nama_kategori, harga_beli, bobot_beli, tinggi_hewan, jenis_kelamin, tanggal_beli);
        listView.setAdapter(customListView);

    }


    private void collectData() {
//Connection
        try {

            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            is = new BufferedInputStream(con.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //content
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

//JSON
        try {
            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;
//            id=new String[ja.length()];
//            nama_umkm=new String[ja.length()];
//            hasil_produksi=new String[ja.length()];
//            imagepath=new String[ja.length()];
            id_hewan = new String[ja.length()];
            nama_kategori = new String[ja.length()];
            harga_beli = new String[ja.length()];
            bobot_beli = new String[ja.length()];
            tinggi_hewan = new String[ja.length()];
            jenis_kelamin = new String[ja.length()];
            tanggal_beli = new String[ja.length()];

            for (int i = 0; i <= ja.length(); i++) {
                jo = ja.getJSONObject(i);
//                id[i]=jo.getString("id");
//                nama_umkm[i]=jo.getString("nama_umkm");
//                hasil_produksi[i]=jo.getString("hasil_produksi");
//                imagepath[i]=jo.getString("foto");
                id_hewan[i] = jo.getString("id_hewan");
                nama_kategori[i] = jo.getString("nama_kategori");
                harga_beli[i] = jo.getString("harga_beli");
                bobot_beli[i] = jo.getString("bobot_beli");
                tinggi_hewan[i] = jo.getString("tinggi_hewan");
                jenis_kelamin[i] = jo.getString("jenis_kelamin");
                tanggal_beli[i] = jo.getString("tanggal_beli");

            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
}
