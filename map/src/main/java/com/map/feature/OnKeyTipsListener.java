package com.map.feature;

import com.map.constant.MapResult;
import com.map.entity.Tip;

import java.util.List;

public interface OnKeyTipsListener {

    void onKeyTips(List<Tip> tips, MapResult result);

}
