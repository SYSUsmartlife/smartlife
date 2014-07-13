// Generated code from Butter Knife. Do not modify!
package com.smartlife.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CreateTaskFragment$$ViewInjector {
  public static void inject(Finder finder, final com.smartlife.fragment.CreateTaskFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296322, "field 'mStartDateTv'");
    target.mStartDateTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296326, "field 'mIsRemindSwitch'");
    target.mIsRemindSwitch = (android.widget.Switch) view;
    view = finder.findRequiredView(source, 2131296325, "field 'mEndTimeTv'");
    target.mEndTimeTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296320, "field 'mTaskContent'");
    target.mTaskContent = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131296327, "field 'mFrequenceTv'");
    target.mFrequenceTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296321, "field 'mTaskTitle'");
    target.mTaskTitle = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131296323, "field 'mEndDateTv'");
    target.mEndDateTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296324, "field 'mStartTimeTv'");
    target.mStartTimeTv = (android.widget.TextView) view;
  }

  public static void reset(com.smartlife.fragment.CreateTaskFragment target) {
    target.mStartDateTv = null;
    target.mIsRemindSwitch = null;
    target.mEndTimeTv = null;
    target.mTaskContent = null;
    target.mFrequenceTv = null;
    target.mTaskTitle = null;
    target.mEndDateTv = null;
    target.mStartTimeTv = null;
  }
}
