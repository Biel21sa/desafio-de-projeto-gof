package br.com.desafiogof;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SupportHandler handler = new NetworkHandler(
                new AccessHandler(
                        new EquipmentHandler(new GeneralSupportHandler())));

        List<Ticket> tickets = List.of(
                new Ticket("CH-001", Category.NETWORK, "Sem conexão com a VPN"),
                new Ticket("CH-002", Category.ACCESS, "Solicitação de acesso ao sistema"),
                new Ticket("CH-003", Category.EQUIPMENT, "Teclado com defeito"),
                new Ticket("CH-004", Category.OTHER, "Dúvida sobre um serviço"));

        for (Ticket ticket : tickets) {
            Assignment assignment = handler.handle(ticket);
            System.out.printf("%s | %s | %s%n",
                    assignment.protocol(), ticket.description(), assignment.queue());
        }
    }
}
