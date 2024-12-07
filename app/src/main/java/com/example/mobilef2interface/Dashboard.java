package com.example.mobilef2interface;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends Fragment {
    public Dashboard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Инициализация Spinner
        Spinner mySpinner = view.findViewById(R.id.my_spinner);

        // Создаем массив элементов для Spinner
        String[] items = new String[]{"Extruder 1", "Extruder 2"};

        // Создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Устанавливаем стиль для выпадающего списка

        // Устанавливаем адаптер для Spinner
        mySpinner.setAdapter(adapter);

        return view;
    }
}