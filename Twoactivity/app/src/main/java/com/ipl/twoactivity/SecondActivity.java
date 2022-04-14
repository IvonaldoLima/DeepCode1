package com.ipl.twoactivity;

import static com.ipl.twoactivity.MainActivity.ID_SEND_MENSAGEM;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String ID_REPLY_MENSAGEM ="mensagem_retorno";
    private TextView mensagemRecebida;
    private EditText replyMessage;
    private Button replyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setupView();
        setupOnClickListener();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String mensagem = bundle.getString(ID_SEND_MENSAGEM);
            if (mensagem != null) {
                mensagemRecebida.setText(mensagem);
            }
        }

        Intent intent = getIntent();
        String action = intent.getAction();
        if (action != null && intent.getAction().equals(Intent.ACTION_SEND)) {
            if (intent.getType().equals("text/plain")) {
                String extraText = intent.getStringExtra(Intent.EXTRA_TEXT);
                mensagemRecebida.setText(extraText);
            }
        }
    }

    private void setupView() {
        mensagemRecebida = findViewById(R.id.textView_mensagem_recebida);
        replyMessage = findViewById(R.id.editText_reply_mesage);
        replyButton = findViewById(R.id.button_reply);
    }

    private void setupOnClickListener() {
        replyButton.setOnClickListener(view -> {
            createIntentDeRetorno();
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        createIntentDeRetorno();
        return true;
    }

    private void createIntentDeRetorno() {
        String mensagemRetorno = replyMessage.getText().toString();
        Intent intentRetorno = new Intent();
        intentRetorno.putExtra(ID_REPLY_MENSAGEM, mensagemRetorno);
        setResult(Activity.RESULT_OK, intentRetorno);
        finish();
    }
}