package id.sch.smktelkom_mlg.project.xirpl203132333.dapurnusantara.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl203132333.dapurnusantara.R;
import id.sch.smktelkom_mlg.project.xirpl203132333.dapurnusantara.model.Resep;

/**
 * Created by Maulidiyah on 06/11/2016.
 */
public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ViewHolder> {

    ArrayList<Resep> resepList;

    public ResepAdapter(ArrayList<Resep> resepList) {
        this.resepList = resepList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Resep resep = resepList.get(position);
        holder.tvJudul.setText(resep.judul);
        // holder.tvDeskripsi.setText(resep.deskripsi);
        holder.ivFoto.setImageDrawable(resep.foto);
    }

    @Override
    public int getItemCount() {
        if (resepList != null)
            return resepList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        // TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            // tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
