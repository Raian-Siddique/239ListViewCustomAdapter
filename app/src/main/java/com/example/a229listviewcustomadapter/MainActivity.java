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

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ListView myListView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView=findViewById(R.id.listView);

//      introducing Hashmap
        hashMap = new HashMap<>();
        hashMap.put( "name", "Jubayer Hossain");
        hashMap.put("mobile","811");
        hashMap.put("email","tom@gmail.com");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "BIl gates");
        hashMap.put("mobile", "233");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "ElonMask");
        hashMap.put("mobile", "699");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "Mahmud");
        hashMap.put("mobile", "6889");
        arrayList.add(hashMap);


        MyAdapter myAdapter= new MyAdapter(); // here new means new memory allocation,
        myListView.setAdapter(myAdapter);



    }

  //====================== Creating an adapter========================

  private class MyAdapter extends BaseAdapter{

      @Override
      public int getCount() {
          return arrayList.size();
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
          TextView tvName = myView.findViewById(R.id.tvName);
          TextView tvMobile = myView.findViewById(R.id.tvMobile);


          HashMap<String, String> hashMap = arrayList.get(position);

          String name = hashMap.get("name");
          String mobile = hashMap.get("mobile");

          tvName.setText(name);
          tvMobile.setText(mobile);




          imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(getApplicationContext(), "Hello\n "+ name, Toast.LENGTH_SHORT).show();



              }
          });






          return myView;
      }
  }
    //=========== adapter ends here===================

}