package com.jb.helpdesk.services;

import com.jb.helpdesk.domain.Pessoa;
import com.jb.helpdesk.domain.Tecnico;
import com.jb.helpdesk.dto.TecnicoDTO;
import com.jb.helpdesk.repositories.PessoaRepository;
import com.jb.helpdesk.repositories.TecnicoRepository;
import com.jb.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.jb.helpdesk.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {


    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> objeto = tecnicoRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id));
    }

    public List<Tecnico> findAll(){
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO){
        objDTO.setId(null);
        validaTecnico(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return tecnicoRepository.save(newObj);
    }

    public Tecnico update(Integer id,@Valid TecnicoDTO objDTO) {
        objDTO.setId(id);
        Tecnico oldObj = findById(id);
        //validaTecnico(objDTO);
        oldObj = new Tecnico(objDTO);
        return tecnicoRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Tecnico tecnico = findById(id);

        if (!tecnico.getChamados().isEmpty()) {
            throw new DataIntegrityViolationException("O tecnico possui ordens de servico e não pode ser deletado!");
        }
        tecnicoRepository.deleteById(id);

    }

    private void validaTecnico(TecnicoDTO tecnicoDTO) {
        //Valida se o cpf ja consta no bd
        Optional<Pessoa> obj = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != tecnicoDTO.getId()) {
            throw new DataIntegrityViolationException("CPF Já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(tecnicoDTO.getEmail());

        if (obj.isPresent() && obj.get().getId() != tecnicoDTO.getId()) {
            throw new DataIntegrityViolationException("Email Já cadastrado no sistema");
        }

    }
}
