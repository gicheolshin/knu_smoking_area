package com.example.knu_smoking_area;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
    private Activity context;

    public CustomInfoWindowAdapter(Activity ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker  marker) {
        View view = context.getLayoutInflater().inflate(R.layout.item_window, null);
        TextView name_tv = view.findViewById(R.id.name);
        TextView score_tv = view.findViewById(R.id.score);
        ImageView img = view.findViewById(R.id.imagepoint);
        InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

        int imageId = context.getResources().getIdentifier(infoWindowData.getImage(),
                "drawable", context.getPackageName());
        img.setImageResource(imageId);

        name_tv.setText(infoWindowData.getName());
        score_tv.setText(infoWindowData.getScore());
        view.setLayoutParams(new RelativeLayout.LayoutParams(500, RelativeLayout.LayoutParams.WRAP_CONTENT));
        return view;
    }
}