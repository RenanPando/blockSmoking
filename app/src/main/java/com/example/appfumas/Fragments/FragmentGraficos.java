package com.example.appfumas.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.appfumas.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGraficos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGraficos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    int test;
    private DatabaseReference ref;
    Calendar c = Calendar.getInstance();
    BarChart barChart;
    EditText input;
    ArrayList barArrayList;

    public FragmentGraficos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentGraficos.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentGraficos newInstance(String param1, String param2) {
        FragmentGraficos fragment = new FragmentGraficos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graficos, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BarChart barChart = view.findViewById(R.id.teste);
        barArrayList = new ArrayList();
        barChart.getDescription().setEnabled(false);
        barChart.setTouchEnabled(true);
        barChart.setPinchZoom(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setBorderColor(Color.WHITE);
        barChart.getLegend().setEnabled(false);
    }

    public void teste(View v){
        String[] nomeMes = {"janeiro","fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"};
        ref = FirebaseDatabase.getInstance().getReference().child(nomeMes[c.get(Calendar.MONTH)]+"-"+c.get(Calendar.YEAR));
        int data = Integer.parseInt(input.getText().toString());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                test = Integer.parseInt(String.valueOf(snapshot.getValue()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref.setValue(data);
        getData(data);
    }

    public void getData(int data){
        barChart.clear();
        barArrayList = new ArrayList();
        barArrayList.add(new BarEntry(2f, test));
        barArrayList.add(new BarEntry(3f, data));
        barArrayList.add(new BarEntry(4f, 20));
        barArrayList.add(new BarEntry(5f, 100));
        BarDataSet barDataset = new BarDataSet(barArrayList, "");
        barDataset.setColors(Color.WHITE);
        barDataset.setValueTextColor(Color.BLACK);
        barDataset.setValueTextSize(16f);
        BarData barData = new BarData(barDataset);
        barChart.setData(barData);
    }

}