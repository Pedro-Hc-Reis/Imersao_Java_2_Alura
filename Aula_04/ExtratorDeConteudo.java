package br.com.alura.linguagens.api;

import java.util.List;

public interface ExtratorDeConteudo {

    List<Conteudo> extraiConteudos(String json);

}