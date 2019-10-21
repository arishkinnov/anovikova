package ru.anovikova.lesson20.dto;

import java.io.Serializable;

public class Source implements Serializable {
    private String Stitle;
      private String slug;
      private String url;
      private int crawl_rate;

    public String getStitle() {
        return Stitle;
    }

    public void setStitle(String stitle) {
        Stitle = stitle;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCrawl_rate() {
        return crawl_rate;
    }

    public void setCrawl_rate(int crawl_rate) {
        this.crawl_rate = crawl_rate;
    }

    @Override
    public String toString() {
        return "Source{" +
                "Stitle='" + Stitle + '\'' +
                ", slug='" + slug + '\'' +
                ", url='" + url + '\'' +
                ", crawl_rate=" + crawl_rate +
                '}';
    }
}
