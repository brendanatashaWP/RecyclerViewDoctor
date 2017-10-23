package models;

/**
 * Created by Brenda on 23/10/2017.
 */

public class Doctor {
    private String nama, spesialisasi, alamat, urlfoto;;
    private int nia;

    public Doctor(int nia, String nama, String spesialisasi, String alamat, String urlfoto){
        this.nia = nia;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.alamat = alamat;
        this.urlfoto = urlfoto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }
}
