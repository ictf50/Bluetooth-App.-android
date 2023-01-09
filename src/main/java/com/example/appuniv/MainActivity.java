package com.example.appuniv;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        initbluetooth();
    }
    private void initbluetooth(){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null){
            Toast.makeText(context,"No bluetooth found",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_search_dedvices:
                Toast.makeText(context ,"Clicked search devices", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_enable_bluetooth:
                enablebluetooth();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @SuppressLint("MissingPermission")
    private  void enablebluetooth(){
        if(bluetoothAdapter.isEnabled()){
            Toast.makeText(context ,"Bluetooth already enable", Toast.LENGTH_LONG).show();
        }
        else {
            bluetoothAdapter.enable();
        }
    }
}
