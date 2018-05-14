package com.example.padelwear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wear.widget.CircularProgressLayout;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Miguel Á. Núñez on 13/05/2018.
 */
public class CuentaAtras extends Activity implements View.OnClickListener, CircularProgressLayout.OnTimerFinishedListener {
    private CircularProgressLayout circularProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuenta_atras);
        circularProgress = findViewById(R.id.circular_progress);
        circularProgress.setOnTimerFinishedListener(this);
        circularProgress.setOnClickListener(this);
        circularProgress.setTotalTime(2000);
        circularProgress.startTimer();
    }

    @Override
    public void onTimerFinished(CircularProgressLayout layout) {
        Intent i = getIntent();
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view.equals(circularProgress)) {
            circularProgress.stopTimer();
            Intent i = getIntent();
            setResult(RESULT_CANCELED, i);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Accion cancelada", Toast.LENGTH_SHORT).show();
        } else if (resultCode == RESULT_OK) {
            Toast.makeText(this, "Accion aceptada", Toast.LENGTH_SHORT).show();
            //Guardamos datos de partida
            finish();
        }
    }
}