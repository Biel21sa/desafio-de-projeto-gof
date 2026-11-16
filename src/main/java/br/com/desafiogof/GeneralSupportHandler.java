package br.com.desafiogof;

import java.util.Objects;

public final class GeneralSupportHandler implements SupportHandler {
    @Override
    public Assignment handle(Ticket ticket) {
        Objects.requireNonNull(ticket, "O chamado é obrigatório.");
        return new Assignment(ticket.protocol(), "Triagem Geral");
    }
}
