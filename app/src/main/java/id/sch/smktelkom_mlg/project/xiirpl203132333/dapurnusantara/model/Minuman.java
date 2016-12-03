package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Maulidiyah on 06/11/2016.
 */
public class Minuman {
    public String judul;
    //public String deskripsi;
    public Drawable foto;
    //public String lokasi;

    public Minuman(String judul,/* String lokasiString deskripsi ,*/ Drawable foto) {
        this.judul = judul;
        //  this.deskripsi = deskripsi;
        this.foto = foto;
        // this.lokasi = lokasi;
    }
}
