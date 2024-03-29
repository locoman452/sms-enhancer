package com.zenkun.smsenhancer.preferences;

import com.zenkun.smsenhancer.service.ReminderService;
import com.zenkun.smsenhancer.util.ManageNotification;

import com.zenkun.smsenhancer.R;
import android.app.AlertDialog;
import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class DialogCheckBoxPreference extends CheckBoxPreference {
    Context context;

    public DialogCheckBoxPreference(Context c) {
        super(c);
        context = c;
    }

    public DialogCheckBoxPreference(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;
    }

    public DialogCheckBoxPreference(Context c, AttributeSet attrs, int defStyle) {
        super(c, attrs, defStyle);
        context = c;
    }

    @Override
    protected void onClick() {
        super.onClick();
        if (isChecked()) {
            new AlertDialog.Builder(context)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(context.getString(R.string.pref_notif_title))
                    .setMessage(context.getString(R.string.pref_notif_enabled_warning))
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
        } else {
            ManageNotification.clearAll(context);
            ReminderService.cancelReminder(context);
        }
    }
}
