package sg.edu.rp.c346.id19046224.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbsTV, ocbcTV, uobTV;
    String onClickBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbsTV = findViewById(R.id.dbsTV);
        ocbcTV = findViewById(R.id.ocbcTV);
        uobTV = findViewById(R.id.uobTV);

        registerForContextMenu(dbsTV);
        registerForContextMenu(ocbcTV);
        registerForContextMenu(uobTV);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,getString(R.string.website));
        menu.add(0,1,1,getString(R.string.contact));

        if (v.getId() == dbsTV.getId()){
            onClickBank = "dbs";
        }
        else if (v.getId() == ocbcTV.getId()){
            onClickBank = "ocbc";
        }
        else if (v.getId() == uobTV.getId()){
            onClickBank = "uob";
        }
        else{
            onClickBank = "";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            if(onClickBank.equalsIgnoreCase("dbs")){
                Intent intentDBS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentDBS);
            }
            else if (onClickBank.equalsIgnoreCase("uob")){
                Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/default.page"));
                startActivity(intentUOB);
            }
            else if (onClickBank.equalsIgnoreCase("ocbc")){
                Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/group-home.html"));
                startActivity(intentOCBC);
            }

        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            if(onClickBank.equalsIgnoreCase("dbs")){
                Intent intentDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 63272265));
                startActivity(intentDBS);
            }
            else if (onClickBank.equalsIgnoreCase("uob")){
                Intent intentUOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 62222121));
                startActivity(intentUOB);
            }
            else if (onClickBank.equalsIgnoreCase("ocbc")){
                Intent intentOCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 65381111));
                startActivity(intentOCBC);
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.eng) {
            dbsTV.setText(getString(R.string.dbs));
            ocbcTV.setText(getString((R.string.ocbc)));
            uobTV.setText(getString((R.string.uob)));
            return true;
        } else if (id == R.id.chi) {
            dbsTV.setText(getString(R.string.Cdbs));
            ocbcTV.setText(getString(R.string.Cocbc));
            uobTV.setText(getString(R.string.Cuob));
            return true;
        } else {
            dbsTV.setText("Error translation");
            ocbcTV.setText("Error translation");
            uobTV.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }








}
