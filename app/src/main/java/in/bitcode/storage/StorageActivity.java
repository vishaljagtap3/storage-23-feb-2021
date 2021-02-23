package in.bitcode.storage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.annotation.Nullable;

public class StorageActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            FileOutputStream fout = openFileOutput("myfile1.txt", Activity.MODE_PRIVATE | Activity.MODE_APPEND);
            fout.write("this is sample text".getBytes());
            fout.close();

            FileInputStream fin = openFileInput("myfile1.txt");
            byte [] data = new byte[1024];
            int count;

            while( (count = fin.read(data)) != -1) {
                mt(new String(data, 0, count));
            }

            fin.close();

            openFileOutput("test", Activity.MODE_PRIVATE).close();

            File  mydir = getDir("mydir", Activity.MODE_PRIVATE);

            String [] fileNames = fileList();
            for(String fileName : fileNames) {
                mt(fileName);
            }

            deleteFile("myfile1.txt");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        Log.e("tag", text);
    }
}
