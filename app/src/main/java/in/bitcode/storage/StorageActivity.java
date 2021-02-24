package in.bitcode.storage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
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

            //External Storage
            String state = Environment.getExternalStorageState();
            if(!state.equals(Environment.MEDIA_MOUNTED)) {
                return;
            }
            mt("Ext Storage State: " + state);

            File extDir = Environment.getExternalStorageDirectory();
            mt("Ext root dir: " + extDir.getAbsolutePath());



            File extMovies = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            mt("Ext Movies: " + extMovies.getAbsolutePath());

            File appExtDir = getExternalFilesDir(null);
            mt("Ext app dir: " + appExtDir.getAbsolutePath());

            File appExtMovDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES);
            mt("Ext app mov dir: " + appExtMovDir.getAbsolutePath());

            File extCache = getExternalCacheDir();
            mt("Ext cache: " + extCache.getAbsolutePath());


            line();

            for(File file: extDir.listFiles()) {
                mt(file.getAbsolutePath());
            }
            

            /*
            File rootDir = getFilesDir();
            mt("Root: " + rootDir.getAbsolutePath());

            File newFile1 = new File(rootDir, "newfile1.txt");
            if (!newFile1.exists()) {
                newFile1.createNewFile();
            }

            FileOutputStream fout = new FileOutputStream(newFile1);
            fout.write("this is line1\n".getBytes());
            fout.write("this is next line...\n".getBytes());
            fout.close();

            FileInputStream fin = new FileInputStream(newFile1);
            byte[] data = new byte[1204];
            int count;
            while ((count = fin.read(data)) != -1) {
                mt(new String(data, 0, count));
            }
            fin.close();

            File myDir = new File(rootDir, "mydir");
            if (!myDir.exists()) {
                myDir.mkdir();
            }

            File newFile2 = new File(myDir, "newfile2.txt");
            if (!newFile2.exists()) {
                newFile2.createNewFile();
            }

            //myDir.delete(); //works if directory is empty
            //newFile2.delete();

            line();

            String[] filesNames = rootDir.list();
            for (String fileName : filesNames) {
                mt(fileName);
            }

            line();

            File[] files = rootDir.listFiles();
            for (File file : files) {
                mt(file.getAbsolutePath() + " " + file.length() + " " + file.isFile() + " " + file.isDirectory());
                if (file.isDirectory()) {
                    for(File file1: file.listFiles()) {
                        mt("\t" + file1.getAbsolutePath() + " " + file1.length() );
                    }
                }
            }


            File cacheDir = getCacheDir();
            mt("Cache Dir: " + cacheDir.getAbsolutePath());
            */



            /*
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
            */


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void line() {
        mt("----------------------------------");
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        Log.e("tag", text);
    }
}
