# desafio-consulta-vendas
DESAFIO: Consulta vendas

Sistema de vendas (Sale) e vendedores (Seller).

```mermaid
erDiagram
    SALE {
        int ID
        int VISITED
        int DEALS
        float AMOUNT
        timestamp DATE
    }
    SELLER {
        int ID
        string NAME
        string EMAIL
        string PHONE
    }
    SALE }|--|| SELLER : "-sales | -seller"
```

## Relatório de vendas
1. [IN] O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.
2. [OUT] O sistema informa uma listagem paginada contendo id, data, quantia vendida e nome do
vendedor, das vendas que se enquadrem nos dados informados.
Informações complementares:
- Se a data final não for informada, considerar a data atual do sistema. Para instanciar a data atual,
utilize o comando:
LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
- Se a data inicial não for informada, considerar a data de 1 ano antes da data final. Para instanciar
uma data com um ano a menos, use a função minusYears:
LocalDate result = minhaData.minusYears(1L);
- Se o nome não for informado, considerar o texto vazio.
- Dica: receba todos os dados como String no controller, e faça os tratamentos das datas acima,
instanciando os objetos LocalDate, no service.

## Sumário de vendas por vendedor
1. [IN] O usuário informa, opcionalmente, data inicial, data final.
2. [OUT] O sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor
no período informado.
Informações complementares:
- As mesmas do caso de uso Relatório de vendas
