package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DirectorControllerTest {

    private DirectorRepository directorRepository;
    private DirectorController underTest;
    private Director testDirector;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        directorRepository = mock(DirectorRepository.class);
        MovieRepository movieRepository = mock(MovieRepository.class);
        underTest = new DirectorController(directorRepository);
        testDirector = new Director("test");
        when(directorRepository.findAll()).thenReturn(Collections.singletonList(testDirector));
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

    }

    @Test
    public void retrieveDirectorReturnsListOfDirectorFromMockRepo() {
        underTest.retrieveDirectors();
        verify(directorRepository).findAll();
    }

    @Test
    public void retrieveDirectorReturnsListOfDirectorsContainingMockDirector() {
        Collection<Director> result = underTest.retrieveDirectors();
        assertThat(result).contains(testDirector);

    }
    @Test
    public void underTestIsWiredCorrectlyWithAnnotations() throws Exception {
        mockMvc.perform(get("/directors"))
                .andExpect(status().isOk());

    }
//    @Test
//    public void underTestIsWiredCorrectlyForSingleDirector() throws Exception {
//        when(directorRepository.findById(1L)).thenReturn(Optional.of(testDirector));
//        mockMvc.perform(get("/directors/1/"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.name", is("test")))
//                .andExpect(jsonPath("$.movies", is(null)));
//    }

}
