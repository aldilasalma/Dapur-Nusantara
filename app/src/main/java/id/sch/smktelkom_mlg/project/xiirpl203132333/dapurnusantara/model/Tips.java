package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model;

import java.io.Serializable;

/**
 * Created by WINDOWS 8.1 on 22/11/2016.
 */
public class Tips implements Serializable {
    public String judul;
    //public String deskripsi;
    public String foto;

    public Tips(String judul, /*String deskripsi,*/ String foto) {
        this.judul = judul;
        //this.deskripsi = deskripsi;
        this.foto = foto;
    }
}