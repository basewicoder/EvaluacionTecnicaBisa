package com.wqa.exam.configuration;

import com.wqa.exam.domain.ports.persistence.ClientePersistencePort;
import com.wqa.exam.domain.ports.persistence.PersonaPersistencePort;
import com.wqa.exam.domain.ports.persistence.ReferenciaPersistencePort;
import com.wqa.exam.infrastructure.adapters.ClienteAdapter;
import com.wqa.exam.infrastructure.adapters.PersonaAdapter;
import com.wqa.exam.infrastructure.adapters.ReferenciaAdapter;
import com.wqa.exam.infrastructure.repository.ClienteRepository;
import com.wqa.exam.infrastructure.repository.PersonaRepository;
import com.wqa.exam.infrastructure.repository.ReferenciaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {


    @Bean
    public ClientePersistencePort clientePersistencePort(ClienteRepository clienteRepository) {
        return new ClienteAdapter(clienteRepository);
    }

    @Bean
    public ReferenciaPersistencePort referenciaPersistencePort(ReferenciaRepository referenciaRepository) {
        return new ReferenciaAdapter(referenciaRepository);
    }

    @Bean
    public PersonaPersistencePort personaPersistencePort(PersonaRepository personaRepository) {
        return new PersonaAdapter(personaRepository);
    }

}
