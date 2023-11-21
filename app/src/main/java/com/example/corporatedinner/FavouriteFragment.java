package com.example.corporatedinner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavouriteFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        final String[] favMeals = new String[] {
                "Салат", "Пюре", "Стейк", "Индейка", "Котлета", "Макароны", "Роллы", "Пицца",
                "Бургер", "Ватрушка", "Борщ", "Солянка", "Чай", "Кофе", "Газированная вода"
        };
        RecyclerView favouriteMealsRecycler = view.findViewById(R.id.favourite_recycler_view);
        favouriteMealsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        CustomAdapter customAdapter = new CustomAdapter(favMeals);
        favouriteMealsRecycler.setAdapter(customAdapter);

        return view;
    }
}