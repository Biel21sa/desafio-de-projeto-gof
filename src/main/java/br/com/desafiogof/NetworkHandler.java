package br.com.desafiogof;

public final class NetworkHandler extends AbstractSupportHandler {
    public NetworkHandler(SupportHandler next) {
        super(next);
    }

    @Override
    protected boolean canHandle(Ticket ticket) {
        return ticket.category() == Category.NETWORK;
    }

    @Override
    protected String queue() {
        return "Suporte de Redes";
    }
}
