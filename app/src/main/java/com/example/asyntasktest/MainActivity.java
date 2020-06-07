package com.example.asyntasktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new arkaplan().execute();
    }

    //ilk void doinbackgroun metodunun parametre tipi
    //üçüncü parametre doinbackgroun metodunun  tipi.
    //ikinci parametrede onprogress update için
    public class arkaplan extends AsyncTask<Void,String,Void>{

        //işlem öncesi çalışacakları buraya
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0 ; i<10000;i++){
                publishProgress(String.valueOf(i));//onprogresupdate e veri gönderir.
            }

            return null;
        }

        //işlemin durumunun takip edilmesini sağlayan metod.
        @Override
        protected void onProgressUpdate(String... values) {
            String idegeri = values[0];
            Log.i("i degeri ", idegeri);
            super.onProgressUpdate(values);
        }

        //arka plan işlemi bitince çalıştırılacaklar
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        //arka plan işlemi iptal edilirse çalıştırılacakları buraya...
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}