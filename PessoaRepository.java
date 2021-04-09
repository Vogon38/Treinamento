package br.net.evne.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {

    private static final String columnSeparator = ";";

    public void save(List<Pessoa> pessoas) {
        String conteudo = "";
        for(int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            conteudo += pessoa.getId() + columnSeparator +
                    pessoa.getNome() + columnSeparator +
                    pessoa.getEmail() + columnSeparator +
                    pessoa.getId() + columnSeparator +
                    pessoa.getTelefone() + System.lineSeparator();
        }

        Path path = Paths.get("./pessoas.csv");
        try {
            Files.writeString(path, conteudo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de pessoas!");
            e.printStackTrace();
        }
    }

    public List<Pessoa> list() {
        Path path = Paths.get("./pessoas.csv");

        try {
            String conteudo = Files.readString(path);
            List<Pessoa> pessoas = new ArrayList<>();

            String[] lines = conteudo.split(System.lineSeparator());
            for(int i = 0; i < lines.length; i++) {
                String line = lines[i];
                String[] columns = line.split(columnSeparator);
                Pessoa pessoa = new Pessoa(columns[0], columns[1], columns[2], columns[3]);
                pessoas.add(pessoa);
            }

            return pessoas;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de pessoas!");
            e.printStackTrace();
        }

        return null;

    }

}
