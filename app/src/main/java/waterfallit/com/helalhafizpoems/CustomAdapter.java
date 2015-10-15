package waterfallit.com.helalhafizpoems;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Microsoft on 10/8/2015.
 */
public class CustomAdapter extends BaseAdapter {

    ArrayList<String> poems = new ArrayList<>();
    Context context;
    public  static LayoutInflater inflater = null;
    public CustomAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public CustomAdapter(Context context,ArrayList<String> poems){
        this.context= context;
        this.poems = poems;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return poems.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final TextView textView;
        final View rowView;
        rowView = inflater.inflate(R.layout.singlepoem, null);
    //    rowView.setBackgroundColor(Color.rgb( 248,244,244));

       textView=(TextView) rowView.findViewById(R.id.singleText);
       //rowView.setBackgroundResource(R.drawable.singlepoembackground);

        textView.setText(poems.get(position));
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(context, Main2Activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("PoemTitle", poems.get(position));
                context.startActivity(intent);

//                // Use TaskStackBuilder to build the back stack and get the PendingIntent
//
//                PendingIntent pendingIntent =
//                        TaskStackBuilder.create(context)
//                                // add all of DetailsActivity's parents to the stack,
//                                // followed by DetailsActivity itself
//                                .addNextIntentWithParentStack(intent)
//                                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//
//
//
//                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//// Adds the back stack for the Intent (but not the Intent itself)
//                stackBuilder.addParentStack(MainActivity.class);
//// Adds the Intent that starts the Activity to the top of the stack
//                stackBuilder.addNextIntent(intent);
//                PendingIntent resultPendingIntent =
//                        stackBuilder.getPendingIntent(
//                                0,
//                                PendingIntent.FLAG_UPDATE_CURRENT
//                        );
//             //  mBuilder.setContentIntent(resultPendingIntent);
//
//
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
//                builder.setContentIntent(resultPendingIntent);

            }
        });

        return rowView;


    }



    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


}
