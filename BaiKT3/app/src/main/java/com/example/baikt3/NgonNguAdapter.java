package com.example.baikt3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class NgonNguAdapter extends ArrayAdapter<NgonNgu> {

    private Activity activity;
    private int resource;
    private List<NgonNgu> objects;

    public NgonNguAdapter(@NonNull Activity activity, int resource, @NonNull List<NgonNgu> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) this.activity.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        EditText edtViDu = view.findViewById(R.id.tv_name);

        NgonNgu ngonNgu = this.objects.get(i);

        edtViDu.setText(ngonNgu.getNhapVidu());
        return view;
    }
}
