package com.nikolas.aplicativo_filmes.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private int temporada;
    private String titulo;
    private int numeroEp;
    private double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(int numeroTemp, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemp;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEp = dadosEpisodio.numeroEp();

        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        } catch (NumberFormatException e) {
            this.avaliacao = 0.0;
        }

        try {
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        } catch (DateTimeParseException e) {
            this.dataLancamento = null;
        }

    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroEp() {
        return numeroEp;
    }

    public void setNumeroEp(int numeroEp) {
        this.numeroEp = numeroEp;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return  "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEp=" + numeroEp +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento;
    }
}
