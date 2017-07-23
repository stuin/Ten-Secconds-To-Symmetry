package com.stuin.tenseconds.Views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.stuin.cleanvisuals.Range;
import com.stuin.cleanvisuals.Settings;
import com.stuin.tenseconds.Drifters.Object;
import com.stuin.tenseconds.Drifters.Plane;
import com.stuin.tenseconds.R;

/**
 * Created by Stuart on 7/23/2017.
 */
public class Background extends Plane {
    public boolean top;

    public Background(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        //Set animation variables
        vertical = true;
        objectLength = 120;
        start = -objectLength;
        speed = new Range(3, 8);
        addTime = 20;
        drawable = new ColorDrawable(R.color.app_layout);

        //Get custom attribute
        top = attributeSet.getAttributeBooleanValue(
                "http://schemas.android.com/apk/res/com.stuin.tenseconds","top",false);

        if(top) speed = new Range(-speed.max, -speed.min);

        post(new Runnable() {
            @Override
            public void run() {
                RelativeLayout layout = (RelativeLayout) getParent();
                setMinimumHeight((layout.getHeight() - layout.findViewById(R.id.Bar_Layout).getHeight()) / 2);
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Setup();
                    }
                }, 100);
            }
        });
    }

    @Override
    public void Setup() {
        super.Setup();
        if(top) start = length;
    }

    @Override
    public void Update() {
        super.Update();
        on = Settings.get("Background");
    }

    @Override
    public Object Add() {
        Object object = super.Add();
        object.setMinimumHeight(objectLength);
        object.setMinimumWidth(objectLength);
        return object;
    }
}
