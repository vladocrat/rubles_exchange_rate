package com.rubles_exchange_rate.giphyApi;

import com.google.gson.annotations.SerializedName;

public class GifDTO {
    @SerializedName("type")
    private String type;

    @SerializedName("id")
    private String id;

    @SerializedName("images")
    private Images images;

    @SerializedName("url")
    private String url;

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public GifDTO() {

    }
    public GifDTO(String type, String id, String url) {
        this.type = type;
        this.id = id;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
