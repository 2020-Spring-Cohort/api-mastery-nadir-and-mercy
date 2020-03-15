package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaMappingTest {
    @Autowired
    private DirectorRepository directorRepo;
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void movieShouldHaveADirector(){
        Director testDirector = new Director("test");
        directorRepo.save(testDirector);

        Movie testMovie1 = new Movie("test1", testDirector);
        Movie testMovie2 = new Movie ("test2", testDirector);
        movieRepo.save(testMovie1);
        movieRepo.save(testMovie2);

        entityManager.flush();
        entityManager.clear();

        Director retrievedDirector = directorRepo.findById(testDirector.getId()).get();
        Movie retrievedMovie1 = movieRepo.findById(testMovie1.getId()).get();
        Movie retrievedMovie2 = movieRepo.findById(testMovie2.getId()).get();
        assertThat(retrievedDirector.getMovies()).contains(retrievedMovie1,retrievedMovie2);
    }
}
