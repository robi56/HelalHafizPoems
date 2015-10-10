package waterfallit.com.helalhafizpoems;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> poems = new ArrayList<>();
    private ListView poemListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoadPoems();
        poemListView = (ListView)findViewById(R.id.listView);
        final TextView tv = (TextView) findViewById(R.id.textView);
        final  View backView = findViewById(R.id.backview);
        backView.setBackgroundColor(Color.BLACK);
        tv.setText("যে জলে আগুন জ্বলে" );
        tv.setTextColor(Color.BLACK);
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello Amran", Toast.LENGTH_SHORT).show();
//                tv.setText("Hi SM AMRAN How ARE You");
//                final String appPackageName = "com.ea.game.fifa15_row";
//                try {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//                } catch (android.content.ActivityNotFoundException anfe) {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//                }
//            }
//        });

        final Context context = this;

//        final ImageView iv = (ImageView) findViewById(R.id.imageViewPopUp);
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iv.setBackground(new Drawable() {
//                    @Override
//                    public void draw(Canvas canvas) {
//                        canvas.drawColor(Color.MAGENTA);
//                    }
//
//                    @Override
//                    public void setAlpha(int alpha) {
//                        setAlpha(50);
//                    }
//
//                    @Override
//                    public void setColorFilter(ColorFilter colorFilter) {
//
//                    }
//
//                    @Override
//                    public int getOpacity() {
//                        return 0;
//                    }
//                });
//
//                Intent intent = new Intent(context, Main2Activity.class);
//                startActivity(intent);
//            }
//        });
        poemListView.setAdapter(new CustomAdapter(this, poems));
        //     poemListView.setBackgroundColor(Color.TRANSPARENT);
        // poemListView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.listbg_more));
        //  poemListView.setBackgroundResource(R.drawable.singlepoembackground);

    }

    private void getLoadPoems() {

        ArrayList<String> poems =JSONReader.getPoemListByPoet(this, "das");

        System.out.println("Total Poems"+ poems.get(0));

        this.poems = poems;
        //   this.poems.add("বনলতা সেন");
//        this.poems.add("হাজার বছর ধরে");
//        this.poems.add("বাংলাদেশ");
//        this.poems.add("বনলতা সেন");
//        this.poems.add("হাজার বছর ধরে");
//        this.poems.add("বাংলাদেশ");
//        this.poems.add("বনলতা সেন");
//        this.poems.add("হাজার বছর ধরে");
//        this.poems.add("বাংলাদেশ");
//        this.poems.add("বনলতা সেন");
//        this.poems.add("হাজার বছর ধরে");
//        this.poems.add("বাংলাদেশ");
//        this.poems.add("বনলতা সেন");
//        this.poems.add("হাজার বছর ধরে");
//        this.poems.add("বাংলাদেশ");

    }


}