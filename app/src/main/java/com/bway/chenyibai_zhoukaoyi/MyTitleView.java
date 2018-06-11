package com.bway.chenyibai_zhoukaoyi;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyTitleView extends LinearLayout implements View.OnClickListener {


    public MyTitleView(Context context) {
        super(context);
    }

    public MyTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyTitleView);

        String title_text = array.getString(R.styleable.MyTitleView_text_title);

        View view = inflate(context, R.layout.title_layout, this);

        TextView title = view.findViewById(R.id.text_ti);

        title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.text_ti:

                if (OnTextClick != null) {
                    OnTextClick.OnText();

                }
                break;
        }

    }


    public interface OnTextClick {

        void OnText();
    }


    //设置外部访问的方法
    private OnTextClick OnTextClick;

    public void OnTextClick(MyTitleView.OnTextClick OnTextClick) {

        this.OnTextClick = OnTextClick;

    }

}
