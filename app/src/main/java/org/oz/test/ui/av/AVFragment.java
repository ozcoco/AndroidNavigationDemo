package org.oz.test.ui.av;

import android.content.Context;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;

import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.chip.Chip;

import org.oz.test.R;
import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.AvFragmentBinding;
import org.oz.test.widgets.dailog.PopChoiceFilter;
import org.oz.test.widgets.view.ChoiceChipGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AVFragment extends ControllerNavBindingFragment<AvFragmentBinding, AVController> implements AVContract.View {


    private ArrayMap<String, List<String>> map;

    ChoiceChipGroup.ChipAdapter<String> subAdapter;

    private PopChoiceFilter popChoiceFilter;


    class CommonChoiceViewHolder extends PopChoiceFilter.ChoiceViewHolder {

        AppCompatTextView title;

        public CommonChoiceViewHolder(View root) {
            super(root);
            title = root.findViewById(R.id.title);
            mChoiceChipGroup = root.findViewById(R.id.chips);
        }

    }

    private void initPopChoiceFilter() {


        PopChoiceFilter.Choice<CommonChoiceViewHolder, String, String> first =
                new PopChoiceFilter.Choice<CommonChoiceViewHolder, String, String>(getContext(), 1, map.valueAt(0), "农事筛选") {


                    @Override
                    public Chip createChoiceItem(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {

                        Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                        v.setChecked(position == 0);

                        v.setText(data);

                        return v;
                    }

                    @Override
                    public CommonChoiceViewHolder createChoiceView(Context context, LayoutInflater inflater, String data) {

                        CommonChoiceViewHolder holder = new CommonChoiceViewHolder(inflater.inflate(R.layout.item_choice, null));

                        holder.title.setText(data);

                        return holder;
                    }
                };


        PopChoiceFilter.Choice<CommonChoiceViewHolder, String, String> second =
                new PopChoiceFilter.Choice<CommonChoiceViewHolder, String, String>(getContext(), 2, map.valueAt(1), "农事类型") {


                    @Override
                    public Chip createChoiceItem(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {
                        Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                        v.setChecked(position == 0);

                        v.setText(data);

                        return v;
                    }

                    @Override
                    public CommonChoiceViewHolder createChoiceView(Context context, LayoutInflater inflater, String data) {
                        CommonChoiceViewHolder holder = new CommonChoiceViewHolder(inflater.inflate(R.layout.item_choice, null));

                        holder.title.setText(data);

                        return holder;
                    }
                };

        List<String> thirdData = new ArrayList<>();

        for (int i = 0; i < 7; i++) {

            thirdData.add("日期" + i);
        }

        PopChoiceFilter.Choice<CommonChoiceViewHolder, String, String> third = new
                PopChoiceFilter.Choice<CommonChoiceViewHolder, String, String>(getContext(), 3, thirdData, "时间") {


                    @Override
                    public Chip createChoiceItem(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {
                        Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                        v.setChecked(position == 0);

                        v.setText(data);

                        return v;
                    }

                    @Override
                    public CommonChoiceViewHolder createChoiceView(Context context, LayoutInflater inflater, String data) {
                        CommonChoiceViewHolder holder = new CommonChoiceViewHolder(inflater.inflate(R.layout.item_choice, null));

                        holder.title.setText(data);

                        return holder;
                    }
                };


        popChoiceFilter = new PopChoiceFilter(getContext(), first, second, third);

        popChoiceFilter.setOnChoicesChangeListener((choiceId, position) -> {

            if (choiceId == first.getChoiceId()) {

                second.getAdapter().setData(map.valueAt(position));

            }

            ToastUtils.showShort(String.format(Locale.CHINA, "choice id: %d Chip position:%d", choiceId, position));

        });

        popChoiceFilter.setOnChoiceFilterFinishListener((choicesId, positions) -> {

            StringBuffer buffer = new StringBuffer("Chip positions:");

            for (int position : positions)
                buffer.append("--->").append(position);

            ToastUtils.showShort(buffer.toString());
        });

    }


    public class Handle implements ChoiceChipGroup.OnChipCheckedChangeListener {


        public void onPop(View v) {

            if (popChoiceFilter == null) {

                initPopChoiceFilter();

                popChoiceFilter.showAtLocation(getView(), Gravity.START | Gravity.TOP, 0, 0);

            } else {
                popChoiceFilter.showAtLocation(getView(), Gravity.START | Gravity.TOP, 0, 0);
            }

        }

        @Override
        public void OnCheckedChange(ChoiceChipGroup group, int id, int position) {

            if (group.getId() == R.id.cc_ships) {


                subAdapter.setData(map.valueAt(position));

                ToastUtils.showShort(String.format(Locale.CHINA, "Chip Id:%d", id));

            } else if (group.getId() == R.id.cc_ships_second) {

                ToastUtils.showShort(String.format(Locale.CHINA, "SubChip Id:%d", id));

            }

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setHandle(new Handle());

        getBinding().setVm(ViewModelProviders.of(this).get(AvViewModel.class));

    }

    @Override
    public void onStart() {
        super.onStart();

        ChoiceChipGroup.ChipAdapter<String> adapter = new ChoiceChipGroup.ChipAdapter<String>(getContext()) {

            @Override
            public Chip createView(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {

                final Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                v.setChecked(position == 0);

                v.setText(data);

                return v;
            }
        };


        map = new ArrayMap<>();

        for (int i = 0; i < 5; i++) {

            List<String> list = new ArrayList<>();

            for (int j = 0; j < 5 + i; j++) {

                list.add("SubChip" + i + j);

            }

            map.put("Chip" + i, list);

        }

        List<String> data = new ArrayList<>(map.keySet());

        adapter.setData(data);

        getBinding().ccShips.setAdapter(adapter);

        subAdapter = new ChoiceChipGroup.ChipAdapter<String>(getContext()) {

            @Override
            public Chip createView(Context context, LayoutInflater inflater, ViewGroup parent, String data, int position) {

                final Chip v = (Chip) inflater.inflate(R.layout.item_choice_chip, parent, false);

                v.setChecked(position == 0);

                v.setText(data);

                return v;
            }
        };

        subAdapter.setData(map.valueAt(0));

        getBinding().ccShipsSecond.setAdapter(subAdapter);

    }
}
