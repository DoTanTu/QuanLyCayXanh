package com.example.quanlycayxanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    EditText ed_id, ed_tenKhoaHoc, ed_tenThuongDung, ed_datTa, ed_mauLa;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ed_id = findViewById(R.id.new_ID);
        ed_tenKhoaHoc = findViewById(R.id.new_tenKhoaHoc);
        ed_tenThuongDung = findViewById(R.id.new_tenThuongGoi);
        ed_datTa = findViewById(R.id.new_datTa);
        ed_mauLa = findViewById(R.id.new_maLa);

        btnsave = (Button)findViewById(R.id.button_save_new);
        findViewById(R.id.button_save_new).setOnClickListener(this);
        findViewById(R.id.button_back_list).setOnClickListener(this);

        readGreenTree();

        btnsave.setText("Update");
    }
    private void readGreenTree(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle == null)
            return;
        String id  = bundle.getString("id");

        GreenTreeDAO dao = new GreenTreeDAO(this);
        GreenTree ct = dao.getById(id);

        ed_id.setText(ct.getId());
        ed_tenKhoaHoc.setText(ct.getTenKhoaHoc());
        ed_tenThuongDung.setText(ct.getTenThuongGoi());
        ed_datTa.setText(ct.getDatTa());
        ed_mauLa.setText(ct.getMauLa());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_save_new:
                GreenTreeDAO dao = new GreenTreeDAO(this);
                GreenTree computer = new GreenTree();

                computer.setId(ed_id.getText().toString());
                computer.setTenKhoaHoc(ed_tenKhoaHoc.getText().toString());
                computer.setTenThuongGoi(ed_tenThuongDung.getText().toString());
                computer.setDatTa(ed_datTa.getText().toString());
                computer.setMauLa(ed_mauLa.getText().toString());

                if(btnsave.getText().equals("SAVE"))
                    dao.insert(computer);
                else
                    dao.update(computer);

                Toast.makeText(this, "New employee has been save",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}
