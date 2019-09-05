package matc89.exercicio1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView label;

    @Override
    protected void onDestroy() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Log.v("destroy", label.getText().toString());
        prefs.edit().putString("nome", label.getText().toString()).apply();

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        this.label = findViewById(R.id.labelMensagem);
        final EditText input = findViewById(R.id.editNome);
        final Button button =  findViewById(R.id.btnCumprimentar);
        if (prefs.contains("nome")) {
            Log.v("destroy", prefs.getString("nome", ""));
            final String oldText = prefs.getString("nome", "");
            label.setText(oldText);
            prefs.edit().remove("nome").apply();
        } else {
            Log.v("destroy", "false");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String newText = "Alô, " + input.getText().toString() + "!";
                label.setText(newText);
            }
        });
    }
}
