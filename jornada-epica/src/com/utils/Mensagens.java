package com.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class Mensagens {
    public String parametrosMensagem(String mensagem, String... parametros) {
        for (int i = 0; i < parametros.length; i++) {
            mensagem = mensagem.replace("{"+i+"}", parametros[i]);
        }
        return mensagem;
    }

    public String exibirMensagem(String mensagem) {
        Properties prop = new Properties();

        try {
            prop.load(Mensagens.class.getResourceAsStream("/resources/mensagens.properties"));
            return prop.getProperty(mensagem);
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao carregar mensagem;";
        }
    }

    public Set<String> obterDados(String nomeArquivo) {
        Set<String> nomes = new HashSet<>();
        Properties properties = new Properties();

        try {
            properties.load(Mensagens.class.getResourceAsStream(nomeArquivo));

            for (String chave : properties.stringPropertyNames()) {
                nomes.add(properties.getProperty(chave));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nomes;
    }

    public String aleatorizarDados(Set<String> nomes, Random random) {
        int indice = random.nextInt(nomes.size());
        int i = 0;

        for (String nome : nomes) {
            if (i == indice) {
                return nome;
            }
            i++;
        }

        return null;
    }
}
