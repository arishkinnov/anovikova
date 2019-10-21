package ru.anovikova.lesson20.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ResponseFields implements Serializable {
    ConsolidatedWeather[] consolidated_weather;
    private String time;
    private String sun_rise;
    private String sun_set;
    private String timezone_name;
    private String title;
    private String location_type;
    private int woeid;
    private String latt_long;
    private String timezone;

    Location parent;

    Source[] sources;

    public ConsolidatedWeather[] getConsolidated_weather() {
        return consolidated_weather;
    }

    public void setConsolidated_weather(ConsolidatedWeather[] consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSun_rise() {
        return sun_rise;
    }

    public void setSun_rise(String sun_rise) {
        this.sun_rise = sun_rise;
    }

    public String getSun_set() {
        return sun_set;
    }

    public void setSun_set(String sun_set) {
        this.sun_set = sun_set;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public int getWoeid() {
        return woeid;
    }

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Location getParent() {
        return parent;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "ResponseFields{" +
                "consolidated_weather=" + Arrays.toString(consolidated_weather) +
                ", time='" + time + '\'' +
                ", sun_rise='" + sun_rise + '\'' +
                ", sun_set='" + sun_set + '\'' +
                ", timezone_name='" + timezone_name + '\'' +
                ", title='" + title + '\'' +
                ", location_type='" + location_type + '\'' +
                ", woeid=" + woeid +
                ", latt_long='" + latt_long + '\'' +
                ", timezone='" + timezone + '\'' +
                ", parent=" + parent +
                ", sources=" + Arrays.toString(sources) +
                '}';
    }
}
