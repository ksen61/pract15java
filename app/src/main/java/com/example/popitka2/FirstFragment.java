package com.example.popitka2;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private TextView textViewTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        textViewTitle = view.findViewById(R.id.text_view_title);
        Button buttonChangeText = view.findViewById(R.id.button_change_text);

        registerForContextMenu(textViewTitle);

        buttonChangeText.setOnClickListener(v -> {
            getActivity().openContextMenu(textViewTitle);
        });

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_option_one:
                textViewTitle.setText("Выбрано: Опция 1");
                return true;
            case R.id.menu_option_two:
                textViewTitle.setText("Выбрано: Опция 2");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
