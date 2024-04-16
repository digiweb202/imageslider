package com.container.imageslider;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout dotsLayout;
    private int[] images = {R.drawable.xi1,
            R.drawable.xi2,
            R.drawable.xi3,
            R.drawable.xi4,
            R.drawable.xi5,
            R.drawable.xi6,
            R.drawable.xi7,
            R.drawable.xi8,
            R.drawable.xi9};
    private ImageView[] dots;
    TextView MRP_PRICE;
    TextView specification;

    private int currentPage = 0;
    private Timer timer;
    TextView DescriptionTxt;
    private Button toggleButton;
    private Button descriptionbtn;
    private boolean isExpanded = false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);
        MRP_PRICE = findViewById(R.id.mrp_price);
        specification = findViewById(R.id.specificationviewdata);
        DescriptionTxt = findViewById(R.id.descriptionviewdata);
        toggleButton = findViewById(R.id.toggleButton);
        descriptionbtn = findViewById(R.id.toggleBtn);


        descriptionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextViewbtn();
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextView();
            }
        });
        String htmlString =
                "<h6>GENERAL INFORMATION</h6>" +
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

                        "<h6>PHONE BATTERY & CHARGE TIME</h6>" +
                        "<b>Battery Capacity:</b> 5000 mAh<br/><br/><br/><br/>" +

                        "<h6>PHONE NETWORK & INTER-DEVICE CONNECTIVITY</h6>" +
                        "<b>Hybrid SIM Slot:</b> Yes<br/><br/>" +
                        "<b>Bluetooth Version:</b> v5<br/><br/>" +
                        "<b>Bluetooth:</b> Yes<br/><br/>" +
                        "<b>Audio Jack:</b> 3.5 mm<br/><br/>" +
                        "<b>Cellular Technology:</b> GSM + WCDMA + LTE<br/><br/><br/><br/>" +

                        "<h6>SCREEN DISPLAY & CAMERA</h6>" +
                        "<b>Screen Size (Diagonal):</b> 16.56 cm (6.52 Inch)<br/><br/>" +
                        "<b>Display Type:</b> IPS LCD<br/><br/><br/><br/>" +

                        "<h6>HARDWARE DETAILS</h6>" +
                        "<b>Memory (RAM):</b> 2 GB<br/><br/><br/><br/>" +

                        "<h6>ADDITIONAL FEATURES</h6>" +
                        "<b>Features:</b> MediaTek Helio G36 Processor Andriod 12 Operating System Expandable Memory 1TB<br/><br/><br/><br/>" +

                        "<h6>IN THE BOX & WARRANTY</h6>" +
                        "<b>In The Box:</b> Adapter, USB cable, SIM eject tool, Warranty card, User guide<br/><br/>" +
                        "<b>Warranty:</b> 1 Year<br/><br/><br/><br/>" +

                        "<h6>MANUFACTURING & PACKING INFORMATION</h6>" +
                        "<b>Country of origin:</b> India<br/><br/>" +
                        "<b>Name and address of Packer:</b> Bharat FIH limited , #380, BELERICA ROAD, SRI CITY, SIDDAM AGRAHARAM VILLAGE, VARADAIAHPALEM MANDAL, CHITTOOR DISTRICT-517541, ANDHRA PRADESH<br/><br/>" +
                        "<b>Name and address of Manufacturer:</b> Bharat FIH limited , #380, BELERICA ROAD, SRI CITY, SIDDAM AGRAHARAM VILLAGE, VARADAIAHPALEM MANDAL, CHITTOOR DISTRICT-517541, ANDHRA PRADESH<br/><br/>" +
                        "<b>Name and address of Importer:</b> NA<br/><br/>" +
                        "<b>Name of Seller:</b> Reliance Retail Ltd.<br/><br/>" +
                        "<b>Month and Year of Commodity First Manufactured/Imported/Packed:</b> May'2023<br/><br/>" +
                        "<b>BIS Model Number:</b> 49061<br/><br/>" +
                        "<b>Commodity name:</b> Redmi A2<br/><br/>" +
                        "<b>Item Width:</b> 7.54 cm<br/><br/>" +
                        "<b>Item Height:</b> 0.73 cm<br/><br/>" +
                        "<b>Item Length:</b> 15.87 cm<br/><br/>" +
                        "<b>Net Quantity:</b> 1 N<br/><br/>" +
                        "<b>Net Weight:</b> 360 g<br/><br/>" +
                        "<b>Name and address of Marketed By:</b> NA<br/><br/><br/><br/>" +

                        "<h6>PRODUCT TYPE</h6>" +
                        "<b>Product Type:</b> Smartphones";

        String descriptionstring =
                "<h6>General Information</h6>\n" +
                "<ul>\n" +
                "    <li><b>Brand:</b> Xiaomi</li>\n" +
                "    <li><b>Model:</b> Redmi A2</li>\n" +
                "    <li><b>Color:</b> Blue</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Hardware & Storage</h6>\n" +
                "<ul>\n" +
                "    <li><b>Internal Storage:</b> 64 GB</li>\n" +
                "    <li><b>Processor:</b> MediaTek Helio G36</li>\n" +
                "    <li><b>Storage Type:</b> microSD Card</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Operating System</h6>\n" +
                "<ul>\n" +
                "    <li><b>OS:</b> Android 12</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Network & Connectivity</h6>\n" +
                "<ul>\n" +
                "    <li><b>SIM Type:</b> Dual SIM</li>\n" +
                "    <li><b>4G:</b> Yes (LTE)</li>\n" +
                "    <li><b>5G:</b> No</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Battery & Charging</h6>\n" +
                "<ul>\n" +
                "    <li><b>Battery Capacity:</b> 5000 mAh</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Display & Camera</h6>\n" +
                "<ul>\n" +
                "    <li><b>Screen Size:</b> 16.56 cm (6.52 inches)</li>\n" +
                "    <li><b>Display Type:</b> IPS LCD</li>\n" +
                "    <li><b>Camera:</b> Quad-camera setup (64MP + 12MP + 8MP + 2MP)</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Additional Features</h6>\n" +
                "<ul>\n" +
                "    <li>MediaTek Helio G36 Processor</li>\n" +
                "    <li>Expandable Memory up to 1TB</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>In The Box & Warranty</h6>\n" +
                "<ul>\n" +
                "    <li><b>In The Box:</b> Adapter, USB cable, SIM eject tool, Warranty card, User guide</li>\n" +
                "    <li><b>Warranty:</b> 1 Year</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Manufacturing & Packing Information</h6>\n" +
                "<ul>\n" +
                "    <li><b>Country of Origin:</b> India</li>\n" +
                "    <li><b>Manufacturer:</b> Bharat FIH Limited</li>\n" +
                "    <li><b>Packer:</b> Bharat FIH Limited</li>\n" +
                "    <li><b>Importer:</b> NA</li>\n" +
                "    <li><b>Sold By:</b> Reliance Retail Ltd.</li>\n" +
                "    <li><b>Manufactured:</b> May 2023</li>\n" +
                "</ul>\n" +
                "\n" +
                "<h6>Product Type</h6>\n" +
                "<ul>\n" +
                "    <li><b>Type:</b> Smartphone</li>\n" +
                "</ul>\n";

        DescriptionTxt.setText(HtmlCompat.fromHtml(descriptionstring, HtmlCompat.FROM_HTML_MODE_LEGACY));

        specification.setText(HtmlCompat.fromHtml(htmlString, HtmlCompat.FROM_HTML_MODE_LEGACY));




        PagerAdapter adapter = new PagerAdapter();
        viewPager.setAdapter(adapter);


        addDotsIndicator(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                addDotsIndicator(position);
                currentPage = position;
            }
        });

        // Start auto-slider
        startAutoSlider();
        // Handle click on an image
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start full-screen activity with the clicked image
                Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
                intent.putExtra("position", viewPager.getCurrentItem());
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Full Screen button click//:" , Toast.LENGTH_SHORT).show();

            }
        });





        // Your HTML string containing multiple image tags
        String htmlStringbanner = "<h6>GENERAL INFORMATION</h6>" +
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
                "<img src=\"https://i.pinimg.com/736x/c7/5a/f7/c75af7e6c5287ccdd17f7c95cd50be91.jpg\" />" +
                "<img src=\"https://www.bajajmall.in/content/dam/emistoremarketplace/index/10-10-22/geetanjali/mobile-phones-diwali-page/big-banner/desk/MCLP_Row3_1_BigBanner_Desk_OnePlus10Pro_PDP_B2B.jpg\" />"+
                "<img src=\"https://www.bajajmall.in/content/dam/emistoremarketplace/index/10-10-22/geetanjali/mobile-phones-diwali-page/big-banner/desk/MCLP_Row5_1_BigBanner_Desk_vivoT15G_PDP_B2B.jpg\" />";

        // Extract image URLs using regex
        List<String> imageUrls = extractImageUrls(htmlStringbanner);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter adapters = new ImageAdapter(imageUrls);
        recyclerView.setAdapter(adapters);

    }
    private void toggleTextView() {
        if (isExpanded) {
            // If currently expanded, collapse
            specification.setMaxLines(30); // Set your desired number of lines
            toggleButton.setText("More Details");
        } else {
            // If currently collapsed, expand
            specification.setMaxLines(Integer.MAX_VALUE); // Set to max value
            toggleButton.setText("Less Details");
        }
        isExpanded = !isExpanded;
    }
    private void toggleTextViewbtn() {
        if (isExpanded) {
            // If currently expanded, collapse
            DescriptionTxt.setMaxLines(30); // Set your desired number of lines
            descriptionbtn.setText("More Details");
        } else {
            // If currently collapsed, expand
            DescriptionTxt.setMaxLines(Integer.MAX_VALUE); // Set to max value
            descriptionbtn.setText("Less Details");
        }
        isExpanded = !isExpanded;
    }
    private void addDotsIndicator(int position) {
        dots = new ImageView[images.length];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            if (i == position) {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.active_dot));
            } else {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.inactive_dot));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(8, 0, 8, 0);
            dotsLayout.addView(dots[i], params);
        }
    }

    private void startAutoSlider() {
        final Handler handler = new Handler();
        final Runnable update = () -> {
            if (currentPage == images.length) {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage++, true);
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 2000, 4000); // Change 2000 and 4000 to control delay between slides
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop auto-slider when activity is destroyed
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.PagerViewHolder> {

        @NonNull
        @Override
        public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, parent, false);
            return new PagerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PagerViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.imageView.setImageResource(images[position]);

            // Set click listener on the image view
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start full-screen activity with the clicked image
                    Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return images.length;
        }

        class PagerViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public PagerViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
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