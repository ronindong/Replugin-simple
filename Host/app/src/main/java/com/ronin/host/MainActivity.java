package com.ronin.host;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qihoo360.replugin.RePlugin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start_plugin01, btn_start_plugin01_nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start_plugin01 = (Button) findViewById(R.id.btn_start_plugin01);
        btn_start_plugin01_nv = (Button) findViewById(R.id.btn_start_plugin01_nv);
        btn_start_plugin01.setOnClickListener(this);
        btn_start_plugin01_nv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        Intent intent = null;
        if (id == R.id.btn_start_plugin01) {

            intent = RePlugin.createIntent("plugin01", "com.ronin.plugin01.MainActivity");
            intent.putExtra("key_str", "我是来自Host中的Value");
            RePlugin.startActivity(this, intent);

        } else if (id == R.id.btn_start_plugin01_nv) {
            intent = RePlugin.createIntent("plugin01", "com.ronin.plugin01.MainActivity");
            RePlugin.startActivityForResult(this, intent, 0x001);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 0x001) {
                String str = data.getExtras().getString("key_str", "没有返回");
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
