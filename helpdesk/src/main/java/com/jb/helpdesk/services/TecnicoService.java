package com.jb.helpdesk.services;

import com.jb.helpdesk.domain.Tecnico;
import com.jb.helpdesk.repositories.TecnicoRepository;
import com.jb.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {


    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> objeto = tecnicoRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id));
    }
}
