package com.ronin.plugin01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String str = extras.getString("key_str", "居然，没有传值");
            textView.setText(str);
        }


    }

    public void doClose(View v) {
        Intent intent = new Intent();
        intent.putExtra("key_str", "返回值给host");
        setResult(RESULT_OK, intent);
        finish();
    }


}
