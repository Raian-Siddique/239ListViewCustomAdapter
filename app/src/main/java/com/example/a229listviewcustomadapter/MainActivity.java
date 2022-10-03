package com.example.a229listviewcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView=findViewById(R.id.listView);

        MyAdapter myAdapter= new MyAdapter(); // here new means new memory allocation,

        myListView.setAdapter(myAdapter);



    }

  //====================== Creating an adapter========================

  private class MyAdapter extends BaseAdapter{

      @Override
      public int getCount() {
          return 5;
      }

      @Override
      public Object getItem(int position) {
          return null;
      }

      @Override
      public long getItemId(int position) {
          return 0;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {

          LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View myView = layoutInflater.inflate(R.layout.item, parent,false);
          ImageView imageView =myView.findViewById(R.id.imageView);
          TextView textView = myView.findViewById(R.id.textView);
          TextView textView2 = myView.findViewById(R.id.textView2);

          imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(getApplicationContext(), "Hello\nI am image: "+ position, Toast.LENGTH_SHORT).show();



              }
          });






          return myView;
      }
  }
    //=========== adapter ends here===================

}