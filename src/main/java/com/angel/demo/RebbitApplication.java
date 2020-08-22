package com.angel.demo;

import Repository.CommentRepository;
import Repository.LinkRepository;
import com.angel.demo.model.Comment;
import com.angel.demo.model.Link;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RebbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RebbitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("My spring boot","This is the second string");
            linkRepository.save(link);
            Comment comment = new Comment("This is a comment",link);
            commentRepository.save(comment);
            link.addComment(comment);

        };
    }

}
