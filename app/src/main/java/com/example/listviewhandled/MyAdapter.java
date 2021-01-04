package com.example.listviewhandled;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewhandled.Day;
import com.example.listviewhandled.MainActivity;

public class MyAdapter extends ArrayAdapter<Day> {

    Day[] dayArray;
    int res;
    public MyAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Day[] days) {
        super(context, resource, textViewResourceId, days);
        dayArray = days;
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if(view==null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_view_item, parent, false);


            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }


        viewHolder.getTextViewName().setText(dayArray[position].getDayName());
        viewHolder.getTextViewDescription().setText(dayArray[position].getDayDescription());
        viewHolder.getImageView().setImageResource(dayArray[position].imageResourceID);
        //viewHolder.getImageView().setImageBitmap(MainActivity.decodeSampledBitmapFromResource(view.getResources(),dayArray[position].getImageResourceID(),100,100));


        return  view;
    }



    class ViewHolder{
        View view;
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        ViewHolder(View v){
            view = v;
        }

        public TextView getTextViewName(){
            if(textViewName == null){
                textViewName = view.findViewById(R.id.textViewName);
            }
            return textViewName;
        }
        public TextView getTextViewDescription(){
            if(textViewDescription == null){
                textViewDescription = view.findViewById(R.id.textViewDescription);
            }
            return textViewDescription;
        }
        public ImageView getImageView(){
            if(imageView == null){
                imageView = view.findViewById(R.id.imageView);

            }
            return imageView;
        }

    }
}
