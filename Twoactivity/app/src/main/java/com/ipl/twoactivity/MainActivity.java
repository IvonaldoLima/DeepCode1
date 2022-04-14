package com.ipl.twoactivity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "IPL123";
    public static final String ID_SEND_MENSAGEM ="mensagem_enviada";
    private TextView textViewMensagemRetorno;
    private EditText editText;
    private Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        setupView();
        setupOnclickListener();
    }

    private void setupView() {
        textViewMensagemRetorno = findViewById(R.id.textView_mensagem_retorno);
        editText = findViewById(R.id.edit_text_send_message);
        buttonSend = findViewById(R.id.button_send);
    }



    private void setupOnclickListener() {
        buttonSend.setOnClickListener(view -> {

            Intent intent = new Intent(this, SecondActivity.class);
            String mensagem = editText.getText().toString();
            intent.putExtra(ID_SEND_MENSAGEM, mensagem);
            activityResultLauncher.launch(intent);

            /*  Intent para abrir o aplicativo de ligação default do telefone
                 passando como parâmetro um número de telefone

              Intent intent = new Intent(Intent.ACTION_DIAL);
              intent.setData(Uri.parse("tel:5555555"));
              startActivity(intent);
             */

            /*  Intent para abrir o browser passando como parâmetro um URL
                String url = "https://www.qualiti.com.br/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
             */
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result.getResultCode() == Activity.RESULT_OK){
                    Intent intent = result.getData();
                    if (intent != null) {
                        String replyMessage = intent.getStringExtra(SecondActivity.ID_REPLY_MENSAGEM);
                        textViewMensagemRetorno.setText(replyMessage);
                    }
                } else if(result.getResultCode() == Activity.RESULT_CANCELED) {
                    // Ação erro
                }
            });

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}