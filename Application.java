package br.net.evne.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(PessoaRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Pessoa> pessoas = new ArrayList<>();
                pessoas.add(new Pessoa("1", "Nome 1", "teste1@net.com.br", "+55 047 91111-1111"));
                pessoas.add(new Pessoa("2", "Nome 2", "teste2@net.com.br", "+55 047 92222-2222"));
                pessoas.add(new Pessoa("3", "Nome 3", "teste3@net.com.br", "+55 047 93333-3333"));
                repository.save(pessoas);
            }
        };
    }
}