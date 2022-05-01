package com.ipl.professorallocation.view.alocar_professor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.ipl.professorallocation.data.repositorio.AlocacaoRepositorio;
import com.ipl.professorallocation.data.repositorio.CursoRepositorio;
import com.ipl.professorallocation.data.repositorio.ProfessorRepositorio;
import com.ipl.professorallocation.data.service.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityAddEditAlocacaoProfessorBinding;
import com.ipl.professorallocation.model.AllocationRequest;
import com.ipl.professorallocation.model.AllocationsItem;
import com.ipl.professorallocation.model.DiasDaSemana;
import com.ipl.professorallocation.model.Professor;
import com.ipl.professorallocation.model.curso.Curso;
import com.ipl.professorallocation.view.add_edit_professor.AddEditProfessorActivity;

import java.time.LocalTime;
import java.util.List;

public class AddEditAlocacaoProfessorActivity extends AppCompatActivity {

    private ActivityAddEditAlocacaoProfessorBinding binding;
    private ArrayAdapter<Curso> cursoArrayAdapter;
    private ArrayAdapter<DiasDaSemana> diasDaSemanaArrayAdapter;
    private ArrayAdapter<Professor> professorArrayAdapter;
    private CursoRepositorio cursoRepositorio;
    private ProfessorRepositorio professorRepositorio;
    private AlocacaoRepositorio alocacaoRepositorio;
    private MaterialTimePicker timePicker;
    private int campoDeHoraQueIniciouTimePick;
    private static final int HORA_INICIO = 0;
    private static final int HORA_FIM = 1;
    private Curso cursoSelecionado;
    private Professor professorSelecionado;
    private DiasDaSemana diaDaSemanaSelecionado;

    private LocalTime timeInicoSelecionada;
    private LocalTime timeFimSelecionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditAlocacaoProfessorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cursoRepositorio = new CursoRepositorio();
        professorRepositorio = new ProfessorRepositorio();
        alocacaoRepositorio = new AlocacaoRepositorio();
        setupOnClickListener();
        setupSpinnerListaCurso();
        setupSpinnerListaProfessor();
        setupSpinnerDiaDaSemana();
        listarCursos();
        listarProfessores();
        setupCalendarioDatePicker();
    }

    private void setupCalendarioDatePicker() {
        // COmponente vidual que mostra o calendario para o usuário escolher uma data
        timePicker = new MaterialTimePicker
                .Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(10)
                .build();
        // Listener fica escutando o calendario e quando o usuário clica no botão ok ele
        // retorna a data em milisegundos
        timePicker.addOnPositiveButtonClickListener(selection -> {
            if (campoDeHoraQueIniciouTimePick == HORA_INICIO) {
                String timeInicio = timePicker.getHour() + ":" + timePicker.getMinute();
                timeInicoSelecionada = LocalTime.parse(timeInicio);
                binding.horaDeInicio.setText(timeInicio);
            } else {
                String timefim = timePicker.getHour() + ":" + timePicker.getMinute();
                timeFimSelecionado = LocalTime.parse(timefim);
                binding.horaFim.setText(timefim);
            }
        });
    }

    private void setupOnClickListener() {
        binding.salvarAlocacao.setOnClickListener(view -> {
            mostrarProgressBar(View.VISIBLE);
            alocacaoRepositorio.criarAlocacao(getAllocationRequest(), new RespositorioCallBack<AllocationsItem>() {
                @Override
                public void onResponse(AllocationsItem response) {
                    mostrarProgressBar(View.INVISIBLE);
                    Toast.makeText(AddEditAlocacaoProfessorActivity.this, "Alocação criado.", Toast.LENGTH_LONG).show();
                    finish();
                }

                @Override
                public void onFailure(Throwable t) {
                    mostrarProgressBar(View.INVISIBLE);
                    Log.d("IPL2", "onFailure: " + t);
                }
            });
        });
        binding.horaDeInicio.setOnClickListener(v -> {
            campoDeHoraQueIniciouTimePick = HORA_INICIO;
            timePicker.show(getSupportFragmentManager(), "TIME_PICKER");
        });
        binding.horaFim.setOnClickListener(v -> {
            campoDeHoraQueIniciouTimePick = HORA_FIM;
            timePicker.show(getSupportFragmentManager(), "TIME_PICKER");
        });
    }

    @NonNull
    private AllocationRequest getAllocationRequest() {
        int cursoId = cursoSelecionado.getId();
        int professorId = professorSelecionado.getId();
        String diaDaSemana = diaDaSemanaSelecionado.name();

        AllocationRequest allocationRequest = new AllocationRequest(cursoId, diaDaSemana, timeInicoSelecionada, timeFimSelecionado, professorId);
        return allocationRequest;
    }

    private void setupSpinnerListaCurso() {
        cursoArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        binding.spinnerCurso.setAdapter(cursoArrayAdapter);
        binding.spinnerCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cursoSelecionado = cursoArrayAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(AddEditAlocacaoProfessorActivity.this, "onNothingSelected", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void listarCursos() {
        cursoRepositorio.listarCursos(new RespositorioCallBack<List<Curso>>() {
            @Override
            public void onResponse(List<Curso> response) {
                cursoArrayAdapter.addAll(response);

                // Irá setar o departamento no spinner quando estiver editando um professor
//                if (editarProfessor != null) {
//                    departamentoSelecionado = editarProfessor.getDepartment();
//                    int departamentoPosition = departamentoSpinner.getPosition(editarProfessor.getDepartment());
//                    binding.spinnerCurso.setSelection(departamentoPosition, true);
//                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("IPL1", "onFailure: " + t);
            }
        });
    }

    private void setupSpinnerDiaDaSemana() {
        diasDaSemanaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        binding.spinnerDiaDaSemana.setAdapter(diasDaSemanaArrayAdapter);
        diasDaSemanaArrayAdapter.addAll(DiasDaSemana.listarDiasDaSemana());
        binding.spinnerDiaDaSemana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diaDaSemanaSelecionado = diasDaSemanaArrayAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(AddEditAlocacaoProfessorActivity.this, "onNothingSelected", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupSpinnerListaProfessor() {
        professorArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        binding.spinnerProfessor.setAdapter(professorArrayAdapter);
        binding.spinnerProfessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                professorSelecionado = professorArrayAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(AddEditAlocacaoProfessorActivity.this, "onNothingSelected", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void listarProfessores() {
        professorRepositorio.listarProfessores(new RespositorioCallBack<List<Professor>>() {
            @Override
            public void onResponse(List<Professor> response) {
                professorArrayAdapter.addAll(response);

                // Irá setar o departamento no spinner quando estiver editando um professor
//                if (editarProfessor != null) {
//                    departamentoSelecionado = editarProfessor.getDepartment();
//                    int departamentoPosition = departamentoSpinner.getPosition(editarProfessor.getDepartment());
//                    binding.spinnerCurso.setSelection(departamentoPosition, true);
//                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("IPL1", "onFailure: " + t);
            }
        });
    }

    private void mostrarProgressBar(int mostrarProgressBar) {
        binding.progressBar.setVisibility(mostrarProgressBar);
    }
}