// Generated code from Butter Knife. Do not modify!
package com.smartlife.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DetailTaskFragment$$ViewInjector {
  public static void inject(Finder finder, final com.smartlife.fragment.DetailTaskFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296323, "field 'mEndDateTv'");
    target.mEndDateTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296324, "field 'mStartTimeTv'");
    target.mStartTimeTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296321, "field 'mTaskTitle'");
    target.mTaskTitle = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296322, "field 'mStartDateTv'");
    target.mStartDateTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296320, "field 'mTaskContent'");
    target.mTaskContent = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296325, "field 'mEndTimeTv'");
    target.mEndTimeTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296327, "field 'mFrequenceTv'");
    target.mFrequenceTv = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296326, "field 'mIsRemindSwitch'");
    target.mIsRemindSwitch = (android.widget.Switch) view;
  }

  public static void reset(com.smartlife.fragment.DetailTaskFragment target) {
    target.mEndDateTv = null;
    target.mStartTimeTv = null;
    target.mTaskTitle = null;
    target.mStartDateTv = null;
    target.mTaskContent = null;
    target.mEndTimeTv = null;
    target.mFrequenceTv = null;
    target.mIsRemindSwitch = null;
  }
}
