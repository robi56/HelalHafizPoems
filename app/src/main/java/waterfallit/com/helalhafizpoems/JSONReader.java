package waterfallit.com.helalhafizpoems;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Microsoft on 10/8/2015.
 */
public class JSONReader {

    public static JSONObject getPoemByPoemTitle(Context context, String poemTitle) {
        JSONObject obj = null;
        try {
            obj = new JSONObject(loadJSONFromAsset(context));
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        JSONArray m_jArry = null;
        try {
            m_jArry = obj.getJSONArray("poet");
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        System.out.println("Total Poem"+m_jArry.length());

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = null;

            try {
                jo_inside = m_jArry.getJSONObject(i);
                  String tempPoemTitle = jo_inside.getString("poemTitle");
                if (tempPoemTitle.equals(poemTitle) ){

                    obj = jo_inside;
                    break;
                }
                ;
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            try {
                Log.d("Details: ", "poetName = " + jo_inside.getString("poetName"));
                Log.d("Details: ", "poemTitle = " + jo_inside.getString("poemTitle"));
                //Log.d("Details: ", "poemBody = " + jo_inside.getString("poemBody").length());
                Log.d("Details: ", "poemBody = " + jo_inside.getString("poemBody"));



            } catch (JSONException e1) {
                e1.printStackTrace();
            }

        }
        return obj;
    }


    public static ArrayList<String>  getPoemListByPoet(Context context, String poetName) {

        ArrayList<String> formList = new ArrayList<String>();

        JSONObject obj = null;
        try {
            obj = new JSONObject(loadJSONFromAsset(context));
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        JSONArray m_jArry = null;
        try {
            m_jArry = obj.getJSONArray("poet");
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        HashMap<String, String> m_li;

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = null;
            try {
                jo_inside = m_jArry.getJSONObject(i);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            try {
                Log.d("Details: ", "poetName = " + jo_inside.getString("poetName"));
                Log.d("Details: ", "poemTitle = " + jo_inside.getString("poemTitle"));
                //Log.d("Details: ", "poemBody = " + jo_inside.getString("poemBody").length());
                Log.d("Details: ", "poemBody = " + jo_inside.getString("poemBody"));

                if (jo_inside.getString("poemTitle") != null)
                    formList.add(jo_inside.getString("poemTitle"));


            } catch (JSONException e1) {
                e1.printStackTrace();
            }

        }
        return formList;

    }
    public static ArrayList<JSONObject>  getAllPoemList(Context context){

        ArrayList<JSONObject> formList = new ArrayList<JSONObject>();

        JSONObject obj = null;
        try {
            obj = new JSONObject(loadJSONFromAsset(context));
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        JSONArray m_jArry = null;
        try {
            m_jArry = obj.getJSONArray("poet");
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        HashMap<String, String> m_li;

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = null;
            try {
                jo_inside = m_jArry.getJSONObject(i);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            try {
                Log.d("Details: ", "poetName = " + jo_inside.getString("poetName"));
                Log.d("Details: ", "poemTitle = " + jo_inside.getString("poemTitle"));
                //Log.d("Details: ", "poemBody = " + jo_inside.getString("poemBody").length());
                Log.d("Details: ", "poemBody = " + jo_inside.getString("poemBody"));



            } catch (JSONException e1) {
                e1.printStackTrace();
            }


            formList.add(jo_inside);
        }


        return formList ;
    }
//


    private static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("poem.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
