package com.ipl.aula5_asynctask.lista_senhas.task_gerar_senhas;

import android.os.AsyncTask;

import com.ipl.aula5_asynctask.model.ConfiguracaoGerarSenha;
import com.ipl.aula5_asynctask.model.GeradorDeSenha;

public class TaskGerarSenhas extends AsyncTask<ConfiguracaoGerarSenha, String, Float> {

    private TaskListener taskListener;

    public TaskGerarSenhas(TaskListener taskListener) {
        this.taskListener = taskListener;
    }
    @Override
    protected Float doInBackground(ConfiguracaoGerarSenha... configuracaoGerarSenhas) {
        ConfiguracaoGerarSenha configuracao = configuracaoGerarSenhas[0];
        for (int i = 0; i < configuracao.getQuantidadeDeSenhas(); i++) {
            String novaSenha = new GeradorDeSenha().gerarSenha(
                    configuracao.getTamanhoDaSenha(),
                    configuracao.getUsarLetraMaiscula(),
                    configuracao.getUsarLetraMinuscula(),
                    configuracao.getUsarLetraNumero(),
                    configuracao.getUsarLetraCaracterEspecial());
            publishProgress(novaSenha);

//            Aguarda dois segundos antes de carregar a próxima senha
//            descomente este bloco e execute a aplicação para verificar o resultado na tela de listar senhas
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        taskListener.onProgressUpdate(values[0]);
    }

    public interface TaskListener {
        void onProgressUpdate(String senha);
    }
}
