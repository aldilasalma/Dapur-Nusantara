package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Maulidiyah on 06/11/2016.
 */
public class Resep {
    public String judul;
    public String lokasi;
    //public String deskripsi;
    public Drawable foto;

    public Resep(String judul, String lokasi, /*String deskripsi ,*/ Drawable foto) {
        this.judul = judul;
        this.lokasi = lokasi;
        //  this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
