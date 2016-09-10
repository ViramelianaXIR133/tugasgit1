package id.sch.smktelkom_mlg.tugas01.xirpl1033.pendaftaranperguruantinggi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etnama;
    Button bOK;
    TextView tvhasil;
    TextView tvjurusan;
    TextView tvhobi;
    int nhobi;
    RadioGroup rgstatus;
    String hasil;
    CheckBox cb1, cb2, cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = (EditText) findViewById(R.id.editTextnama);
//        rb1 = (RadioButton) findViewById(R.id.radioButton);
//        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rgstatus = (RadioGroup) findViewById(R.id.radiogroup);
        bOK = (Button) findViewById(R.id.button);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        tvjurusan = (TextView) findViewById(R.id.textView6);
        tvhasil = (TextView) findViewById(R.id.textView6);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etnama.getText().toString();
            //tvhasil.setText("Nama : " + nama);
            if (rgstatus.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgstatus.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvhasil.setText("Belum memilih jenis kelamin");
            } else {
                tvhasil.setText("Nama : " + nama + "\n" + "Jenis Kelamin : " + hasil);
            }
        }
        String jurusan = "Jurusan : ";
        String nama = etnama.getText().toString();
        int startien = jurusan.length();
        if (cb1.isChecked()) jurusan += cb1.getText() + "\n";
        if (cb2.isChecked()) jurusan += cb2.getText() + "\n";
        if (cb3.isChecked()) jurusan += cb3.getText() + "\n";
        if (jurusan.length() == startien) jurusan += "Tidak ada pilihan";
        tvjurusan.setText("Nama : " + nama + "\n" + "Jenis Kelamin : " + "\n" + hasil + jurusan);
    }

    //
    private boolean isValid() {
        boolean valid = true;
        String nama = etnama.getText().toString();

        if (nama.isEmpty()) {
            etnama.setError("Nama Belum Di Isi");
            valid = false;
        } else if (nama.length() < 3) {
            etnama.setError("Nama Minimal 3 Karakter");
            valid = false;
        }

        //String hasil = null;

        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if (isChecked)  nhobi+=1;
//        else nhobi -= 1;
//
//        tvhobi.setText("Jurusan : "+ nhobi);
    }
}
