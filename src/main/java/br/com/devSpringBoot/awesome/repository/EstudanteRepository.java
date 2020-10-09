package br.com.devSpringBoot.awesome.repository;

import br.com.devSpringBoot.awesome.model.Estudante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EstudanteRepository extends PagingAndSortingRepository<Estudante,Long> {
    List<Estudante> findByNameIgnoreCaseContaining(String name);
}
