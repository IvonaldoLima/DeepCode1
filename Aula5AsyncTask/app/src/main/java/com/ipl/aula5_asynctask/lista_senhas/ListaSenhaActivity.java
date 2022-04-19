package com.ipl.aula5_asynctask.lista_senhas;

import static com.ipl.aula5_asynctask.MainActivity.ID_QUANTIDADE_SENHA;
import static com.ipl.aula5_asynctask.MainActivity.ID_TAMANHO_SENHA;
import static com.ipl.aula5_asynctask.MainActivity.ID_USAR_CARACTER_ESPECIAL;
import static com.ipl.aula5_asynctask.MainActivity.ID_USAR_LETRA_MAISCULA;
import static com.ipl.aula5_asynctask.MainActivity.ID_USAR_LETRA_MINUSCULA;
import static com.ipl.aula5_asynctask.MainActivity.ID_USAR_NUMERO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.aula5_asynctask.databinding.ActivityListaSenhaBinding;
import com.ipl.aula5_asynctask.lista_senhas.adapter.ListaSenhaAdapter;
import com.ipl.aula5_asynctask.lista_senhas.task_gerar_senhas.TaskGerarSenhas;
import com.ipl.aula5_asynctask.model.ConfiguracaoGerarSenha;

public class ListaSenhaActivity extends AppCompatActivity {

    public static final String ID_MENSAGEM_RECEBIDA = "mensagem_recebida";
    public static final String ID_MENSAGEM_RETORNO = "mensagem_recebida";
    private ActivityListaSenhaBinding binding;
    private ListaSenhaAdapter adapter;

    // Esse listener ficrá recebendo os dados gerados dentro da task
    // As senhas recebidas serão adicionadas dentro da lista (RecyclerView)
    private final TaskGerarSenhas.TaskListener taskListener = senha -> {
        adapter.addSenhaNaLista(senha);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaSenhaBinding.inflate(getLayoutInflater());
        recebendoDadosVindosDaMainActivity();
        setContentView(binding.getRoot());
        configurarRecyclerView();
    }

    private void configurarRecyclerView() {
        adapter = new ListaSenhaAdapter(senha -> {
            Intent intentRetorno = new Intent();
            intentRetorno.putExtra(ID_MENSAGEM_RETORNO, senha);
            setResult(Activity.RESULT_OK, intentRetorno);
            finish();
        });
        binding.listaSenhas.setAdapter(adapter);
        binding.listaSenhas.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void recebendoDadosVindosDaMainActivity() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Integer quantidadeDeSenhas = bundle.getInt(ID_QUANTIDADE_SENHA);
            Integer tamanhoDasSenhas = bundle.getInt(ID_TAMANHO_SENHA);
            boolean usarLetraMaiscula = bundle.getBoolean(ID_USAR_LETRA_MAISCULA);
            boolean usarLetraMinuscula = bundle.getBoolean(ID_USAR_LETRA_MINUSCULA);
            boolean usarNumero = bundle.getBoolean(ID_USAR_NUMERO);
            boolean usarLetraCaracterEspecial = bundle.getBoolean(ID_USAR_CARACTER_ESPECIAL);

            ConfiguracaoGerarSenha configuracaoGerarSenha = gerarConfiguracao(
                    quantidadeDeSenhas,
                    tamanhoDasSenhas,
                    usarLetraMaiscula,
                    usarLetraMinuscula,
                    usarNumero,
                    usarLetraCaracterEspecial
            );
            executarTaskGerarSenhas(configuracaoGerarSenha);
        }
    }

    private void executarTaskGerarSenhas(ConfiguracaoGerarSenha configuracaoGerarSenha) {
        new TaskGerarSenhas(taskListener).execute(configuracaoGerarSenha);
    }

    @NonNull
    private ConfiguracaoGerarSenha gerarConfiguracao(Integer quantidadeDeSenhas, Integer tamanhoDasSenhas, boolean usarLetraMaiscula, boolean usarLetraMinuscula, boolean usarNumero, boolean usarLetraCaracterEspecial) {
        ConfiguracaoGerarSenha configuracaoGerarSenha = new ConfiguracaoGerarSenha();
        configuracaoGerarSenha.setQuantidadeDeSenhas(quantidadeDeSenhas);
        configuracaoGerarSenha.setTamanhoDaSenha(tamanhoDasSenhas);
        configuracaoGerarSenha.setUsarLetraMaiscula(usarLetraMaiscula);
        configuracaoGerarSenha.setUsarLetraMinuscula(usarLetraMinuscula);
        configuracaoGerarSenha.setUsarLetraNumero(usarNumero);
        configuracaoGerarSenha.setUsarLetraCaracterEspecial(usarLetraCaracterEspecial);
        return configuracaoGerarSenha;
    }
}