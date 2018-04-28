package com.mindorks.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nyamuk on 4/29/18.
 */

public class DosenResponse implements Serializable
{

    @SerializedName("dosen")
    @Expose
    private List<Dosen> dosen = null;
    private final static long serialVersionUID = -1338140333716892814L;

    public List<Dosen> getDosen() {
        return dosen;
    }

    public void setDosen(List<Dosen> dosen) {
        this.dosen = dosen;
    }

}

