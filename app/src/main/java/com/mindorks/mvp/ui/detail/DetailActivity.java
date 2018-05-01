package com.mindorks.mvp.ui.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.mvp.R;
import com.mindorks.mvp.model.Dosen;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements DetailMvpView{

    private TextView tvNama, tvEmail, tvRuangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        Dosen dosen = (Dosen) args.getSerializable("DOSEN");

        tvNama = (TextView) findViewById(R.id.tv_nama_dosen);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvRuangan = (TextView) findViewById(R.id.tv_ruangan);

        tvNama.setText(dosen.getNama());
        tvEmail.setText(dosen.getEmail());
        tvRuangan.setText(dosen.getRuangkerja());
    }
}
