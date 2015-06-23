package com.example.vishalsingh.delta2task;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class delta2activity extends ActionBarActivity {
    String[] contactName = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};//contactnames to be displayed
    List<String> contactNameList = new ArrayList<String>(Arrays.asList(contactName));//conversion of string array datatype to List array so as to enable the editing of data
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delta2activity);
        listview = (ListView) findViewById(R.id.listView);
        contactNameList.add("Star");//addition of a contact to contact list
        contactNameList.add("Moon");
        contactNameList.add("Sun");
        contactNameList.add("Pluto");
        contactName=contactNameList.toArray(new String[contactNameList.size()]);//getting the contact added in the string array
        MyAdapter myAdapter = new MyAdapter(this, R.layout.row_layout,contactName);//declaration of adapter
        listview.setAdapter(myAdapter);//giving the adapter the listview to be filled

    }

        //function which decides what happens on toggling uses onClick event handler for toggle
        public void OnToggling(View view) {
            boolean on = ((ToggleButton) view).isChecked();//on is a boolean variable which has the value true if the status of toggle
                                                           //is on and false if status is off
            if (on) {
                contactName=contactNameList.toArray(new String[contactNameList.size()]);//making sure that the changes in data supplied to list
                                                                                       // item is updated if any data is added or subracted in this case
                                                                                       //contact Star is added
                Arrays.sort(contactName);//sorting the contact name string array in ascending order
                MyAdapter myAdapter = new MyAdapter(this, R.layout.row_layout, contactName);
                listview.setAdapter(myAdapter);
            }
            else
            {
                Arrays.sort(contactName);//sorting an array
                List<String> contactNameList = Arrays.asList(contactName);//creating a list of string array
                Collections.reverse(contactNameList);//reversing the list
                contactName = (String[]) contactNameList.toArray();//converting the list to array again
                MyAdapter myAdapter = new MyAdapter(this, R.layout.row_layout, contactName);
                listview.setAdapter(myAdapter);
            }
        }
    //function which decides what happens on toggling uses onClick event handler for button
    public void OnSearching(View view){
        int i=0;
        int k=0;
        Context context = getApplicationContext();//parameter required by the makeText() method
        int duration = Toast.LENGTH_SHORT;//setting the length of duration of toast which is appeared
        CharSequence message;//initializing message for toast
        final EditText simpleEditText = (EditText) findViewById(R.id.editText);
        String strValue = simpleEditText.getText().toString();//extracting the data in edittext and converting it to string  data type
        for(i=0;i<contactNameList.size();i++) {
            if ((strValue.equals(contactName[i]))) {
                k++;
            }
        }
        if (k!=0)
        {
            message="Contact Found:"+strValue;
        }
        else{
            message="MISSING";
        }
        Toast toast = Toast.makeText(context,message, duration);//using the makeText() method to generate toast
        LinearLayout toastLayout = (LinearLayout) toast.getView();//A custom toast layout is made to increase the size of the toast
        TextView toastTV = (TextView) toastLayout.getChildAt(0);
        toastTV.setTextSize(50);
        toast.show();
         }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delta2activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
