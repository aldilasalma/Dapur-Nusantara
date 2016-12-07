package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.R;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model.About;

/**
 * Created by WINDOWS 8.1 on 22/11/2016.
 */

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder> {
    ArrayList<About> aboutList;

    public AboutAdapter(ArrayList<About> aboutList) {
        this.aboutList = aboutList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_us, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        About about = aboutList.get(position);
        holder.tvNama.setText(about.nama);
        //   holder.tvDeskripsi.setText(tips.deskripsi);
        holder.tvAbsen.setText(about.absen);
    }

    @Override
    public int getItemCount() {
        if (aboutList != null)
            return aboutList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // ImageView ivFoto;
        TextView tvNama;
        TextView tvAbsen;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.textViewNama);
            tvAbsen = (TextView) itemView.findViewById(R.id.textViewAbsen);


        }

    }
}
