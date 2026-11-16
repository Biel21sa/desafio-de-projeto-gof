package br.com.desafiogof;

public final class EquipmentHandler extends AbstractSupportHandler {
    public EquipmentHandler(SupportHandler next) {
        super(next);
    }

    @Override
    protected boolean canHandle(Ticket ticket) {
        return ticket.category() == Category.EQUIPMENT;
    }

    @Override
    protected String queue() {
        return "Suporte de Equipamentos";
    }
}
