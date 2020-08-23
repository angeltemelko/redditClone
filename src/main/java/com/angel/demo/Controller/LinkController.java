package com.angel.demo.Controller;

import com.angel.demo.Repository.LinkRepository;
import com.angel.demo.model.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/link")
public class LinkController {

    LinkRepository linkRepository;

    private LinkController(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public List<Link> list(){
        return linkRepository.findAll();
    }

    @PostMapping("/create")
    public Link create(@ModelAttribute Link link){
        return linkRepository.save(link);
    }

    @PutMapping("/update/{id}")
    public Link update(@PathVariable long id, @ModelAttribute Link link){
        return linkRepository.save(link);
    }

    @GetMapping("/read/{id}")
    public Optional<Link> read(@PathVariable long id){
        return linkRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        linkRepository.deleteById(id);
    }


}
