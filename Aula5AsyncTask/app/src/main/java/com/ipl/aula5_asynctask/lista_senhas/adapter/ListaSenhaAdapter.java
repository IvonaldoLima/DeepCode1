package com.ipl.aula5_asynctask.lista_senhas.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.aula5_asynctask.databinding.ItemSenhaBinding;

import java.util.ArrayList;
import java.util.List;

public class ListaSenhaAdapter extends RecyclerView.Adapter<ListaSenhaAdapter.SenhaViewHolder> {

    private final List<String> listaSenha;
    private final OnClickItemList onCLickItemList;

    public ListaSenhaAdapter(OnClickItemList onCLickItemList) {
        listaSenha = new ArrayList<>();
        this.onCLickItemList = onCLickItemList;
    }

    public void addSenhaNaLista(String senha) {
        listaSenha.add(senha);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListaSenhaAdapter.SenhaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @NonNull ItemSenhaBinding biding = ItemSenhaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SenhaViewHolder(biding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaSenhaAdapter.SenhaViewHolder holder, int position) {
        String senha = listaSenha.get(position);
        ItemSenhaBinding biding = holder.getBiding();
        biding.textViewSenha.setText(senha);
        biding.cardSenha.setOnClickListener(v -> {
            onCLickItemList.onClick(senha);
        });
    }

    @Override
    public int getItemCount() {
        return listaSenha.size();
    }

    public static class SenhaViewHolder extends RecyclerView.ViewHolder {
        private final ItemSenhaBinding biding;

        public SenhaViewHolder(@NonNull ItemSenhaBinding biding) {
            super(biding.getRoot());
            this.biding = biding;
        }

        public ItemSenhaBinding getBiding() {
            return biding;
        }
    }

    public interface OnClickItemList {
        void onClick(String senha);
    }
}
