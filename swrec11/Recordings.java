package com.lewisswrec.swrec11;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;


public class Recordings extends AppCompatActivity {
    private static final String FILE_NAME = "facebook.txt";
    TextView fbtextViews;

    private static final String TAG = "MEDIA";
    private int requestCode;
    private int grantResults[];


    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},requestCode);
            onRequestPermissionsResult(requestCode,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},grantResults);

        }
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recordings);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);






            ImageButton fbBtn = (ImageButton) findViewById(R.id.Facebookbutton);
            ImageButton scBtn = (ImageButton) findViewById(R.id.Snap);
            ImageButton mesBtn = (ImageButton) findViewById(R.id.Mess);
            ImageButton twitBtn = (ImageButton) findViewById(R.id.Twit);
            ImageButton instaBtn = (ImageButton) findViewById(R.id.insta);

            if (UsageStatistics.getUsageStatsList(this).isEmpty()){
                Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                startActivity(intent);
            }


            fbBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    UsageStatistics.printCurrentUsageStatus(Recordings.this);

                    File path =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                    Toast.makeText(getApplication().getBaseContext(),"Facebook.txt is saved to downloads", Toast.LENGTH_LONG).show();



                    Process process = null;
                    try {
                        process = Runtime.getRuntime().exec("logcat -d ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                    StringBuilder log=new StringBuilder();
                    String line = "/n";
                    try {
                        while ((line = bufferedReader.readLine()) != null) {
                            log.append(line);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    TextView tv = (TextView)findViewById(R.id.fbtextView);
                    tv.setText(log.toString());

                    path.mkdirs();

                    File file= new File(path,"Facebook.txt");

                    FileOutputStream os;
                    try {
                        os= new FileOutputStream(file);
                        String data =log.toString();
                        os.write(data.getBytes());
                        os.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });


            scBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    UsageStatistics.printSnapStatus(Recordings.this);
                    File path =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                    Toast.makeText(getApplication().getBaseContext(),"Snapchat.txt is saved to downloads", Toast.LENGTH_LONG).show();

                    try {
                        Process process = Runtime.getRuntime().exec("logcat -d ");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                        StringBuilder log=new StringBuilder();
                        String line = "/n";
                        while ((line = bufferedReader.readLine()) != null) {
                            log.append(line);

                        }
                        TextView tv1 = (TextView)findViewById(R.id.snaptextView);
                        tv1.setText(log.toString());

                        path.mkdirs();

                        File file= new File(path,"snapchat.txt");

                        FileOutputStream os;
                        try {
                            os= new FileOutputStream(file);
                            String data =log.toString();
                            os.write(data.getBytes());
                            os.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    } catch (IOException e) {
                        // Handle Exception
                    }

                }
            });



            twitBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    UsageStatistics.printTwitterStatus(Recordings.this);
                    File path =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                    Toast.makeText(getApplication().getBaseContext(),"Twitter.txt is saved to downloads", Toast.LENGTH_LONG).show();

                    try {
                        Process process = Runtime.getRuntime().exec("logcat -d ");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                        StringBuilder log=new StringBuilder();
                        String line = "/n";
                        while ((line = bufferedReader.readLine()) != null) {
                            log.append(line);

                        }
                        TextView tv2 = (TextView)findViewById(R.id.twittextView);
                        tv2.setText(log.toString());

                        path.mkdirs();

                        File file= new File(path,"Twitter.txt");

                        FileOutputStream os;
                        try {
                            os= new FileOutputStream(file);
                            String data =log.toString();
                            os.write(data.getBytes());
                            os.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        // Handle Exception
                    }

                }
            });

            mesBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    UsageStatistics.printMessStatus(Recordings.this);
                    File path =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                    Toast.makeText(getApplication().getBaseContext(),"Messenger.txt is saved to downloads", Toast.LENGTH_LONG).show();

                    try {
                        Process process = Runtime.getRuntime().exec("logcat -d ");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                        StringBuilder log=new StringBuilder();
                        String line = "/n";
                        while ((line = bufferedReader.readLine()) != null) {
                            log.append(line);

                        }
                        TextView tv3 = (TextView)findViewById(R.id.messtextView);
                        tv3.setText(log.toString());

                        path.mkdirs();

                        File file= new File(path,"Messenger.txt");

                        FileOutputStream os;
                        try {
                            os= new FileOutputStream(file);
                            String data =log.toString();
                            os.write(data.getBytes());
                            os.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        // Handle Exception
                    }

                }
            });


            instaBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    UsageStatistics.printInstaStatus(Recordings.this);
                    File path =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                    Toast.makeText(getApplication().getBaseContext(),"Instagram.txt is saved to downloads", Toast.LENGTH_LONG).show();

                    try {
                        Process process = Runtime.getRuntime().exec("logcat -d ");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                        StringBuilder log=new StringBuilder();
                        String line = "/n";
                        while ((line = bufferedReader.readLine()) != null) {
                            log.append(line);

                        }
                        TextView tv4 = (TextView)findViewById(R.id.instatextView);
                        tv4.setText(log.toString());

                        path.mkdirs();

                        File file= new File(path,"instagram.txt");

                        FileOutputStream os;
                        try {
                            os= new FileOutputStream(file);
                            String data =log.toString();
                            os.write(data.getBytes());
                            os.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        // Handle Exception
                    }

                }
            });





        }




    /*
    * public void writeExternalStorage(View view) {
        if(isExternalStorageWritable() && checkPerm(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            File textFile = new File(Environment.getExternalStorageDirectory(), fileName.getText().toString());
            try {
                FileOutputStream fos = new FileOutputStream((textFile));
                fos.write(fbtextView.getText().toString().getBytes());
                fos.close();

                Toast.makeText(this, "File saved.", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(this, "Cannot Write to External Storage.", Toast.LENGTH_SHORT).show();
        }
    }
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recordings,menu);
        return true;
    }
}