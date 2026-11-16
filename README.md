# Central de Atendimento — Chain of Responsibility

Exemplo em Java puro do padrão comportamental **Chain of Responsibility** (*Cadeia de Responsabilidade*). Chamados passam por uma sequência de tratadores; cada tratador reconhece sua categoria ou encaminha a solicitação ao próximo. Um tratador final garante que nenhuma categoria fique sem destino.

## Categorias atendidas

| Categoria | Fila responsável |
| --- | --- |
| `NETWORK` | Suporte de Redes |
| `ACCESS` | Gestão de Acessos |
| `EQUIPMENT` | Suporte de Equipamentos |
| `OTHER` ou categoria sem tratador específico | Triagem Geral |

## Executar

Requer JDK 17 ou superior e Maven:

```powershell
mvn test
mvn package
java -cp target\classes br.com.desafiogof.Main
```

O primeiro comando executa os testes unitários. O último exibe chamados de exemplo e suas filas de destino.

## Onde está o padrão

- `SupportHandler` define o contrato dos tratadores.
- `AbstractSupportHandler` concentra a lógica de tratar ou encaminhar.
- `NetworkHandler`, `AccessHandler` e `EquipmentHandler` tratam categorias específicas.
- `GeneralSupportHandler` é o fallback que encerra a cadeia.
- `Main` compõe a cadeia e envia chamados sem conhecer as regras internas de roteamento.

Para acrescentar uma categoria, crie um tratador e conecte-o na cadeia; o código que cria os chamados não precisa mudar.
