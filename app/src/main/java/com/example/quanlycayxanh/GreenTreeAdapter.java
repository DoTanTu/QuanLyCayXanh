package com.example.quanlycayxanh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GreenTreeAdapter extends BaseAdapter {

    private Context context;
    private List<GreenTree> list;

    public GreenTreeAdapter(Context context, List<GreenTree> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int iPosition) {
        return list.get(iPosition);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.customer_tree_item, null);

        }

        TextView tvTenKhoaHoc = view.findViewById(R.id.tv_tenKhoaHoc);
        TextView tvTenThuongGoi = view.findViewById(R.id.tv_tenThuongGoi);
        TextView tvDatTa = view.findViewById(R.id.tv_datTinh);
        TextView tvMauLa = view.findViewById(R.id.tv_mauLa);

        GreenTree cp = list.get(i);
        tvTenKhoaHoc.setText(cp.getTenKhoaHoc());
        tvTenThuongGoi.setText(cp.getTenKhoaHoc());
        tvDatTa.setText(cp.getDatTa());
        tvMauLa.setText(cp.getMauLa());


        return view;
    }
}

