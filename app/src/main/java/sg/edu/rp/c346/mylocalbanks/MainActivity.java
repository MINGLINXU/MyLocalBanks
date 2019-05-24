package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    int mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.DBS);
        tvOCBC = findViewById(R.id.OCBC);
        tvUOB = findViewById(R.id.UOB);


        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank"
        );
        if(v.getId()== R.id.DBS){
            mood =1;
        }else if(v.getId() == R.id.OCBC){
            mood = 2;
        }
        else if(v.getId() == R.id.UOB){
            mood = 3;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d("error",""+item.getItemId());
        if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
            Log.d("error2",""+mood);
            //code for action
            if (mood == 1) {
                Intent dbsW = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(dbsW);
            } else if (mood == 2) {
                Intent ocbcW = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(ocbcW);
            } else if (mood == 3) {
                Intent uobW = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(uobW);
            }
        }

        else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action

                if (mood == 1) {
                    Intent dbsC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1800 + 1111111));
                    startActivity(dbsC);
                } else if (mood == 2) {
                    Intent ocbcC = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: " + 1800 + 3633333));
                    startActivity(ocbcC);
                } else if (mood == 3) {
                    Intent uobC = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: " + 1800 + 3633333));
                    startActivity(uobC);

                }
            }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS ");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        }else if(id== R.id.chineseSelection){
            tvDBS.setText("星展银行 ");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }



        return super.onOptionsItemSelected(item);
    }

}
