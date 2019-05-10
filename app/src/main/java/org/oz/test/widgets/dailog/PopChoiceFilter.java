package org.oz.test.widgets.dailog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.chip.Chip;

import org.oz.test.R;
import org.oz.test.widgets.view.ChoiceChipGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PopChoiceFilter extends PopupWindow implements ChoiceChipGroup.OnChipCheckedChangeListener {

    private ArrayMap<String, List<String>> map;

    private final ChoiceChipGroup cc_first;

    private final ChoiceChipGroup cc_second;

    private final ChoiceChipGroup cc_third;

    ChoiceChipGroup.ChipAdapter<String> secondAdapter;


    public PopChoiceFilter(Context context) {

        super(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        @SuppressLint("InflateParams") View root = inflater.inflate(R.layout.pop_choice_filter, null);

        setContentView(root);

        cc_first = root.findViewById(R.id.cc_first);

        cc_second = root.findViewById(R.id.cc_second);

        cc_third = root.findViewById(R.id.cc_third);

        setElevation(5.0f);

        setOutsideTouchable(true);

        setClippingEnabled(true);

        setBackgroundDrawable(new ColorDrawable(0x55555555));

        init();

    }

    private void init() {

        getContentView().setOnClickListener(v -> dismiss());

        map = new ArrayMap<>();

        for (int i = 0; i < 5; i++) {

            List<String> list = new ArrayList<>();

            for (int j = 0; j < 5 + i; j++) {

                list.add("SubChip" + i + j);

            }

            map.put("Chip" + i, list);

        }

        ChoiceChipGroup.ChipAdapter<String> firstAdapter = new ChoiceChipGroup.ChipAdapter<String>(getContentView().getContext()) {

            @Override
            public Chip createView(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {

                final Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                v.setChecked(position == 0);

                v.setText(data);

                return v;
            }
        };

        List<String> firstData = new ArrayList<>(map.keySet());

        firstAdapter.setData(firstData);

        cc_first.setAdapter(firstAdapter);

        cc_first.setOnChipCheckedChangeListener(this);

        secondAdapter = new ChoiceChipGroup.ChipAdapter<String>(getContentView().getContext()) {

            @Override
            public Chip createView(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {

                final Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                v.setChecked(position == 0);

                v.setText(data);

                return v;
            }
        };

        secondAdapter.setData(map.valueAt(0));

        cc_second.setAdapter(secondAdapter);

        cc_second.setOnChipCheckedChangeListener(this);


        ChoiceChipGroup.ChipAdapter<String> thirdAdapter = new ChoiceChipGroup.ChipAdapter<String>(getContentView().getContext()) {

            @Override
            public Chip createView(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {

                final Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                v.setChecked(position == 0);

                v.setText(data);

                return v;
            }
        };

        cc_third.setAdapter(thirdAdapter);

        cc_third.setOnChipCheckedChangeListener(this);

        List<String> thirdData = new ArrayList<>();

        for (int i = 0; i < 7; i++) {

            thirdData.add("日期" + i);
        }

        thirdAdapter.addData(thirdData);
    }

    @Override
    public void OnCheckedChange(ChoiceChipGroup group, int id, int position) {

        if (group.getId() == R.id.cc_first) {

            secondAdapter.setData(map.valueAt(position));

            ToastUtils.showShort(String.format(Locale.CHINA, "Checked first chip Id:%d", id));

        } else if (group.getId() == R.id.cc_second) {

            ToastUtils.showShort(String.format(Locale.CHINA, "Checked second chip Id:%d", id));

        } else if (group.getId() == R.id.cc_third) {

            ToastUtils.showShort(String.format(Locale.CHINA, "Checked third chip Id:%d", id));

        }

    }
}
