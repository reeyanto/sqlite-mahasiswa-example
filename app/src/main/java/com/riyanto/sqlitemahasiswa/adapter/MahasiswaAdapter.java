package com.riyanto.sqlitemahasiswa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.riyanto.sqlitemahasiswa.R;
import com.riyanto.sqlitemahasiswa.model.Mahasiswa;

import java.util.List;

public class MahasiswaAdapter extends BaseAdapter {

    private Context context;
    private List<Mahasiswa> mahasiswaList;

    public MahasiswaAdapter(Context context, List<Mahasiswa> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    @Override
    public int getCount() {
        return mahasiswaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mahasiswaList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View x = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        TextView tvNim = x.findViewById(R.id.tv_nim);
        TextView tvNama = x.findViewById(R.id.tv_nama);
        TextView tvProdi = x.findViewById(R.id.tv_prodi);

        tvNim.setText(mahasiswaList.get(i).getNim());
        tvNama.setText(mahasiswaList.get(i).getNama());
        tvProdi.setText(mahasiswaList.get(i).getProdi());

        return x;
    }
}
