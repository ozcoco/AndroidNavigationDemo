package org.oz.test.widgets.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;


interface Callback {

    void removeView(int viewId);

    void removeView(int... viewIds);

    void removeAllViews();

    void addViews(Chip... chips);

    void addViews(List<Chip> chips);

}

public class ChoiceChips extends ChipGroup implements Callback {


    enum OP {

        ADD, REFRESH

    }


    public interface OnChipCheckedChangeListener {

        void OnCheckedChange(ChoiceChips group, int id, int position);

    }

    public abstract static class ChipAdapter<E> {

        private OP mOp;

        private final List<Chip> mChips = new ArrayList<>();

        private Callback mCallback;

        private final Context mContext;

        private ViewGroup mParent;

        private final List<E> mData = new ArrayList<>();


        void setCallback(Callback callback, ViewGroup parent) {

            this.mCallback = callback;

            this.mParent = parent;

            notifyDataSetChanged();
        }

        public ChipAdapter(@NonNull Context context) {

            this(context, null);

        }

        public ChipAdapter(@NonNull Context context, List<E> data) {

            this.mContext = context;

            if (data != null) {

                mOp = OP.ADD;

                this.mData.addAll(data);
            }
        }

        public E getItem(int position) {

            return mData.get(position);
        }

        public int getCount() {

            return mData.size();
        }

        public abstract Chip createView(Context context, LayoutInflater inflater, ViewGroup parent, E data, int position);


        public void add(E e) {

            if (e == null) return;

            mOp = OP.ADD;

            this.mData.add(e);

            notifyDataSetChanged();

        }

        public void addData(List<E> data) {

            if (data == null) return;

            mOp = OP.ADD;

            this.mData.addAll(data);

            notifyDataSetChanged();

        }

        public void setData(List<E> data) {

            if (data == null) return;

            mOp = OP.REFRESH;

            this.mData.clear();

            this.mData.addAll(data);

            notifyDataSetChanged();

        }


        void notifyDataSetChanged() {
            loadView();
        }


        private void loadView() {

            if (mCallback == null || mContext == null || mParent == null) return;

            final LayoutInflater inflater = LayoutInflater.from(mContext);

            int len = getCount();

            int existViewSize = 0;

            if (mOp == OP.REFRESH) {

                mChips.clear();

            } else if (mOp == OP.ADD) {

                existViewSize = mChips.size();

            }

            for (int i = mChips.size(); i < len; i++) {

                mChips.add(createView(mContext, inflater, mParent, getItem(i), i));
            }

            if (mOp == OP.REFRESH) {

                mCallback.removeAllViews();

                mCallback.addViews(mChips);

            } else if (mOp == OP.ADD) {

                mCallback.addViews(mChips.subList(existViewSize, len));
            }


        }
    }


    private OnChipCheckedChangeListener mOnCheckedChangeListener;

    private ChipAdapter mAdapter;

    public ChoiceChips(Context context) {
        super(context);
    }

    public ChoiceChips(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChoiceChips(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OnChipCheckedChangeListener getOnCheckedChangeListener() {
        return this.mOnCheckedChangeListener;
    }

    public void setOnChipCheckedChangeListener(OnChipCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public void setAdapter(ChipAdapter adapter) {

        if (adapter == null) return;

        adapter.setCallback(this, this);

        this.mAdapter = adapter;

        this.setOnCheckedChangeListener((group, checkedId) -> {

            for (int i = 0; i < group.getChildCount(); i++) {

                if (group.getChildAt(i).getId() == checkedId) {

                    if (mOnCheckedChangeListener != null)
                        mOnCheckedChangeListener.OnCheckedChange(ChoiceChips.this, checkedId, i);
                    return;
                } else {

                    Chip v = (Chip) group.getChildAt(i);

                    v.setChecked(false);
                }
            }
        });

    }

    public ChipAdapter getAdapter() {
        return mAdapter;
    }


    @Override
    public void removeView(int viewId) {

        View v = findViewById(viewId);

        if (v != null)
            removeView(v);

    }

    @Override
    public void removeView(int... viewIds) {

        if (viewIds == null) return;

        for (int id : viewIds) {

            View v = findViewById(id);

            if (v != null)
                removeView(v);
        }

    }

    @Override
    public void removeAllViews() {

        removeAllViewsInLayout();

    }

    @Override
    public void addViews(Chip... chips) {

        if (chips == null) return;

        for (Chip chip : chips) {

            addView(chip);
        }
    }

    @Override
    public void addViews(List<Chip> chips) {

        if (chips == null) return;

        int len = chips.size();

        for (int i = 0; i < len; i++) {

            addView(chips.get(i));
        }
    }

}
