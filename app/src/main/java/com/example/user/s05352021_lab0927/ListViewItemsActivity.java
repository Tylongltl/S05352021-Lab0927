package com.example.user.s05352021_lab0927;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class ListViewItemsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_items);

        TextView T_name = (TextView) findViewById(R.id.textView_name);
        T_name.setTextSize(24.0f);
        T_name.setTypeface(null, Typeface.BOLD);
    }
}
