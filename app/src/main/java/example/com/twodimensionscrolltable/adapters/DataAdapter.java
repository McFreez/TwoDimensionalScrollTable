package example.com.twodimensionscrolltable.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.twodimensionscrolltable.R;

import static java.security.AccessController.getContext;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private static final String TAG = DataAdapter.class.getSimpleName();

    private int mAttributesCount;
    private int mDaysCount;
    private Context mContext;

    public DataAdapter(int daysCount, int attributesCount, Context context){
        mDaysCount = daysCount;
        mAttributesCount = attributesCount;
        mContext = context;
    }

    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = R.layout.data_in_day_column;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutId, parent, shouldAttachToParentImmediately);
        DataAdapter.DataViewHolder viewHolder = new DataAdapter.DataViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.DataViewHolder holder, int position) {
        holder.bind(String.valueOf("Day " + position));
    }

    @Override
    public int getItemCount() {
        return mDaysCount;
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return Math.round(dp * displayMetrics.density);
    }

    class DataViewHolder extends RecyclerView.ViewHolder{

        //TextView attributeTitle;
        LinearLayout container;
        List<LinearLayout> tasks;

        public DataViewHolder(View itemView) {
            super(itemView);

            tasks = new ArrayList<>();

            container = (LinearLayout) itemView.findViewById(R.id.data_in_day_container);

            for(int i = 0; i < mAttributesCount; i++){
                LinearLayout ll = new LinearLayout(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dpToPx(92), dpToPx(92));
                params.setMargins(dpToPx(4), dpToPx(4), dpToPx(4), dpToPx(4));
                ll.setGravity(Gravity.CENTER_VERTICAL);
                ll.setBackgroundColor(Color.CYAN);
                tasks.add(ll);
                container.addView(ll, params);
            }

            //attributeTitle = (TextView) itemView.findViewById(R.id.tv_attribute);
        }

        void bind(String title){
            //attributeTitle.setText(title);
        }
    }
}
