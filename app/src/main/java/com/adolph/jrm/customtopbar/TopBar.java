package com.adolph.jrm.customtopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Adolph on 16/4/12.
 */
public class TopBar extends RelativeLayout {

    private Button leftButton,rightButton;
    private TextView tvTitle;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private LayoutParams leftParams,rightParams,titleParams;

    private topbarClickListener listener;

    public void setOnTopbarClickListener(topbarClickListener listener){
        this.listener = listener;
    }

    public interface topbarClickListener{
        void leftClick();
        void rightClick();
    }


    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.TopBar);

        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor,0);
        leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        leftText = ta.getString(R.styleable.TopBar_leftText);

        rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor,0);
        rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        rightText = ta.getString(R.styleable.TopBar_rightText);

        titleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize1,0);
        titleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor1,0);
        title = ta.getString(R.styleable.TopBar_title1);

        ta.recycle();

        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitle = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(title);
        tvTitle.setGravity(Gravity.CENTER);

        setBackgroundColor(0xFFF59563);

        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftButton,leftParams);

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightButton,rightParams);

        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(tvTitle,titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
    }

    public void setLeftButtonIsVisable(boolean flag){
        if(flag){
            leftButton.setVisibility(View.VISIBLE);
        }else {
            leftButton.setVisibility(View.GONE);
        }
    }
}
