package ch.bfh.kepler.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.kepler.model.*;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
