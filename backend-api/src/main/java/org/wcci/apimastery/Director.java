package org.wcci.apimastery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Director {
    @Id
    @GeneratedValue
    private Long id;
   @OneToMany(mappedBy = "director")
    private Collection<Movie> movies;
   private String name;

   protected Director(){};
   public Director(String name){
       this.name = name;
   }

    public Long getId() {
        return id;
    }

    public Collection<Movie> getMovies() {
        return movies;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (id != null ? !id.equals(director.id) : director.id != null) return false;
        return name != null ? name.equals(director.name) : director.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

