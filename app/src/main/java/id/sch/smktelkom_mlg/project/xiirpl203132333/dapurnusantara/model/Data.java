package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model;

import java.io.Serializable;

/**
 * Created by aldila on 12/3/2016.
 */
public class Data implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String lokasi;
    public String foto;

    public Data(String judul, String deskripsi, String detail, String lokasi, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.lokasi = lokasi;
        this.foto = foto;
    }
}
