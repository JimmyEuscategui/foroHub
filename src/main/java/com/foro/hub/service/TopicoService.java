package com.foro.hub.service;

import com.foro.hub.model.Topico;
import com.foro.hub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    // Crear un tópico
    public Topico crearTopico(Topico topico) {
        // Verifica si el tópico ya existe por título y mensaje
        topicoRepository.findByTituloAndMensaje(topico.getTitulo(), topico.getMensaje())
                .ifPresent(t -> {
                    throw new RuntimeException("Tópico duplicado");
                });
        return topicoRepository.save(topico);
    }

    // Obtener todos los tópicos
    public List<Topico> obtenerTodos() {
        return topicoRepository.findAll();
    }

    // Obtener un tópico por ID
    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);
    }

    // Actualizar un tópico existente
    public Topico actualizarTopico(Long id, Topico topico) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado");
        }
        topico.setId(id);  // Establecer el ID del tópico a actualizar
        return topicoRepository.save(topico);
    }

    // Eliminar un tópico
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
