package com.ipl.aula5_asynctask.model;

public class ConfiguracaoGerarSenha {
    private Integer quantidadeDeSenhas;
    private Integer tamanhoDaSenha;
    private boolean usarLetraMaiscula;
    private boolean usarLetraMinuscula;
    private boolean usarLetraNumero;
    private boolean usarLetraCaracterEspecial;

    public ConfiguracaoGerarSenha() {
    }

    public ConfiguracaoGerarSenha(Integer quantidadeDeSenhas, Integer tamanhoDaSenha, boolean usarLetraMaiscula, boolean usarLetraMinuscula, boolean usarLetraNumero, boolean usarLetraCaracterEspecial) {
        this.quantidadeDeSenhas = quantidadeDeSenhas;
        this.tamanhoDaSenha = tamanhoDaSenha;
        this.usarLetraMaiscula = usarLetraMaiscula;
        this.usarLetraMinuscula = usarLetraMinuscula;
        this.usarLetraNumero = usarLetraNumero;
        this.usarLetraCaracterEspecial = usarLetraCaracterEspecial;
    }

    public Integer getQuantidadeDeSenhas() {
        return quantidadeDeSenhas;
    }

    public void setQuantidadeDeSenhas(Integer quantidadeDeSenhas) {
        this.quantidadeDeSenhas = quantidadeDeSenhas;
    }

    public Integer getTamanhoDaSenha() {
        return tamanhoDaSenha;
    }

    public void setTamanhoDaSenha(Integer tamanhoDaSenha) {
        this.tamanhoDaSenha = tamanhoDaSenha;
    }

    public boolean getUsarLetraMaiscula() {
        return usarLetraMaiscula;
    }

    public void setUsarLetraMaiscula(boolean usarLetraMaiscula) {
        this.usarLetraMaiscula = usarLetraMaiscula;
    }

    public boolean getUsarLetraMinuscula() {
        return usarLetraMinuscula;
    }

    public void setUsarLetraMinuscula(boolean usarLetraMinuscula) {
        this.usarLetraMinuscula = usarLetraMinuscula;
    }

    public boolean getUsarLetraNumero() {
        return usarLetraNumero;
    }

    public void setUsarLetraNumero(boolean usarLetraNumero) {
        this.usarLetraNumero = usarLetraNumero;
    }

    public boolean getUsarLetraCaracterEspecial() {
        return usarLetraCaracterEspecial;
    }

    public void setUsarLetraCaracterEspecial(boolean usarLetraCaracterEspecial) {
        this.usarLetraCaracterEspecial = usarLetraCaracterEspecial;
    }

    @Override
    public String toString() {
        return "ConfiguracaoGerarSenha{" +
                "quantidadeDeSenhas=" + quantidadeDeSenhas +
                ", tamanhoDaSenha=" + tamanhoDaSenha +
                ", usaraLetraMaiscula='" + usarLetraMaiscula + '\'' +
                ", usaraLetraMinuscula='" + usarLetraMinuscula + '\'' +
                ", usaraLetraNumero='" + usarLetraNumero + '\'' +
                ", usaraLetraCaracterEspecial='" + usarLetraCaracterEspecial + '\'' +
                '}';
    }
}
