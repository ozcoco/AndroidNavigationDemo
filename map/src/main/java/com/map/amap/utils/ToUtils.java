package com.map.amap.utils;

import com.amap.api.services.geocoder.RegeocodeAddress;
import com.map.entity.Address;
import com.map.entity.IndoorData;
import com.map.entity.LatLngPoint;
import com.map.entity.Location;
import com.map.entity.Photo;
import com.map.entity.PoiItem;
import com.map.entity.PoiItemExtension;
import com.map.entity.SubPoiItem;
import com.map.entity.Tip;

import java.util.ArrayList;
import java.util.List;

public class ToUtils {

    public static List to(List src) {

        assert src != null;

        List list = new ArrayList<>();

        int len = src.size();

        for (int i = 0; i < len; i++) {

            if (src.get(i) instanceof com.amap.api.services.poisearch.Photo) {

                list.add(to((com.amap.api.services.poisearch.Photo) src.get(i)));

            } else if (src.get(i) instanceof Photo) {

                list.add(to((Photo) src.get(i)));

            } else if (src.get(i) instanceof com.amap.api.services.core.LatLonPoint) {

                list.add(to((com.amap.api.services.core.LatLonPoint) src.get(i)));

            } else if (src.get(i) instanceof LatLngPoint) {

                list.add(to((LatLngPoint) src.get(i)));
            } else if (src.get(i) instanceof com.amap.api.services.help.Tip) {

                list.add(to((com.amap.api.services.help.Tip) src.get(i)));
            } else if (src.get(i) instanceof Tip) {

                list.add(to((Tip) src.get(i)));
            } else if (src.get(i) instanceof com.amap.api.services.core.PoiItem) {

                list.add(to((com.amap.api.services.core.PoiItem) src.get(i)));
            } else if (src.get(i) instanceof SubPoiItem) {

                list.add(to((SubPoiItem) src.get(i)));
            } else if (src.get(i) instanceof com.amap.api.services.poisearch.SubPoiItem) {

                list.add(to((com.amap.api.services.poisearch.SubPoiItem) src.get(i)));
            } else if (src.get(i) instanceof IndoorData) {

                list.add(to((IndoorData) src.get(i)));
            } else if (src.get(i) instanceof com.amap.api.services.poisearch.IndoorData) {

                list.add(to((com.amap.api.services.poisearch.IndoorData) src.get(i)));
            } else if (src.get(i) instanceof PoiItemExtension) {

                list.add(to((PoiItemExtension) src.get(i)));
            } else if (src.get(i) instanceof RegeocodeAddress) {

                list.add(to((RegeocodeAddress) src.get(i)));
            } else if (src.get(i) instanceof android.location.Location) {

                list.add(to((android.location.Location) src.get(i)));
            }

        }

        return list;
    }

    public static Location to(android.location.Location src) {

        assert src != null;

        final Location bean = new Location();

        bean.setAltitude(src.getAltitude());

        bean.setBearing(src.getBearing());

        bean.setElapsedRealtimeNanos(src.getElapsedRealtimeNanos());

        bean.setLatitude(src.getLatitude());

        bean.setLongitude(src.getLongitude());

        bean.setSpeed(src.getSpeed());

        bean.setTime(src.getTime());

        return bean;
    }


    public static Address to(RegeocodeAddress src) {

        assert src != null;

        final Address bean = new Address();

        bean.setAdCode(src.getAdCode());

        bean.setBuilding(src.getBuilding());

        bean.setCity(src.getCity());

        bean.setCityCode(src.getCityCode());

        bean.setCountry(src.getCountry());

        bean.setDistrict(src.getDistrict());

        bean.setFormatAddress(src.getFormatAddress());

        bean.setNeighborhood(src.getNeighborhood());

        bean.setProvince(src.getProvince());

        bean.setTowncode(src.getTowncode());

        bean.setTownship(bean.getTownship());

        return bean;
    }


    public static Photo to(com.amap.api.services.poisearch.Photo src) {

        assert src != null;

        return new Photo(src.getTitle(), src.getUrl());
    }


    public static com.amap.api.services.poisearch.Photo to(Photo src) {

        assert src != null;

        return new com.amap.api.services.poisearch.Photo(src.getTitle(), src.getUrl());
    }


    public static LatLngPoint to(com.amap.api.services.core.LatLonPoint src) {

        assert src != null;

        return new LatLngPoint(src.getLatitude(), src.getLongitude());
    }

