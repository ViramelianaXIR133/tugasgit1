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
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etnama;
    Button bOK;
    TextView tvjurusan;
    TextView tvnama;
    TextView tvradio;
    TextView spiner;
    TextView tvhasil2;
    Spinner spkota;
    int njurusan;
    RadioGroup rgstatus;
    CheckBox cb1, cb2, cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgstatus = (RadioGroup) findViewById(R.id.radiogroup);
        bOK = (Button) findViewById(R.id.button);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        etnama = (EditText) findViewById(R.id.editTextnama);
        tvnama = (TextView) findViewById(R.id.textView6);
        tvjurusan = (TextView) findViewById(R.id.textView9);
        tvradio = (TextView) findViewById(R.id.textView10);
        spiner = (TextView) findViewById(R.id.textView11);
        tvhasil2 = (TextView) findViewById(R.id.textView8);
        spkota = (Spinner) findViewById(R.id.spinnerkota);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doMulai();
                doClick();
                doProces();
                doSiap();
            }
        });
    }

    private void doMulai() {
        //String nama = etnama.getText().toString();

        if (etnama.getText().toString().isEmpty()) {
            etnama.setError("Nama Belum Di Isi");
        } else if (etnama.getText().toString().length() < 3) {
            etnama.setError("Nama Minimal 3 Karakter");
        } else {
            etnama.setError(null);
        }
        tvnama.setText("Nama : " + etnama.getText().toString());
    }

    private void doSiap() {
        String hasil = null;
        if (rgstatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgstatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        tvradio.setText("Jenis Kelamin : " + hasil);
    }

    private void doProces() {
        String jurusan = "Jurusan : ";
        int startien = jurusan.length();
        if (cb1.isChecked()) jurusan += cb1.getText() + "\n";
        if (cb2.isChecked()) jurusan += cb2.getText() + "\n";
        if (cb3.isChecked()) jurusan += cb3.getText() + "\n";
        if (jurusan.length() == startien) jurusan += "Tidak ada pilihan";
        tvjurusan.setText(jurusan);
    }

    private void doClick() {
        String asal = spkota.getSelectedItem().toString();
        spiner.setText("Asal : " + asal);
//        tvjurusan.setText("Nama : " + nama + "\n" + "Jenis Kelamin : " + "\n" + hasil + jurusan + "\n" + "Asal" +
//                asal + "Identitas anda akan di kirim ke kota asal anda agar segera di akses.");
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) njurusan += 1;
        else njurusan -= 1;
        tvhasil2.setText("Jurusan ( " + njurusan + "terpilih)");
    }
}
