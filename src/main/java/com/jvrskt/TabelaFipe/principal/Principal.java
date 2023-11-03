package com.jvrskt.TabelaFipe.principal;

import com.jvrskt.TabelaFipe.model.DadosGerais;
import com.jvrskt.TabelaFipe.model.DadosVeiculo;
import com.jvrskt.TabelaFipe.model.DadosVeiculoModelo;
import com.jvrskt.TabelaFipe.service.ConsumoApi;
import com.jvrskt.TabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consomeDados = new ConsumoApi();
    private ConverteDados dados = new ConverteDados();
    private final String url = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        var exibeMenu = "****** Opções ******\n" +
                "CARROS\n" +
                "MOTOS\n" +
                "CAMINHÕES\n" +
                "***********************";

        System.out.println(exibeMenu);
        System.out.println("\nInforme qual o tipo de veículo voce deseja pesquisar:");
        var tipoVeiculo = sc.nextLine();
        String endereco = null;
        if(tipoVeiculo.toLowerCase().contains("carr")){
            endereco = url + "carros/marcas";
        } else if (tipoVeiculo.toLowerCase().contains("mot")) {
            endereco = url + "motos/marcas";
        }else if (tipoVeiculo.toLowerCase().contains("cami")){
            endereco = url + "caminhoes/marcas";
        }else{
            System.out.println("Nome informado inválido.");
        }
        var json = consomeDados.obterDados(endereco);
        List<DadosVeiculo> dadosVeiculoList = dados.obterLista(json, DadosVeiculo.class);
        dadosVeiculoList.stream().sorted(Comparator.comparing(DadosVeiculo::codigo)).forEach(System.out::println);

        System.out.println("\nInforme o codigo da marca que deseja listar os modelos:");
        var codigoModelo = sc.nextLine();
        endereco += "/" + codigoModelo + "/modelos";
        var jsonModelo = consomeDados.obterDados(endereco);
        var dadoModelo = dados.obterDados(jsonModelo, DadosVeiculoModelo.class);
        dadoModelo.modelos().stream().sorted(Comparator.comparing(DadosVeiculo::nome)
                ).forEach(System.out::println);

        System.out.println("\nInforme o nome da marca que deseja listar os modelos");
        var nomeMarca = sc.nextLine();
        List<DadosVeiculo> dadoMarcaLista = dadoModelo.modelos().stream().filter(m -> m.nome().toLowerCase().contains(nomeMarca)).collect(Collectors.toList());
        dadoMarcaLista.forEach(System.out::println);

        System.out.println("\nInforme o codigo do modelo que deseja listar os anos:");
        var codigoAno = sc.nextLine();
        endereco += "/" + codigoAno + "/anos";
        var jsonAnoModelo = consomeDados.obterDados(endereco);
        List<DadosVeiculo> dadosAno = dados.obterLista(jsonAnoModelo, DadosVeiculo.class);
       // dadosAno.forEach(System.out::println);

        List<DadosGerais> dadosGeraisList = new ArrayList<>();
        for(int i=0; i<dadosAno.size(); i++){
            var enderecoGeral = endereco + "/" + dadosAno.get(i).codigo();
            var jsonDadosGerais = consomeDados.obterDados(enderecoGeral);
            DadosGerais dadosGerais = dados.obterDados(jsonDadosGerais, DadosGerais.class);
           dadosGeraisList.add(dadosGerais);
        }
        System.out.println("Resumo das avaliações dos modelos por ano:");
        dadosGeraisList.forEach(System.out::println);

    }
}
