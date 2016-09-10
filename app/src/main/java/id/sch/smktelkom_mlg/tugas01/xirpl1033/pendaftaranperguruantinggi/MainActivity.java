package id.sch.smktelkom_mlg.tugas01.xirpl1033.pendaftaranperguruantinggi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etnama;
    Button bOK;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = (EditText) findViewById(R.id.editTextnama);
        bOK = (Button) findViewById(R.id.button);
        tvhasil = (TextView) findViewById(R.id.textView6);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etnama.getText().toString();
                tvhasil.setText("Nama : " + nama);
            }
        });
    }


    private boolean isValid() {
        boolean valid = true;
        String nama = etnama.getText().toString();

        if (nama.isEmpty()) {
            etnama.setError("Nama Belum Di Isi");
            valid = false;
        } else if (nama.length() < 3) {
            etnama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }
        return valid;
    }
}
