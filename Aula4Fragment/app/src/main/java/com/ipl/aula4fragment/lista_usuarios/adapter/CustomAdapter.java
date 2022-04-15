package com.ipl.aula4fragment.lista_usuarios.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.aula4fragment.R;
import com.ipl.aula4fragment.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.UsuarioViewHolder> {

    private List<Usuario> listaUsuario;

    public CustomAdapter() {
        listaUsuario = new ArrayList<>();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imagemUsuario;
        private final TextView nomeUsuario;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemUsuario = itemView.findViewById(R.id.imagem_usuario);
            nomeUsuario = itemView.findViewById(R.id.nome_usuario);
        }
        public ImageView getImagemUsuario() {
            return imagemUsuario;
        }
        public TextView getNomeUsuario() {
            return nomeUsuario;
        }
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuario.get(position);
        holder.getNomeUsuario().setText(usuario.getNome());
        holder.getImagemUsuario().setImageResource(usuario.getIdImagem());
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public void addUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
        notifyDataSetChanged();
    }
}
