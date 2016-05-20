package com.example.ajb_1407.testcontentprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.bt);
        tv = (TextView) findViewById(R.id.tv);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("haha", "before a");
                Uri uri = Uri.parse("content://com.example.ajb_1407.contentprovidertest.provider/Book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "George Martin");
                values.put("pages", 1040);
                values.put("price", 22.85);
                Log.e("haha", "aaa");
                Uri newUri = getContentResolver().insert(uri, values);

                String newId = newUri.getPathSegments().get(1);
                tv.setText(newId);
            }
        });
    }
}
