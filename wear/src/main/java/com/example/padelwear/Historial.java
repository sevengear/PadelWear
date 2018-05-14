package com.example.padelwear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;

/**
 * Created by Miguel Á. Núñez on 13/05/2018.
 */
public class Historial extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector2d);
        final GridViewPager paginador = findViewById(R.id.paginador);
        paginador.setAdapter(new AdaptadorGridPager(this, getFragmentManager()));
    }
}
