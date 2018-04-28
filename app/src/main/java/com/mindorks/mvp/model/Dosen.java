package com.mindorks.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by nyamuk on 4/29/18.
 */


public class Dosen implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("is_nik")
    @Expose
    private String isNik;
    @SerializedName("tgl_lahir")
    @Expose
    private String tglLahir;
    @SerializedName("gelar_awal")
    @Expose
    private Object gelarAwal;
    @SerializedName("gelar_akhir")
    @Expose
    private String gelarAkhir;
    @SerializedName("hadir")
    @Expose
    private Object hadir;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("home_base")
    @Expose
    private String homeBase;
    @SerializedName("unitkerja")
    @Expose
    private String unitkerja;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("jabatan_idx")
    @Expose
    private String jabatanIdx;
    @SerializedName("ruangkerja")
    @Expose
    private String ruangkerja;
    @SerializedName("is_aktif")
    @Expose
    private String isAktif;
    @SerializedName("email")
    @Expose
    private String email;
    private final static long serialVersionUID = 897487316161222074L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getIsNik() {
        return isNik;
    }

    public void setIsNik(String isNik) {
        this.isNik = isNik;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Object getGelarAwal() {
        return gelarAwal;
    }

    public void setGelarAwal(Object gelarAwal) {
        this.gelarAwal = gelarAwal;
    }

    public String getGelarAkhir() {
        return gelarAkhir;
    }

    public void setGelarAkhir(String gelarAkhir) {
        this.gelarAkhir = gelarAkhir;
    }

    public Object getHadir() {
        return hadir;
    }

    public void setHadir(Object hadir) {
        this.hadir = hadir;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getHomeBase() {
        return homeBase;
    }

    public void setHomeBase(String homeBase) {
        this.homeBase = homeBase;
    }

    public String getUnitkerja() {
        return unitkerja;
    }

    public void setUnitkerja(String unitkerja) {
        this.unitkerja = unitkerja;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJabatanIdx() {
        return jabatanIdx;
    }

    public void setJabatanIdx(String jabatanIdx) {
        this.jabatanIdx = jabatanIdx;
    }

    public String getRuangkerja() {
        return ruangkerja;
    }

    public void setRuangkerja(String ruangkerja) {
        this.ruangkerja = ruangkerja;
    }

    public String getIsAktif() {
        return isAktif;
    }

    public void setIsAktif(String isAktif) {
        this.isAktif = isAktif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
