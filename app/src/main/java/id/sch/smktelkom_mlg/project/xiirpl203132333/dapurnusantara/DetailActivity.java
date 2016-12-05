package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.activity.HomeFragment;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model.Resep;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Resep resep = (Resep) getIntent().getSerializableExtra(HomeFragment.RESEP);
        setTitle(resep.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(resep.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.place_detail);
        tvDeskripsi.setText(resep.judul + "\n\n" + resep.deskripsi);
        TextView tvLokasi = (TextView) findViewById(R.id.place_location);
        tvLokasi.setText(resep.lokasi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}

