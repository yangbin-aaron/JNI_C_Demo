package com.aaron.jnicdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etX = (EditText) findViewById(R.id.et_x);
        final EditText etY = (EditText) findViewById(R.id.et_y);
        final TextView textView = (TextView) findViewById(R.id.tv);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strX = etX.getText().toString().trim();
                String strY = etY.getText().toString().trim();

                if (TextUtils.isEmpty(strX) || TextUtils.isEmpty(strY)) {
                    Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                int intX = Integer.parseInt(strX);
                int intY = Integer.parseInt(strY);
                int result = add(intX, intY);
                textView.setText(String.valueOf(result));

            }
        });
    }

    public native int add(int x, int y);

    static {
        System.loadLibrary("hello-jni");
    }
}
