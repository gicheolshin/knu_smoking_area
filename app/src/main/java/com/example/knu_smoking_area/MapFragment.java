 package com.example.knu_smoking_area;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MapFragment extends Fragment implements OnMapReadyCallback
{
    GoogleMap g;
    double []latitude={35.8914698,
        35.8911677,
        35.8910886,
        35.8903656,
        35.8888628,
        35.8882806,
        35.8903315,
        35.8872929,
        35.8867424,
        35.8871809,
        35.8872196,
        35.8881205,
        35.88755,
        35.88724229,
        35.8877016,
        35.888149,
        35.8901772,
        35.8914733,
        35.8899903,
        35.8902654,
        35.8916661,
        35.8922256,
        35.8932525,
        35.8935891,
        35.8922486};
    double []longitude={128.6146257,
            128.6150027,
            128.6143079,
            128.6156387,
            128.6164181,
            128.615946,
            128.6132239,
            128.6126405,
            128.6097803,
            128.6114992,
            128.6101246,
            128.6101061,
            128.6089918,
            128.6092465,
            128.6092515,
            128.6086527,
            128.6063121,
            128.6096583,
            128.6068575,
            128.6116972,
            128.6129906,
            128.6113318,
            128.6112024,
            128.6135028,
            128.6144903};
    String []position={"첨성관12동",
            "첨성관23동",
            "어학교육원",
            "향토관",
            "국제경상관",
            "사회과학대학",
            "사범대",
            "IT1호관",
            "봉사관",
            "IT2호관",
            "공대7호관",
            "공대12호관",
            "공대1호관",
            "공대6호관",
            "공대3호관",
            "공대2호관",
            "체육진흥센터수영장",
            "농대1호관",
            "자연과학대본관",
            "본관",
            "도서관",
            "글로벌프라자",
            "예술대학",
            "누리관",
            "테크노빌딩"};
    boolean []chk={true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,true,false,true,false,true,true,true,true,true,true};
    private MapView mapView = null;
    BitmapDrawable bitmapdraw,bitmapdraw1;
    public MapFragment()
    {
        // required
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.activity_fragment_map, container, false);

        mapView = (MapView)layout.findViewById(R.id.map);
        mapView.getMapAsync(this);
        return layout;
    }
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }
    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //액티비티가 처음 생성될 때 실행되는 함수
        if(mapView != null)
        {
            mapView.onCreate(savedInstanceState);
        }
    }
    public void find(double la,double lo)
    {
        bitmapdraw1 = (BitmapDrawable) getResources().getDrawable(R.drawable.gray_book);
        bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.pink_position2);
        g.clear();
        LatLng SEOUL;
        boolean mini[]=new boolean[26];
        for(int i=0;i<26;i++)mini[i]=false;
        for(int j=0;j<2;j++) {
            double Max=123456789.0;
            int index=-1;
            for (int i = 0; i < latitude.length; i++) {
                if(mini[i])continue;
                double x=latitude[i];
                double y=longitude[i];
                double cur=(x-la)*(x-la)+(y-lo)*(y-lo);
                if(Max>cur)
                {
                    Max=cur;
                    index=i;
                    continue;
                }
            }
            mini[index]=true;
        }
        for (int i = 0; i < latitude.length; i++) {
            SEOUL = new LatLng(latitude[i], longitude[i]);
            InfoWindowData info=new InfoWindowData();
            info.setName(position[i]);
            info.setScore("★★★★★");
            if(chk[i])
            {
                info.setImage("pic"+i);
            }
            else
            {
                info.setImage("close");
            }
            MarkerOptions markerOptions = new MarkerOptions();
            if(mini[i])
            {
                Bitmap b=bitmapdraw1.getBitmap();
                Bitmap smallMarker = Bitmap.createScaledBitmap(b, 25, 25, false);
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
                markerOptions.position(SEOUL);
                CustomInfoWindowAdapter customInfo=new CustomInfoWindowAdapter(getActivity());
                g.setInfoWindowAdapter(customInfo);
                Marker m=g.addMarker(markerOptions);
                m.setTag(info);
            }
            else
            {Bitmap b=bitmapdraw.getBitmap();
                Bitmap smallMarker = Bitmap.createScaledBitmap(b, 25, 25, false);
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
                markerOptions.position(SEOUL);
                CustomInfoWindowAdapter customInfo=new CustomInfoWindowAdapter(getActivity());
                g.setInfoWindowAdapter(customInfo);
                Marker m=g.addMarker(markerOptions);
                m.setTag(info);

            }
        }
        SEOUL = new LatLng(la, lo);
        g.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));

        g.animateCamera(CameraUpdateFactory.zoomTo(20));

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.pink_position2);
        googleMap.clear();
        g=googleMap;
        LatLng SEOUL;
        for (int i = 0; i < latitude.length; i++) {
            SEOUL = new LatLng(latitude[i], longitude[i]);
            InfoWindowData info=new InfoWindowData();
            info.setName(position[i]);
            info.setScore("★★★★★");
            if(chk[i])
            {
                info.setImage("pic"+i);
            }
            else
            {
                info.setImage("close");
            }
            MarkerOptions markerOptions = new MarkerOptions();

            Bitmap b=bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, 25, 25, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
            markerOptions.position(SEOUL);
            CustomInfoWindowAdapter customInfo=new CustomInfoWindowAdapter(getActivity());
            googleMap.setInfoWindowAdapter(customInfo);
            Marker m=googleMap.addMarker(markerOptions);
            m.setTag(info);
        }

        SEOUL = new LatLng(latitude[19], longitude[19]);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));

        googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));
    }
}