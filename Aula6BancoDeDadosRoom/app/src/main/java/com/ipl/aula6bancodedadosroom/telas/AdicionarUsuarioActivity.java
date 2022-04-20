package com.ipl.aula6bancodedadosroom.telas;

import static com.ipl.aula6bancodedadosroom.data.Converter.converteLongParaLocalDate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.ipl.aula6bancodedadosroom.R;
import com.ipl.aula6bancodedadosroom.databinding.ActivityAdicionarUsuarioBinding;
import com.ipl.aula6bancodedadosroom.model.UsuarioEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class AdicionarUsuarioActivity extends AppCompatActivity {

    private ActivityAdicionarUsuarioBinding binding;
    private MaterialDatePicker materialDatePicker;

    private LocalDate dataNascimento = null;
    private int avatarImageId = R.drawable.avatar_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdicionarUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupOnclickListener();
        setAvatarUsuario();
        setupCalendarioDatePicker();
    }

    private void setAvatarUsuario() {
        binding.avatarImagemUsuario.setImageResource(avatarImageId);
    }

    private void setupCalendarioDatePicker() {
        // COmponente vidual que mostra o calendario para o usuário escolher uma data
        materialDatePicker = MaterialDatePicker
                .Builder
                .datePicker()
                .build();
        // Listener fica escutando o calendario e quando o usuário clica no botão ok ele
        // retorna a data em milisegundos
        materialDatePicker.addOnPositiveButtonClickListener(selection -> {
            LocalDate localDate = converteLongParaLocalDate((long) selection);
            dataNascimento = localDate;
            // FOrmata data para ter uma melhor apresentação para o usuário
            String dataFormatada = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(localDate);
            binding.dataNascimento.setText(dataFormatada);
        });
    }

    private void setupOnclickListener() {
        UsuarioEntity usuario = getDadosDoUsuarioNaTela();
        binding.botaoSalvar.setOnClickListener(view -> {
            // TODO: 20/04/2022 Adicionar AsyncTask para salvar usuário no banco de dados
            // new AsyncTaskInserir().execute(usuario)
        });

//
        binding.dataNascimento.setOnClickListener(v -> {
            materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
        });
    }

    private UsuarioEntity getDadosDoUsuarioNaTela() {
        String nome = binding.nomeUsuario.getText().toString();
        String profissao = binding.profissaoUsuario.getText().toString();
        return new UsuarioEntity(nome, profissao, dataNascimento, avatarImageId);
    }

}