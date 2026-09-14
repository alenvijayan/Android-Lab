package com.example.adapterview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapterview.R;

public class MainActivity extends AppCompatActivity {

    ListView imageList;
    ImageView displayImage;

    String[] imageNames = {"Kitten", "Puppy", "Honey Badger", "Giraffe", "Tiger Cub"};

    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList = findViewById(R.id.imageList);
        displayImage = findViewById(R.id.displayImage);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, imageNames);

        imageList.setAdapter(adapter);

        imageList.setOnItemClickListener(
                (parent, view, position, id) -> {

                    displayImage.setImageResource(
                            images[position]
                    );
                }
        );
    }
}