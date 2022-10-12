package com.example.cwmobile;

import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TripListViewAdapter extends BaseAdapter {


    private ArrayList<Trip> listTrip;

    TripListViewAdapter(ArrayList<Trip> listTrip) {
        this.listTrip = listTrip;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return listTrip.size();
    }

    @Override
    public Object getItem(int i) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        //có chỉ số position trong listProduct
        return listTrip.get(i);
    }

    @Override
    public long getItemId(int i) {
        //Trả về một ID của phần
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới

        View viewTrip;
        if (convertView == null) {
            viewTrip = View.inflate(parent.getContext(), R.layout.line_trip, null);
        } else viewTrip = convertView;

        //Bind sữ liệu phần tử vào View
        Trip trip = (Trip) getItem(i);
        ((TextView) viewTrip.findViewById(R.id.textViewTripName)).setText(String.format("%d", trip.getTripName()));
        ((TextView) viewTrip.findViewById(R.id.textViewLocation)).setText(String.format("Location : %s", trip.getTripDestination()));
        ((TextView) viewTrip.findViewById(R.id.textViewDate)).setText(String.format("%d", trip.getTripDate()));


        return viewTrip;
    }

}
