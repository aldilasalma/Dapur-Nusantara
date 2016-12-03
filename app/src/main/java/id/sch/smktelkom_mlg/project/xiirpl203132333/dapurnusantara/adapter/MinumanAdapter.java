package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.R;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model.Minuman;

/**
 * Created by Maulidiyah on 06/11/2016.
 */
public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.ViewHolder> {

    ArrayList<Minuman> minumanList;

    public MinumanAdapter(ArrayList<Minuman> minumanList) {
        this.minumanList = minumanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.minuman_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Minuman minuman = minumanList.get(position);
        holder.tvJudul.setText(minuman.judul);
        // holder.tvLokasi.setText(minuman.lokasi);
        // holder.tvDeskripsi.setText(minuman.deskripsi);
        holder.ivFoto.setImageDrawable(minuman.foto);
    }

    @Override
    public int getItemCount() {
        if (minumanList != null)
            return minumanList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvLokasi;
        // TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvLokasi = (TextView) itemView.findViewById(R.id.textViewLokasi);
            // tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
