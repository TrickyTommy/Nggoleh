package com.bansolinc.nggoleh;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

/**
 * Created by jaiso on 13-02-2018.
 */

public class CustomListView extends ArrayAdapter<String> {

    //    private String[] id;
//    private String[] nama_umkm;
//    private String[] hasil_produksi;
//    private String[] imagepath;
//    private Activity context;
//    Bitmap bitmap;
    private String[] id_hewan;
    private String[] nama_kategori;
    private String[] harga_beli;
    private String[] bobot_beli;
    private String[] tinggi_hewan;
    private String[] jenis_kelamin;
    private String[] tanggal_beli;
    private Activity context;

    public CustomListView(Activity context, String[] id_hewan, String[] nama_kategori, String[] harga_beli, String[] id, String[] nama_umkm, String[] hasil_produksi, String[] imagepath) {
        super(context, R.layout.layout, id);
        this.context = context;
//        this.id = id;
//        this.nama_umkm = nama_umkm;
//        this.hasil_produksi = hasil_produksi;
//        this.imagepath = imagepath;
        this.nama_kategori = nama_kategori;
        this.id_hewan = id_hewan;
        this.harga_beli = harga_beli;
        this.bobot_beli = bobot_beli;
        this.tinggi_hewan = tinggi_hewan;
        this.jenis_kelamin = jenis_kelamin;
        this.tanggal_beli = tanggal_beli;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();

        }

//        viewHolder.tvw1.setText(nama_umkm[position]);
//        viewHolder.tvw2.setText(hasil_produksi[position]);
//        new GetImageFromURL(viewHolder.ivw).execute(imagepath[position]);
        viewHolder.tvw1.setText(nama_kategori[position]);
        viewHolder.tvw2.setText(harga_beli[position]);
//        viewHolder.viewbobot_beli.setText(bobot_beli[position]);
//        viewHolder.viewtinggi_hewan.setText(tinggi_hewan[position]);
//        viewHolder.viewjenis_kelamin.setText(jenis_kelamin[position]);
//        viewHolder.viewtanggal_beli.setText(tanggal_beli[position]);


        return r;
    }

    class ViewHolder {

        TextView tvw1;
        TextView tvw2;
//        ImageView ivw;

        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.tvprofilename);
            tvw2 = (TextView) v.findViewById(R.id.tvemail);
//            ivw = (ImageView) v.findViewById(R.id.imageView);
        }

    }

//    public class GetImageFromURL extends AsyncTask<String, Void, Bitmap> {
//
//        ImageView imgView;
//
//        public GetImageFromURL(ImageView imgv) {
//            this.imgView = imgv;
//        }
//
//        @Override
//        protected Bitmap doInBackground(String... url) {
//            String urldisplay = url[0];
//            bitmap = null;
//
//            try {
//
//                InputStream ist = new java.net.URL(urldisplay).openStream();
//                bitmap = BitmapFactory.decodeStream(ist);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//            return bitmap;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//
//            super.onPostExecute(bitmap);
//            imgView.setImageBitmap(bitmap);
//        }
//    }


}
