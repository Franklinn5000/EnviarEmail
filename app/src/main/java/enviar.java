import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.myapplication.R;

public class enviar {

    public class MainActivity extends AppCompatActivity {

        EditText txtNome;
        Button btnEmail;
        EditText txtAssunto;
        EditText txtListaEmail;
        EditText txtMensagem;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            txtNome = (EditText)findViewById(R.id.txtAssunto );
            txtAssunto = (EditText)findViewById(R.id.txtAssunto);
            txtListaEmail = (EditText)findViewById(R.id.txtListaEmail);
            txtMensagem = (EditText)findViewById(R.id.txtMensagem);


            btnEmail = (Button)findViewById(R.id.btnEmail);
            btnEmail.setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    String texto = txtListaEmail.getText().toString();
                    String ListaEmail[] = texto.split(";");
                    i.putExtra(Intent.EXTRA_EMAIL  , ListaEmail);
                    i.putExtra(Intent.EXTRA_SUBJECT, txtAssunto.getText().toString());
                    i.putExtra(Intent.EXTRA_TEXT, txtMensagem.getText().toString());

                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }

                    txtAssunto.setText("");
                    txtListaEmail.setText("");
                    txtMensagem.setText("");

                }


            });
        }
    }
}
