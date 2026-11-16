package br.com.desafiogof;

import java.util.Objects;

public record Ticket(String protocol, Category category, String description) {
    public Ticket {
        if (protocol == null || protocol.isBlank()) {
            throw new IllegalArgumentException("O protocolo do chamado não pode ser vazio.");
        }
        Objects.requireNonNull(category, "A categoria do chamado é obrigatória.");
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("A descrição do chamado não pode ser vazia.");
        }
    }
}
