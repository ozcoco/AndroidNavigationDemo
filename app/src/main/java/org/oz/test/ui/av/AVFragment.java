package org.oz.test.ui.av;

import android.content.Context;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.chip.Chip;

import org.oz.test.R;
import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.AvFragmentBinding;
import org.oz.test.widgets.view.ChoiceChips;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AVFragment extends ControllerNavBindingFragment<AvFragmentBinding, AVController> implements AVContract.View {


    private ArrayMap<String, List<String>> map;

    ChoiceChips.ChipAdapter<String> subAdapter;

    public class Handle implements ChoiceChips.OnChipCheckedChangeListener {

        @Override
        public void OnCheckedChange(ChoiceChips group, int id, int position) {

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

        ChoiceChips.ChipAdapter<String> adapter = new ChoiceChips.ChipAdapter<String>(getContext()) {

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

        subAdapter = new ChoiceChips.ChipAdapter<String>(getContext()) {

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
