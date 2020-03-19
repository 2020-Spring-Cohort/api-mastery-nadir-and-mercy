package org.wcci.apimastery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DirectorController {
    private DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }
    @GetMapping("/directors")
    public Collection<Director> retrieveDirectors() {
        return (Collection<Director>) directorRepository.findAll();

    }
    @GetMapping("/directors/{id}/")
    public Director retrieveDirector(@PathVariable Long id) {
        return directorRepository.findById(id).get();
    }
}
