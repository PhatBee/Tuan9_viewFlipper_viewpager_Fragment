package vn.phatbee.tuan9_viewflipper_viewpager_fragment.model;

import java.io.Serializable;

public class ImageSlider implements Serializable {
    private int id;
    private int position;
    private String avatar;

    public ImageSlider(int id, int position, String avatar) {
        this.id = id;
        this.position = position;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
