package br.com.desafiogof;

public final class AccessHandler extends AbstractSupportHandler {
    public AccessHandler(SupportHandler next) {
        super(next);
    }

    @Override
    protected boolean canHandle(Ticket ticket) {
        return ticket.category() == Category.ACCESS;
    }

    @Override
    protected String queue() {
        return "Gestão de Acessos";
    }
}
