package waterfallit.com.helalhafizpoems;

import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.view.*;
import  android.util.*;


import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity implements View.OnTouchListener {

    TextView poemTitle, poetName, poemBody;
    final static float STEP = 200;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.color.imageBackground);

        poemTitle = (TextView) findViewById(R.id.poemTitle);
        poemBody = (TextView) findViewById(R.id.poemBody);

       // poemBody.setBackgroundColor(Color.rgb(248, 232, 248));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("PoemTitle");
            if(value != null)
                poemTitle.setText(value);
           JSONObject retrivedPoem  = JSONReader.getPoemByPoemTitle(this, value);

            if (retrivedPoem!= null){

                try {
                    String poemDes = retrivedPoem.getString("poemBody").toString();
                    if (poemDes!=null)
                    poemBody.setText(poemDes);

                }
                catch (Exception e){}

            }
         }

//        ScaleGestureDetector scaleGD = new ScaleGestureDetector(this, new simpleOnScaleGestureListener());
//        mTextView.setOnTouchListener(new OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(event.getPointerCount() == 1){
//                    //stuff for 1 pointer
//                }else{ //when 2 pointers are present
//                    switch (event.getAction()) {
//                        case MotionEvent.ACTION_DOWN:
//                            // Disallow ScrollView to intercept touch events.
//                            v.getParent().requestDisallowInterceptTouchEvent(true);
//                            scaleGD.onTouchEvent(event);
//                            break;
//
//                        case MotionEvent.ACTION_MOVE:
//                            // Disallow ScrollView to intercept touch events.
//                            v.getParent().requestDisallowInterceptTouchEvent(true);
//                            scaleGD.onTouchEvent(event);
//                            break;
//
//                        case MotionEvent.ACTION_UP:
//                            // Allow ScrollView to intercept touch events.
//                            v.getParent().requestDisallowInterceptTouchEvent(false);
//                            break;
//                    }
//                }
//                return true;
//            }
//        });
//        public class simpleOnScaleGestureListener extends SimpleOnScaleGestureListener {
//
//            @Override
//            public boolean onScale(ScaleGestureDetector detector) {
//                float size = codedText.getTextSize();
//                float factor = detector.getScaleFactor();
//                int increase = 0;
//                if(factor > 1.0f)
//                    increase = 2;
//                else if(factor < 1.0f)
//                    increase = -2;
//
//                size += increase;
//
//                codedText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
//                plainText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //remembering the favourable text size
//                Editor edit = sp.edit();
//                edit.putFloat("TXTSIZE", size);
//                edit.commit();
//                return true;
//            }
//        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getPointerCount() == 2) {
            int action = event.getAction();
            int pureaction = action & MotionEvent.ACTION_MASK;
            if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
                mBaseDist = getDistance(event);
                mBaseRatio = mRatio;
            } else {
                float delta = (getDistance(event) - mBaseDist) / STEP;
                float multi = (float) Math.pow(2, delta);
                mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
                poemBody.setTextSize(mRatio + 13);
            }
        }
        return true;

    }

    int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }
}
