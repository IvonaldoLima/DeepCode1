package com.ipl.aula6_configuracaoroom.data;

import android.os.AsyncTask;
import android.util.Log;

import com.ipl.aula6_configuracaoroom.model.UsuarioEntity;

import java.util.List;

public class AsyncTaskListarUsuarios extends AsyncTask<Integer, Float, List<UsuarioEntity>> {

    private AppDatabase database;
    private AsyncTaskCallback asyncTaskCallback;

    public AsyncTaskListarUsuarios(AppDatabase database, AsyncTaskCallback asyncTaskCallback) {
        this.database = database;
        this.asyncTaskCallback = asyncTaskCallback;
    }

    @Override
    protected List<UsuarioEntity> doInBackground(Integer... integers) {
        database.usuarioDao().inserirUsuario(new UsuarioEntity("João"));
        List<UsuarioEntity> usuarios = database.usuarioDao().getTodosOsUsuarios();

        return usuarios;
    }

    @Override
    protected void onPostExecute(List<UsuarioEntity> listaUsuarios) {
        super.onPostExecute(listaUsuarios);
        asyncTaskCallback.onPostExecuteCallback(listaUsuarios);
    }
}
