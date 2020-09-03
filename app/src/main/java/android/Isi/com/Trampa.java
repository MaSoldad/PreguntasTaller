package android.Isi.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Trampa extends AppCompatActivity {

    public static String EXTRA_RESPUESTA = "android.Isi.com.respuesta";

    public static Intent newIntent(Context context, boolean esCorrecto){
        Intent intent = new Intent(context, Trampa.class);
        intent.putExtra(EXTRA_RESPUESTA, esCorrecto);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trampa);

        boolean result = getIntent().getBooleanExtra("respuesta", false);
    }


}