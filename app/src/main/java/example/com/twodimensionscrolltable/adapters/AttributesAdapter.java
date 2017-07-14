package example.com.twodimensionscrolltable.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.twodimensionscrolltable.R;

public class AttributesAdapter {

    private Context mContext;
    private List<String> mAttributes;
    private List<View> mAttributeViews;
    private LinearLayout mAttributesContainer;

    public AttributesAdapter(Context context, List<String> attributes, LinearLayout attributesContainer){
        mContext = context;
        mAttributes = attributes;
        mAttributesContainer = attributesContainer;

        createViews();
    }

    private void createViews(){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mAttributeViews = new ArrayList<>();

        for(int i = 0; i < mAttributes.size(); i++){

            View view = inflater.inflate(R.layout.attributes_item, null, false);

            AttributesViewHolder viewHolder = new AttributesViewHolder();
            viewHolder.attributeTitle = (TextView) view.findViewById(R.id.tv_attribute);
            viewHolder.attributeTitle.setText(mAttributes.get(i));
            view.setTag(viewHolder);

            mAttributesContainer.addView(view);
            mAttributeViews.add(view);
        }
    }

    static class AttributesViewHolder{
        public TextView attributeTitle;
    }
}
