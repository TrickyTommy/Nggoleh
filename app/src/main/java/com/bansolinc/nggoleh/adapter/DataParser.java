//package com.bansolinc.nggoleh.adapter;
//
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.os.AsyncTask;
//import android.widget.ListView;
//import android.widget.Toast;
//
////import com.bansolinc.nggoleh.CustomadapterActivity;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//public class DataParser  extends AsyncTask<Void,Void,Integer>{
//
//    Context c;
//    ListView lv;
//    String jsonData;
//
//    ProgressDialog pd;
//    ArrayList<adaptertoko> adaptertoko=new ArrayList<>();
//
//    public DataParser(Context c, ListView lv, String jsonData) {
//        this.c = c;
//        this.lv = lv;
//        this.jsonData = jsonData;
//    }
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//
//        pd=new ProgressDialog(c);
//        pd.setTitle("Parse");
//        pd.setMessage("Parsing...Please wait");
//        pd.show();
//    }
//
//    @Override
//    protected Integer doInBackground(Void... params) {
//        return this.parseData();
//    }
//
//    @Override
//    protected void onPostExecute(Integer result) {
//        super.onPostExecute(result);
//
//        pd.dismiss();
//        if(result==0)
//        {
//            Toast.makeText(c,"Unable to parse",Toast.LENGTH_SHORT).show();
//        }else {
//            //CALL ADAPTER TO BIND DATA
//            CustomadapterActivity adapter=new CustomadapterActivity(c,adaptertoko);
//            lv.setAdapter(adapter);
//        }
//    }
//
//    private int parseData()
//    {
//        try {
//            JSONArray ja=new JSONArray(jsonData);
//            JSONObject jo=null;
//
//            adaptertoko.clear();
//            adaptertoko s=null;
//
//            for(int i=0;i<ja.length();i++)
//            {
//                jo=ja.getJSONObject(i);
//
//                int id=jo.getInt("id");
//                String name=jo.getString("name");
//                String nama_umkm=jo.getString("nama_umkm");
//                String hasil_produksi=jo.getString("hasil_produksi");
//
//                s=new adaptertoko();
//                s.setId(id);
//                s.setName(name);
//                s.setNama_umkm(nama_umkm);
//                s.setHasil_produksi(hasil_produksi);
//
//                adaptertoko.add(s);
//
//            }
//
//            return 1;
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return 0;
//    }
//}