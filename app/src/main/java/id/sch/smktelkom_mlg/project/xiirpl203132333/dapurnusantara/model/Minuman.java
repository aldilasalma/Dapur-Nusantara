package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model;

import java.io.Serializable;

/**
 * Created by Maulidiyah on 06/11/2016.
 */
public class Minuman implements Serializable {
    public String judul;
    public String deskripsi;
    public String foto;
    //public String lokasi;

    public Minuman(String judul,/* String lokasi  String deskripsi ,*/ String foto) {
        this.judul = judul;
        //   this.deskripsi = deskripsi;
        this.foto = foto;
        // this.lokasi = lokasi;
    }
}
