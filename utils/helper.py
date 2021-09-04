"""
Transforma um dado do tipo float para o formato brasileiro de apresentar moedas
"""
def formata_float_moeda(valor):
    return f'R$ {valor:,.2f}'