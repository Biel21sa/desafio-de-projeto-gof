package br.com.desafiogof;

import java.util.Objects;

public abstract class AbstractSupportHandler implements SupportHandler {
    private final SupportHandler next;

    protected AbstractSupportHandler(SupportHandler next) {
        this.next = Objects.requireNonNull(next, "O próximo tratador é obrigatório.");
    }

    @Override
    public final Assignment handle(Ticket ticket) {
        Objects.requireNonNull(ticket, "O chamado é obrigatório.");
        if (canHandle(ticket)) {
            return new Assignment(ticket.protocol(), queue());
        }
        return next.handle(ticket);
    }

    protected abstract boolean canHandle(Ticket ticket);

    protected abstract String queue();
}
