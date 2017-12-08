package com.japangor.learntocode;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.ArrayList;

import butterknife.ButterKnife;

import static com.japangor.learntocode.R.id.webView;
import static com.japangor.learntocode.R.layout;
import static com.japangor.learntocode.R.layout.activity_view;
import static java.lang.System.out;

public class overview extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout mDemoSlider;


    private ExpandableHeightListView listview;
    private ArrayList<BeanclassList> Bean;
    private ListviewAdapter baseAdapter;


    private String[] TITLEC = {"Basic HTML Document", "HTML Tags","HTML Document Structure", "The DOCTYPE Declaration"};
    private String[] PRICEC = {"","","",""};
    private String[] DETAILC = {"","","",""};

    int i;
    InterstitialAd mInterstitialAd;
    public String result;

    private static final long RIPPLE_DURATION = 250;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(layout.activity_overview);
 AdView adView = new AdView(this);        adView.setAdSize(AdSize.SMART_BANNER);        mAdView = (AdView)findViewById(R.id.adView);        AdRequest adRequest = new AdRequest.Builder().build();        mAdView.loadAd(adRequest);
        Toolbar toolbar;
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        FrameLayout root;
        root = (FrameLayout) findViewById(R.id.activity_main);
        View contentHamburger;
        contentHamburger = (ImageView) findViewById(R.id.content_hamburger);

        ButterKnife.bind(this);


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();


        listview = (ExpandableHeightListView)findViewById(R.id.haircut_list);

        Bean = new ArrayList<BeanclassList>();

        for ( i= 0; i< TITLEC.length; i++){

            BeanclassList BeanclassList = new BeanclassList(TITLEC[i], PRICEC[i], DETAILC[i]);
            Bean.add(BeanclassList);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                        long arg3) {
                    // TODO Auto-generated method stub

                    Toast.makeText(getApplicationContext(), TITLEC[position], Toast.LENGTH_SHORT).show();

                    if (TITLEC[position]==TITLEC[position]) {
                        Dialog dialog = new Dialog(overview.this);
                        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                        View vi = inflater.inflate(activity_view, null);

                        dialog.setContentView(vi);

                        dialog.setTitle(TITLEC[position]);
                        dialog.setCancelable(true);
                        WebView wb = (WebView) vi.findViewById(webView);
                        wb.loadUrl("file:///android_asset/program/" + TITLEC[position] + ".html");
                        wb.getSettings().setBuiltInZoomControls(true);
                        wb.getSettings().setDisplayZoomControls(false);
                        out.println("..loading url..");


                        dialog.show();

                    }


                }
            });



        }

        baseAdapter = new ListviewAdapter(overview.this, Bean) {
        };

        listview.setAdapter(baseAdapter);





        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        // Load ads into Interstitial Ads


        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                displayInterstitial();
            }
        });



    }

    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {









    }
    public void onClick(View v) {
        new MaterialStyledDialog.Builder(this)
                .setTitle("Thank You For Trying Our App ! Review Us On Play Store")
                .setDescription("Developer:Japan Gor")
                .setIcon(R.mipmap.ic_launcher)
                //.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_launcher))
                .show();
    }
    public void play(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.japangor.learntocode"));
        startActivity(intent);
    }
    public void moreapps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6356826102828277953&hl=en\n"));
        startActivity(intent);
    }
}
