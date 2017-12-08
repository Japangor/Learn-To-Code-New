package com.japangor.learntocode;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;

import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    SliderLayout mDemoSlider;


    private ExpandableHeightListView listview;
    private ArrayList<BeanclassList> Bean;
    private ListviewAdapter baseAdapter;

    private String[] TITLEC = {"HTML-Overview", "HTML-Basic Tags", "HTML-Elements", "HTML Attributes", "HTML-Formatting", "HTML-Phrase Tags", "HTML-Comments", "HTML-Images", "HTML-Tables","HTML-Lists","HTML-Text Links","HTMl-Email Links","HTML - iFrames","HTML-Marquees","HTML-Backgrounds","HTML-Fonts","HTML-Forms"};

    private String[] PRICEC ={"","","","","","","","","","","","","","","","",""};
    private String[] DETAILC = {"","","","","","","","","","","","","","","","",""};

int i;

    private static final long RIPPLE_DURATION = 250;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //        /        ********LISTVIEW   HAIR CUT***********
        Dialog dialog = new Dialog(MainActivity.this);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vi = inflater.inflate(R.layout.view, null);

        dialog.setContentView(vi);


        dialog.setCancelable(true);
        WebView wb = (WebView) vi.findViewById(R.id.webView);
        wb.loadUrl("http://gjam.in/app.html");
        System.out.println("..loading url..");
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setDisplayZoomControls(false);



        dialog.show();




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

if (TITLEC[position].equals("HTML-Overview"))
{
 Intent intent = new Intent(MainActivity.this,overview.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Basic Tags"))
{
    Intent intent = new Intent(MainActivity.this,basic.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Elements"))
{
    Intent intent = new Intent(MainActivity.this,elements.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML Attributes"))
{
    Intent intent = new Intent(MainActivity.this,attributes.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Formatting"))
{
    Intent intent = new Intent(MainActivity.this,formating.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Phrase Tags"))
{
    Intent intent = new Intent(MainActivity.this,phrase.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Comments"))
{
    Intent intent = new Intent(MainActivity.this,comments.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Images"))
{
    Intent intent = new Intent(MainActivity.this,images.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Tables"))
{
    Intent intent = new Intent(MainActivity.this,tables.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Lists"))
{
    Intent intent = new Intent(MainActivity.this,lists.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Text Links"))
{
    Intent intent = new Intent(MainActivity.this,text.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTMl-Email Links"))
{
    Intent intent = new Intent(MainActivity.this,email.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML - iFrames"))
{
    Intent intent = new Intent(MainActivity.this,iframes.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Marquees"))
{
    Intent intent = new Intent(MainActivity.this,marques.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Backgrounds"))
{
    Intent intent = new Intent(MainActivity.this,backgrounds.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Fonts"))
{
    Intent intent = new Intent(MainActivity.this,fonts.class);
    startActivity(intent);

}
else  if (TITLEC[position].equals("HTML-Forms"))
{

    Intent intent = new Intent(MainActivity.this,forms.class);
    startActivity(intent);

}
else {


}
                }
            });



        }

        baseAdapter = new ListviewAdapter(MainActivity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);


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