    public static com.amap.api.services.core.LatLonPoint to(LatLngPoint src) {

        assert src != null;

        return new com.amap.api.services.core.LatLonPoint(src.getLatitude(), src.getLongitude());
    }


    public static Tip to(com.amap.api.services.help.Tip src) {

        assert src != null;

        final Tip bean = new Tip();

        bean.setAdcode(src.getAdcode());

        bean.setAddress(src.getAddress());

        bean.setDistrict(src.getDistrict());

        bean.setName(src.getName());

        bean.setPoiID(src.getPoiID());

        bean.setPoint(to(src.getPoint()));

        bean.setTypeCode(src.getTypeCode());

        return bean;
    }


    public static com.amap.api.services.help.Tip to(Tip src) {

        assert src != null;

        final com.amap.api.services.help.Tip bean = new com.amap.api.services.help.Tip();

        bean.setAdcode(src.getAdcode());

        bean.setAddress(src.getAddress());

        bean.setDistrict(src.getDistrict());

        bean.setName(src.getName());

        bean.setTypeCode(src.getTypeCode());

        return bean;
    }


    public static SubPoiItem to(com.amap.api.services.poisearch.SubPoiItem src) {

        assert src != null;

        final SubPoiItem bean = new SubPoiItem();

        bean.setDistance(src.getDistance());

        bean.setPoiId(src.getPoiId());

        bean.setPoint(to(src.getLatLonPoint()));

        bean.setSnippet(src.getSnippet());

        bean.setSubName(src.getSubName());

        bean.setSubTypeDes(src.getSubTypeDes());

        bean.setTitle(src.getTitle());

        return bean;
    }

    public static com.amap.api.services.poisearch.SubPoiItem to(SubPoiItem src) {

        assert src != null;

        return new com.amap.api.services.poisearch.SubPoiItem(src.getPoiId(),
                to(src.getPoint()),
                src.getTitle(),
                src.getSnippet());
    }


    public static IndoorData to(com.amap.api.services.poisearch.IndoorData src) {

        assert src != null;

        final IndoorData bean = new IndoorData();

        bean.setFloor(src.getFloor());

        bean.setFloorName(src.getFloorName());

        bean.setPoiId(src.getPoiId());

        return bean;
    }

    public static com.amap.api.services.poisearch.IndoorData to(IndoorData src) {

        assert src != null;

        return new com.amap.api.services.poisearch.IndoorData(src.getPoiId(), src.getFloor(), src.getFloorName());
    }


    public static PoiItemExtension to(com.amap.api.services.poisearch.PoiItemExtension src) {

        assert src != null;

        final PoiItemExtension bean = new PoiItemExtension();

        bean.setOpentime(src.getOpentime());

        bean.setRating(src.getmRating());

        return bean;
    }


    public static com.amap.api.services.poisearch.PoiItemExtension to(PoiItemExtension src) {

        assert src != null;

        return new com.amap.api.services.poisearch.PoiItemExtension(src.getOpentime(), src.getRating());
    }


    public static PoiItem to(com.amap.api.services.core.PoiItem src) {

        assert src != null;

        final PoiItem bean = new PoiItem();

        bean.setAdCode(src.getAdCode());

        bean.setAdName(src.getAdName());

        bean.setBusinessArea(src.getBusinessArea());

        bean.setCityCode(src.getCityCode());

        bean.setCityName(src.getCityName());

        bean.setDirection(src.getDirection());

        bean.setDistance(src.getDistance());

        bean.setEmail(src.getEmail());

        bean.setIndoorMap(src.isIndoorMap());

        bean.setParkingType(src.getParkingType());

        bean.setPoiId(src.getPoiId());

        bean.setPostcode(src.getPostcode());

        bean.setProvinceCode(src.getProvinceCode());

        bean.setProvinceName(src.getProvinceName());

        bean.setShopID(src.getShopID());

        bean.setTel(src.getTel());

        bean.setSnippet(src.getSnippet());

        bean.setTitle(src.getTitle());

        bean.setTypeCode(src.getTypeCode());

        bean.setTypeDes(src.getTypeDes());

        bean.setWebsite(src.getWebsite());

        bean.setEnter(to(src.getEnter()));

        bean.setEnter(to(src.getExit()));

        bean.setPoint(to(src.getLatLonPoint()));

        bean.setPhotos(to(src.getPhotos()));

        bean.setPoiExtension(to(src.getPoiExtension()));

        bean.setSubPois(to(src.getSubPois()));

        return bean;
    }


}
