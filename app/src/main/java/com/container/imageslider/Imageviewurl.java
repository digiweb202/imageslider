package com.container.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Imageviewurl extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageviewurl);


        // Your HTML string containing multiple image tags
        String htmlString = "<h6>GENERAL INFORMATION</h6>" +
                "<b>Colour:</b> Blue<br/><br/>" +
                "<b>Series:</b> XIAOMI A SERIES<br/><br/>" +
                "<b>Model:</b> A2<br/><br/>" +
                "<b>Brand:</b> Xiaomi<br/><br/><br/><br/>" +

                "<h6>PHONE HARDWARE & STORAGE</h6>" +
                "<b>Internal Storage:</b> 64 GB<br/><br/>" +
                "<b>Processor:</b> MediaTek Helio G36<br/><br/>" +
                "<b>Storage Type:</b> microSD Card<br/><br/><br/><br/>" +

                "<h6>PHONE OS</h6>" +
                "<b>Operating System:</b> Andriod 12<br/><br/><br/><br/>" +

                "<h6>NETWORK & INTER-DEVICE CONNECTIVITY</h6>" +
                "<b>Operating System Type:</b> Android<br/><br/>" +
                "<b>SIM Type:</b> Dual SIM<br/><br/>" +
                "<b>4G:</b> Yes - LTE<br/><br/>" +
                "<b>5G:</b> No<br/><br/><br/><br/>" +
                "<img src=\"https://img.freepik.com/premium-vector/product-advertising-hero-image-header-layout_1302-21013.jpg\" />" +
                "<img src=\"https://i.pinimg.com/612x/c7/5a/f7/c75af7e6c5287ccdd17f7c95cd50be91.jpg\" />" +
                "<img src=\"https://img.freepik.com/premium-vector/product-advertising-hero-image-header-layout_1302-21013.jpg\" />"+
                "<img src=\"https://img.freepik.com/premium-vector/product-advertising-hero-image-header-layout_1302-21013.jpg\" />"+
                "<img src=\"https://img.freepik.com/premium-vector/product-advertising-hero-image-header-layout_1302-21013.jpg\" />"+
                "<img src=\"https://img.freepik.com/premium-vector/product-advertising-hero-image-header-layout_1302-21013.jpg\" />";

        // Extract image URLs using regex
        List<String> imageUrls = extractImageUrls(htmlString);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter adapter = new ImageAdapter(imageUrls);
        recyclerView.setAdapter(adapter);
    }
    // Function to extract image URLs from HTML string using regex
    private List<String> extractImageUrls(String htmlString) {
        List<String> imageUrls = new ArrayList<>();
        // Regex pattern to match the src attribute of the img tag
        Pattern pattern = Pattern.compile("<img\\s+[^>]*?src\\s*=\\s*['\"]([^'\"]*?)['\"][^>]*?>");
        Matcher matcher = pattern.matcher(htmlString);
        while (matcher.find()) {
            String imageUrl = matcher.group(1); // Extract the URL from each match
            imageUrls.add(imageUrl);
        }
        return imageUrls;
    }
}