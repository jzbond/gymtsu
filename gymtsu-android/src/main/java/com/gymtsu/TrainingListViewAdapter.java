package com.gymtsu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

class TrainingListViewAdapter extends BaseExpandableListAdapter {
    private static String SET_INFO = "%3s x %2s";
    private final LayoutInflater inflater;
    private final List<SetGroupRow> groups;

    public TrainingListViewAdapter(Context context, List<SetGroupRow> groups) {
        this.inflater = LayoutInflater.from(context);
        this.groups = groups;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).sets.size();
    }

    @Override
    public SetGroupRow getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public SetRow getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).sets.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.training_listview_group_set_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.exerciseView = (TextView) convertView.findViewById(R.id.exercise_id);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SetGroupRow setGroupRow = getGroup(groupPosition);
        viewHolder.exerciseView.setText(setGroupRow.exercise);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.training_listview_set_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.doneView = (CheckBox) convertView.findViewById(R.id.done_id);
            viewHolder.exerciseView = (TextView) convertView.findViewById(R.id.exercise_id);
            viewHolder.infoView = (TextView) convertView.findViewById(R.id.set_info_id);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SetRow setRow = getChild(groupPosition, childPosition);
        viewHolder.doneView.setChecked(setRow.done);
        viewHolder.exerciseView.setText(setRow.exercise);
        String infoText = String.format(SET_INFO, setRow.weight == 0 ? "" : setRow.weight, setRow.repeatCount);
        viewHolder.infoView.setText(infoText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolder {
        CheckBox doneView;
        TextView exerciseView;
        TextView infoView;
    }
}
