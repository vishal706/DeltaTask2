package com.example.vishalsingh.delta2task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Vishal Singh on 21-06-2015.
 */

//custom adapter creation
public class MyAdapter extends ArrayAdapter<String> {
    private Context context;
    private int resource;
    private String[] contactName;
    //initialize using constructor
    public MyAdapter(Context context,
                     int resource,
                     String[] contactName) {
        super(context, resource,contactName);
        this.context=context;
        this.resource=resource;
        this.contactName=contactName;
    }
   //now use the getView() method to fill data in each row
    //parameters position-used by adapter to get the index of the row
    //convertView used to increase the efficiency of adapter .Adapter uses the old views to generate new iews efficiently
    //parent used to tell that the layout which is inflated is the listview be cause the parent is listview
    public View getView(int position,View convertView,ViewGroup parent){

        if (convertView==null)//checking if convertView has any View object
        {
            // This a new view we inflate the listview layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout, null);
        }
        TextView contact_name=(TextView) convertView.findViewById(R.id.textview);
        ImageView contact_image=(ImageView) convertView.findViewById(R.id.image);
        contact_name.setText(contactName[position]);//filling data of contact name
        if(position%2==0){
            contact_image.setImageResource(R.drawable.ios);
        }
        else{
            contact_image.setImageResource(R.drawable.windows);
        }

        return convertView;
    }


}
