package com.stuin.tenseconds.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Stuart on 3/12/2017.
 */
public class Timer extends LinearLayout {
    int time = 1000;

    public Timer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void write(String text) {
        getChildAt(0).setVisibility(GONE);
        getChildAt(1).setVisibility(GONE);

        TextView textView = (TextView) getChildAt(2);
        textView.setText(text);
    }

    Timer clear() {
        ProgressBar progressBar = (ProgressBar) getChildAt(1);
		progressBar.setVisibility(VISIBLE);
        progressBar.setProgress(0);

        TextView textView = (TextView) getChildAt(0);
		textView.setVisibility(VISIBLE);
        textView.setText("0 ");

        textView = (TextView) getChildAt(2);
        textView.setText(" 0");

        return this;
    }
}
