package br.com.desafiogof;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SupportHandlerTest {
    private SupportHandler handler;

    @BeforeEach
    void setUp() {
        handler = new NetworkHandler(
                new AccessHandler(
                        new EquipmentHandler(new GeneralSupportHandler())));
    }

    @Test
    void routesEachSupportedCategoryToItsQueue() {
        assertEquals("Suporte de Redes", handler.handle(ticket(Category.NETWORK)).queue());
        assertEquals("Gestão de Acessos", handler.handle(ticket(Category.ACCESS)).queue());
        assertEquals("Suporte de Equipamentos", handler.handle(ticket(Category.EQUIPMENT)).queue());
    }

    @Test
    void routesUnknownCategoryToGeneralTriage() {
        assertEquals("Triagem Geral", handler.handle(ticket(Category.OTHER)).queue());
    }

    @Test
    void rejectsTicketsWithoutProtocol() {
        assertThrows(IllegalArgumentException.class,
                () -> new Ticket(" ", Category.NETWORK, "Falha de conexão"));
    }

    private Ticket ticket(Category category) {
        return new Ticket("CH-TEST", category, "Chamado de teste");
    }
}
