package com.example.list_view_custom.Use;

import android.widget.ImageView;

public class doiTuong {
    private String tite , conten , image;


    public doiTuong() {
    }

    public doiTuong(String tite, String conten, String image) {
        this.tite = tite;
        this.conten = conten;
        this.image = image;
    }

    public String getTite() {
        return tite;
    }

    public void setTite(String tite) {
        this.tite = tite;
    }

    public String getConten() {
        return conten;
    }

    public void setConten(String conten) {
        this.conten = conten;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
