package com.jb.helpdesk.repositories;

import com.jb.helpdesk.domain.Cliente;
import com.jb.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
