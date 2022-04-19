package com.ipl.aula5_asynctask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.ipl.aula5_asynctask.databinding.ActivityMainBinding;
import com.ipl.aula5_asynctask.lista_senhas.ListaSenhaActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ID_QUANTIDADE_SENHA = "id_quantidade_senha";
    public static final String ID_TAMANHO_SENHA = "id_tamanho_senha";
    public static final String ID_USAR_LETRA_MAISCULA = "id_usar_letra_maiscula";
    public static final String ID_USAR_LETRA_MINUSCULA = "id_usar_letra_minuscula";
    public static final String ID_USAR_NUMERO = "id_usar_numero";
    public static final String ID_USAR_CARACTER_ESPECIAL = "id_usar_caracter_especial";

    private ActivityMainBinding binding;
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    if (intent != null) {
                        String replyMessage = intent.getStringExtra(ListaSenhaActivity.ID_MENSAGEM_RETORNO);
                        Toast.makeText(this, replyMessage, Toast.LENGTH_LONG).show();
                    }
                } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                    // Ação erro
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupOnClickListener();
    }

    private void setupOnClickListener() {
        binding.buttonGerarSenha.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListaSenhaActivity.class);
            adicionandoDadosNaIntent(intent);
            activityResultLauncher.launch(intent);
        });
    }

    private void adicionandoDadosNaIntent(Intent intent) {
        Integer quantidadeDeSenhas = Integer.parseInt(binding.editTextQuantidadeDeSenhas.getText().toString());
        Integer tamanhoDaSenha = Integer.parseInt(binding.editTextTamanhoDaSenha.getText().toString());
        boolean usarLetraMaiscula = binding.switchLetraMaiscula.isChecked();
        boolean usarLetraMiniscula = binding.switchLetraMinuscula.isChecked();
        boolean usarNumero = binding.switchNumero.isChecked();
        boolean usarCaracterEspecial = binding.switchCaracterEspecial.isChecked();

        intent.putExtra(ID_QUANTIDADE_SENHA, quantidadeDeSenhas);
        intent.putExtra(ID_TAMANHO_SENHA, tamanhoDaSenha);
        intent.putExtra(ID_USAR_LETRA_MAISCULA, usarLetraMaiscula);
        intent.putExtra(ID_USAR_LETRA_MINUSCULA, usarLetraMiniscula);
        intent.putExtra(ID_USAR_NUMERO, usarNumero);
        intent.putExtra(ID_USAR_CARACTER_ESPECIAL, usarCaracterEspecial);
    }
}