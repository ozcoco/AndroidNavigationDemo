package org.oz.test.widgets.dailog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.chip.Chip;

import org.oz.test.R;
import org.oz.test.widgets.view.ChoiceChipGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PopChoiceFilter extends PopupWindow implements ChoiceChipGroup.OnChipCheckedChangeListener {

    public interface OnChoiceFilterFinishListener {

        void onChoiceFilterFinished(int[] choicesId, int[] positions);

    }

    public interface OnChoicesChangeListener {

        void onChoicesChanged(int choiceId, int position);

    }

    public static abstract class ChoiceViewHolder {

        private final View mRoot;

        protected ChoiceChipGroup mChoiceChipGroup;

        public ChoiceViewHolder(View root) {
            mRoot = root;
        }

        public View getRoot() {
            return mRoot;
        }

        public ChoiceChipGroup getChoiceChipGroup() {
            return mChoiceChipGroup;
        }

        public void setAdapter(ChoiceChipGroup.ChipAdapter adapter) {

            assert mChoiceChipGroup != null;

            mChoiceChipGroup.setAdapter(adapter);

        }

    }

    public static abstract class Choice<H extends ChoiceViewHolder, C, I> {

        private final int choiceId;

        private final List<I> items;

        private final C data;

        private final ChoiceChipGroup.ChipAdapter<I> adapter;

        private final H viewHolder;

        public Choice(Context context, int choiceId, List<I> items, C data) {
            this.choiceId = choiceId;
            this.items = items;
            this.data = data;

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

            viewHolder = createChoiceView(context, inflater, data);

            adapter = new ChoiceChipGroup.ChipAdapter<I>(context) {
                @Override
                public Chip createView(Context context, LayoutInflater inflater, ViewGroup parent, I data, int position) {

                    return createChoiceItem(context, inflater, parent, data, position);
                }
            };

            viewHolder.setAdapter(adapter);

            adapter.setData(items);

        }

        public int getChoiceId() {
            return choiceId;
        }

        public List<I> getItems() {
            return items;
        }

        public C getData() {
            return data;
        }

        public ChoiceChipGroup.ChipAdapter<I> getAdapter() {
            return adapter;
        }

        public H getViewHolder() {
            return viewHolder;
        }

        public abstract Chip createChoiceItem(Context context, LayoutInflater inflater, ViewGroup parent, I data, int position);

        public abstract H createChoiceView(Context context, LayoutInflater inflater, C data);

    }


    private List<Choice> choices;

    private OnChoicesChangeListener onChoicesChangeListener;

    private OnChoiceFilterFinishListener onChoiceFilterFinishListener;

    private int[] changeChoiceIds;

    private int[] checkedChoiceItemPostions;

    public OnChoiceFilterFinishListener getOnChoiceFilterFinishListener() {
        return onChoiceFilterFinishListener;
    }

    public void setOnChoiceFilterFinishListener(OnChoiceFilterFinishListener onChoiceFilterFinishListener) {
        this.onChoiceFilterFinishListener = onChoiceFilterFinishListener;
    }

    public OnChoicesChangeListener getOnChoicesChangeListener() {
        return onChoicesChangeListener;
    }

    public void setOnChoicesChangeListener(OnChoicesChangeListener onChoicesChangeListener) {
        this.onChoicesChangeListener = onChoicesChangeListener;
    }

    public PopChoiceFilter(Context context, Choice... choices) {

        super(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        assert choices != null;

        LayoutInflater
                inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        @SuppressLint("InflateParams") View root = inflater.inflate(R.layout.pop_choice_filter2, null);

        setContentView(root);

        setElevation(5.0f);

        setOutsideTouchable(true);

        setClippingEnabled(true);

        setBackgroundDrawable(new ColorDrawable(0x55555555));

        int len = choices.length;

        this.choices = new ArrayList<>(len);

        this.choices.addAll(Arrays.asList(choices).subList(0, len));

        init();

    }


    private void init() {

        getContentView().setOnClickListener(v -> dismiss());

        getContentView().findViewById(R.id.btn_reset).setOnClickListener(v -> {

            for (int i = 0; i < choices.size(); i++) {

                choices.get(i).getViewHolder().getChoiceChipGroup().check(choices.get(i).getViewHolder().getChoiceChipGroup().getChildAt(0).getId());

                checkedChoiceItemPostions[i] = 0;
            }

        });


        getContentView().findViewById(R.id.btn_ok).setOnClickListener(v -> {

            if (onChoiceFilterFinishListener != null) {
                onChoiceFilterFinishListener.onChoiceFilterFinished(changeChoiceIds, checkedChoiceItemPostions);
            }


        });

        LinearLayoutCompat container = getContentView().findViewById(R.id.container);

        int len = choices.size();

        changeChoiceIds = new int[len];

        checkedChoiceItemPostions = new int[len];

        for (int i = 0; i < len; i++) {

            changeChoiceIds[i] = choices.get(i).getChoiceId();

            checkedChoiceItemPostions[i] = 0;

            ChoiceViewHolder holder = choices.get(i).getViewHolder();

            if (null != holder) {

                container.addView(holder.getRoot());

                if (null != holder.getChoiceChipGroup())
                    holder.getChoiceChipGroup().setOnChipCheckedChangeListener(this);

            }
        }

    }


    @Override
    public void OnCheckedChange(ChoiceChipGroup group, int id, int position) {

        int len = choices.size();

        for (int i = 0; i < len; i++) {

            final Choice choice = choices.get(i);

            if (onChoicesChangeListener != null && group == choice.getViewHolder().getChoiceChipGroup()) {

                onChoicesChangeListener.onChoicesChanged(choice.choiceId, position);

                if (choice.getChoiceId() == changeChoiceIds[i]) {

                    checkedChoiceItemPostions[i] = position;

                }

            }

        }

    }
}
