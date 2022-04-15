package com.ipl.aula4fragment.lista_usuarios;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.aula4fragment.R;
import com.ipl.aula4fragment.databinding.FragmentListaUsuarioBinding;
import com.ipl.aula4fragment.lista_usuarios.adapter.CustomAdapter;
import com.ipl.aula4fragment.model.Usuario;

import java.util.Random;

public class ListaUsuarioFragment extends Fragment {

    private FragmentListaUsuarioBinding binding;
    private CustomAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListaUsuarioBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configuraListaUsuario();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void configuraListaUsuario() {
        adapter = new CustomAdapter();
        binding.listaUsuariosRecyclerView.setAdapter(adapter);
        binding.listaUsuariosRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false)
        );
        adapter.addUsuario(new Usuario("Maria", R.drawable.avatar_2));
    }

    public void setTexto(String nomeUsuario) {
        adapter.addUsuario(new Usuario(nomeUsuario, getUsuarioAvatar()));
    }

    private int getUsuarioAvatar() {
        int numeroDandomico = new Random().nextInt(8);
        int avatarUsuarioId = 0;
        switch (numeroDandomico) {
            case 1:
                avatarUsuarioId = R.drawable.avatar_1;
                break;
            case 2:
                avatarUsuarioId = R.drawable.avatar_2;
                break;
            case 3:
                avatarUsuarioId = R.drawable.avatar_3;
                break;
            case 4:
                avatarUsuarioId = R.drawable.avatar_4;
                break;
            default:
                avatarUsuarioId = R.drawable.avatar_5;
        }
        return avatarUsuarioId;
    }
}