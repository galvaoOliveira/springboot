package br.com.devSpringBoot.awesome.endpoint;

import br.com.devSpringBoot.awesome.model.Estudante;
import br.com.devSpringBoot.awesome.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("estudante")
public class EstudanteEndPoint {

    @Autowired()
    private DateUtil dateUtil;
    @RequestMapping(method = RequestMethod.GET,path = "/list")
    public List<Estudante> listAll(){
        System.out.println("---------------------"+dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return asList(new Estudante( "Lufyy"), new Estudante("Zoro"));
    }
}
