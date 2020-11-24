package com.example.list_view_custom.Use;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.list_view_custom.MainActivity;
import com.example.list_view_custom.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapterDoiTuong  extends BaseAdapter {
    private Context context ;
    private int layout;
    private List<doiTuong> doiTuongList;

    public adapterDoiTuong() {
    }

    public adapterDoiTuong(Context context, int layout, List<doiTuong> doiTuongList) {
        this.context = context;
        this.layout = layout;
        this.doiTuongList = doiTuongList;
    }

    @Override
    public int getCount() {
        return doiTuongList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        CircleImageView imageProfile  = view.findViewById(R.id.imageProfile);
        TextView tieude = view.findViewById(R.id.tvTitle);
        TextView conten = view.findViewById(R.id.tv_conten);

        doiTuong dt  = doiTuongList.get(i);
        tieude.setText(dt.getTite());
        conten.setText(dt.getConten());
        String anh  = dt.getImage().toString();
        Picasso.get().load(anh).into(imageProfile);

        return  view;

    }
}
