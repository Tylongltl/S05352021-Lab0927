package com.example.user.s05352021_lab0927;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    //initialize view's
    ListView simpleListView;
    String[] animalName={"奶油獅","懶惰虎","無奈猴","月月狗","胖橘貓","長鼻象"};//animal names array
    String[] animalHabit={"吃甜甜圈","睡懶覺","無奈的看著你","跟你討骨頭","吃好吃滿","悠然漫步"};//animal names array
    int[] animalImages={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};//animal images array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //設定Listview
        simpleListView=(ListView)findViewById(R.id.simpleListView);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<animalName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",animalName[i]);
            hashMap.put("image",animalImages[i]+"");
            hashMap.put("habit",animalHabit[i]);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","image","habit"};//string array
        int[] to={R.id.textView_name,R.id.imageView,R.id.textView_habit};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //設定 listView1 被按一下的監聽器
        simpleListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),animalName[position],Toast.LENGTH_LONG).show();//show the selected image in toast according to position
        Intent it = new Intent(this, EditActivity.class);
        it.putExtra("編號", position+1);      //附加編號
        it.putExtra("備忘", animalHabit[position]); //附加備忘項目的內容
        startActivityForResult(it, position); //啟動 Edit 並以項目位置為識別碼
    }

    //讀取備忘
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //讀取備忘
        Toast.makeText(getApplicationContext(), data.getStringExtra("備忘"),Toast.LENGTH_LONG).show();//show the selected image in toast according to position
        animalHabit[requestCode] = data.getStringExtra("備忘");

        //重設ListView
        simpleListView=(ListView)findViewById(R.id.simpleListView);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<animalName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",animalName[i]);
            hashMap.put("image",animalImages[i]+"");
            hashMap.put("habit",animalHabit[i]);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","image","habit"};//string array
        int[] to={R.id.textView_name,R.id.imageView,R.id.textView_habit};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

    }
}