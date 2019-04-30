package com.map.constant;

public enum PoiSearchType {

    School("学校"),
    Market("商场"),
    Building("楼宇"),
    Residence("住宅"),
    Other("");

    public final String key;

    PoiSearchType(String key) {
        this.key = key;
    }
}
