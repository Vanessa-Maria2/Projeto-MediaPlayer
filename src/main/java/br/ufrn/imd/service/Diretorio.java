package br.ufrn.imd.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Musica;

public class Diretorio {
    public Musica fileToMusica(File f) {
        Musica musica = new Musica();
        musica.setName(f.getName());
        musica.setDiretorio(f.getAbsolutePath());
        return musica;
    }

    public List<Musica> buscaMusica(String diretorio) {
        List<Musica> musicas = new ArrayList<>();

        File file = new File(diretorio);

        File[] arquivos = file.listFiles();

        if (arquivos != null) {  
            for(File f: arquivos) {
                if(f.isFile() && f.getName().toLowerCase().endsWith(".mp3")){
                    musicas.add(fileToMusica(f));
                }
            }
        } else {
            System.out.println("O diretório não existe ou não é um diretório válido.");
        }

        return musicas;
    }
}