package com.ipl.aula6bancodedadosroom.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.aula6bancodedadosroom.databinding.ItemListaUsuarioBinding;
import com.ipl.aula6bancodedadosroom.model.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarioAdapter extends RecyclerView.Adapter<ListaUsuarioAdapter.UsuarioViewHolder> {

    List<UsuarioEntity> usuarios;
    RecyclerViewCallback callback;

    public ListaUsuarioAdapter(RecyclerViewCallback callback) {
        usuarios = new ArrayList<>();
        this.callback = callback;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListaUsuarioBinding binding = ItemListaUsuarioBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UsuarioViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        UsuarioEntity usuario = usuarios.get(position);
        holder.binding.nomeUsuario.setText(usuario.getNome());
        holder.binding.profissaoUsuario.setText(usuario.getProfissao());
        holder.binding.dataNascimento.setText(usuario.getDataDeNascimento().toString());
        holder.binding.excluirUsuario.setOnClickListener(view -> {
            callback.onClickExcluirUsuario(usuario);
        });
        holder.binding.imagemUsuario.setImageResource(usuario.getAvatarImageId());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public void addUsuario(UsuarioEntity usuarioEntity) {
        usuarios.add(usuarioEntity);
        notifyDataSetChanged();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        private final ItemListaUsuarioBinding binding;

        public UsuarioViewHolder(@NonNull ItemListaUsuarioBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface RecyclerViewCallback {
        void onClickExcluirUsuario(UsuarioEntity usuarioParaDeletar);
    }
}
