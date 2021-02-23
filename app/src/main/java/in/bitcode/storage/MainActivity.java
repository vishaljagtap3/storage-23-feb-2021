package in.bitcode.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("my_prefs", Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", "BitCode");
        editor.putInt("code", 1908);
        editor.commit();

        String name = prefs.getString("name", "Not Available");
        int code = prefs.getInt("code", 0);
        int val = prefs.getInt("new_code", -1);

        mt(name + " " + code + " " + val);


        prefs = getPreferences(Activity.MODE_PRIVATE);
        editor = prefs.edit();
        editor.putInt("val", 200);
        editor.putString("str", "Pune");
        editor.commit();

        mt(prefs.getInt("val", -1) + " " + prefs.getString("str", "NA"));



    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        Log.e("tag", text);
    }
}