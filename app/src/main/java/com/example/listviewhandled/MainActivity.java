package com.example.listviewhandled;
import com.example.listviewhandled.MyAdapter;
import com.example.listviewhandled.Day;
import com.example.listviewhandled.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ResourceCursorAdapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);

        listView = findViewById(R.id.listView);

        Day[] days = {
                new Day("1","one", R.drawable.image1),
                new Day("2","two",R.drawable.image2),
                new Day("3","three",R.drawable.image3),
                new Day("4","four",R.drawable.image4),
                new Day("5","five",R.drawable.image5),
                new Day("6","six",R.drawable.image6),
                new Day("7","seven",R.drawable.image7),
                new Day("8","eight",R.drawable.image8),
                new Day("9","nine",R.drawable.image9),
                new Day("10","ten",R.drawable.image10),
                new Day("11","eleven",R.drawable.image11),
                new Day("12","twelve",R.drawable.image12),
                new Day("13","thirteen",R.drawable.image13),
                new Day("14","fourteen",R.drawable.image14)
        };


        ArrayAdapter<Day> arrayAdapter = new MyAdapter(this,R.layout.list_view_item,R.id.textViewName,days);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        //Raw height and width of image
        final  int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth){
            final int halfHeight = height/2;
            final int halfWidth = width/2;

            //Calculate the largest inSampleSize value that is a power of 2 and keeps bith
            //height and width larger than the requested height and width
            while((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth){
                inSampleSize*= 2;
            }
        }
        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
        //First decode with inJustDecodeBounds = true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        //Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth , reqHeight);

        //Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return  BitmapFactory.decodeResource(res, resId, options);
    }




}