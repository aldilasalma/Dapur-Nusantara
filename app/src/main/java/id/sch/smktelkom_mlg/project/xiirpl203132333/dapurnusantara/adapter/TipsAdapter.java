package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.R;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.activity.TipsFragment;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model.Tips;

/**
 * Created by WINDOWS 8.1 on 22/11/2016.
 */
public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {
    ArrayList<Tips> tipsList;
    ITipsAdapter mITipsAdapter;

    public TipsAdapter(TipsFragment context, ArrayList<Tips> tipsList) {
        this.tipsList = tipsList;
        mITipsAdapter = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tips_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tips tips = tipsList.get(position);
        holder.tvJudul.setText(tips.judul);
        //   holder.tvDeskripsi.setText(tips.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(tips.foto));
    }

    @Override
    public int getItemCount() {
        if (tipsList != null)
            return tipsList.size();
        return 0;
    }


    public interface ITipsAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        // TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            //   tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mITipsAdapter.doClick(getAdapterPosition());
                }
            });

        }

    }
}
