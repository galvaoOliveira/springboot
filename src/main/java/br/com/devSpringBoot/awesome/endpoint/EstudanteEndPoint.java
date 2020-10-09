package br.com.devSpringBoot.awesome.endpoint;

import br.com.devSpringBoot.awesome.error.CustomErrorType;
import br.com.devSpringBoot.awesome.error.ResourceNotFoundException;
import br.com.devSpringBoot.awesome.model.Estudante;
import br.com.devSpringBoot.awesome.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.invoke.empty.Empty;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("estudantes")
public class EstudanteEndPoint {
    private final EstudanteRepository estudanteDao;

    @Autowired
    public EstudanteEndPoint(EstudanteRepository estudanteDao) {
        this.estudanteDao = estudanteDao;
    }

    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(estudanteDao.findAll(), HttpStatus.OK);
    }

    @GetMapping( path = "/{id}")
    public ResponseEntity<?> getEstudanteById(@PathVariable("id") Long id){
        verifyIfEstudanteExists(id);
        Optional<Estudante> estudante = estudanteDao.findById(id);
        return new ResponseEntity<>(estudante, HttpStatus.OK);
    }

    @GetMapping( path = "/findByName/{name}")
    public ResponseEntity<?> getEstudanteById(@PathVariable String name){
        return new ResponseEntity<>(estudanteDao.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@Valid @RequestBody Estudante estudante){
        estudanteDao.save(estudante);
        estudanteDao.save(estudante);
        if(true)
            throw new RuntimeException("test transaction");
        estudanteDao.save(estudante);
        return new ResponseEntity<>(estudanteDao.save(estudante), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        verifyIfEstudanteExists(id);
        estudanteDao.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Estudante estudante){
        verifyIfEstudanteExists(estudante.getId());
        estudanteDao.save(estudante);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    private void verifyIfEstudanteExists(Long id){
        if (estudanteDao.findById(id) == null || !estudanteDao.findById(id).isPresent())
            throw new ResourceNotFoundException("Estudante não encontrado pelo ID: "+ id);
    }
}
