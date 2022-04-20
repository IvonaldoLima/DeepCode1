package com.ipl.aula6_configuracaoroom.data;

import com.ipl.aula6_configuracaoroom.model.UsuarioEntity;

import java.util.List;

public interface AsyncTaskCallback {

    void onPostExecuteCallback(List<UsuarioEntity> listUsuarios);
}
