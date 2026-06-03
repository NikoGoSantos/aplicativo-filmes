package com.nikolas.aplicativo_filmes.principal;

import com.nikolas.aplicativo_filmes.model.DadosSerie;
import com.nikolas.aplicativo_filmes.model.DadosTemporada;
import com.nikolas.aplicativo_filmes.service.ConsumoApi;
import com.nikolas.aplicativo_filmes.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=53ab90b";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca: ");
        var nomeSerie = scanner.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
//        temporadas.forEach(System.out::println);

//        for (int i = 0; i < dadosSerie.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodiosTemp = temporadas.get(i).episodios();
//
//            for (int j = 0; j < episodiosTemp.size(); j++) {
//                System.out.println(episodiosTemp.get(j).titulo());
//            }
//        }

        temporadas.forEach(t -> t
                .episodios().forEach(e -> System.out.println(e.titulo())));
    }
}
