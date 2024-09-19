package com.tegshigzugder.explorenote.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Osm3s {
    @JsonProperty("timestamp_osm_base")
    private Date timestampOsmBase;

    @JsonProperty("timestamp_areas_base")
    private Date timestampAreasBase;

    private String copyright;

    public Date getTimestampOsmBase() {
        return timestampOsmBase;
    }

    public void setTimestampOsmBase(Date timestampOsmBase) {
        this.timestampOsmBase = timestampOsmBase;
    }

    public Date getTimestampAreasBase() {
        return timestampAreasBase;
    }

    public void setTimestampAreasBase(Date timestampAreasBase) {
        this.timestampAreasBase = timestampAreasBase;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}