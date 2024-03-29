package com.zenkun.smsenhancer.preferences;

import com.zenkun.smsenhancer.util.SmsPopupUtils;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class AppEnabledCheckBoxPreference extends CheckBoxPreference {
    private Context context;

    public AppEnabledCheckBoxPreference(Context c, AttributeSet attrs, int defStyle) {
        super(c, attrs, defStyle);
        context = c;
    }

    public AppEnabledCheckBoxPreference(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;
    }

    public AppEnabledCheckBoxPreference(Context c) {
        super(c);
        context = c;
    }

    @Override
    protected void onClick() {
        super.onClick();
        SmsPopupUtils.enableSmsPopup(context, isChecked());
    }
}
