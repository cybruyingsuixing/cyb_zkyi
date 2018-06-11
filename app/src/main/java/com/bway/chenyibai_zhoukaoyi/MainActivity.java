package com.bway.chenyibai_zhoukaoyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyTitleView mytitle;
    private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        mytitle = findViewById(R.id.mytitle);

        mytitle.OnTextClick(new MyTitleView.OnTextClick() {
            @Override
            public void OnText() {
                Toast.makeText(MainActivity.this, "大家都在搜", Toast.LENGTH_SHORT).show();
            }
        });

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
        t7.setOnClickListener(this);
        t8.setOnClickListener(this);
        t9.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.t1:
                Toast.makeText(MainActivity.this, "面试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.t2:
                Toast.makeText(MainActivity.this, "Studio3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.t3:
                Toast.makeText(MainActivity.this, "自定义View", Toast.LENGTH_SHORT).show();
                break;
            case R.id.t4:
                Toast.makeText(MainActivity.this, "性能化  速度", Toast.LENGTH_SHORT).show();
                break;
            case R.id.t5:
                Toast.makeText(MainActivity.this, "面试", Toast.LENGTH_SHORT).show();
                break;

            case R.id.t6:
                Toast.makeText(MainActivity.this, "gradle", Toast.LENGTH_SHORT).show();
                break;

            case R.id.t7:
                Toast.makeText(MainActivity.this, "Camera 相机", Toast.LENGTH_SHORT).show();
                break;

            case R.id.t8:
                Toast.makeText(MainActivity.this, "代码混淆 安全", Toast.LENGTH_SHORT).show();
                break;

            case R.id.t9:
                Toast.makeText(MainActivity.this, "逆向  加固", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
