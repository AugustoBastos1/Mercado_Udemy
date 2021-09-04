from typing import List, Dict
from time import sleep
from models.produto import Produto
from utils.helper import formata_float_moeda

produtos: List[Produto] = []
carrinho: List[Dict[Produto, int]] = []

def main():
    menu()

def menu():
    """
    Menu inicial, apresenta as opções e chama a função conforme a opção desejada pelo usuario
    """
    print('================================')
    print('==========Bem vindo(a)==========')
    print('========== Shop ==========')
    print('================================')

    print('Selecione uma das opções abaixo: ')
    print('1-Cadastrar Produto')
    print('2-Listar Produtos')
    print('3-Comprar Produto')
    print('4-Visualizar Carrinho')
    print('5-Fechar Pedido')
    print('6-Sair')
    opcao = int(input())
    if opcao in [1, 2, 3, 4, 5]:
        if opcao == 1:
            cadastrar_produto()
        elif opcao == 2:
            listar_produtos()
        elif opcao == 3:
            comprar_produto()
        elif opcao == 4:
            visualizar_carrinho()
        elif opcao == 5:
            fechar_pedido()
        elif opcao == 6:
            print("Volte Sempre!")
            sleep(2)
            exit(0)
        else:
            print('Opção invalida')
            sleep(1)
            menu()



def cadastrar_produto():
    """
    Função para cadastrar um produto, instancia um objeto do tipo Produto e adiciona na lista de produtos
    """
    print('Cadastro de Produto')
    print('-------------------')

    nome = input('Digite o nome do produto: ')
    preco = float(input('Digite o preço do produto: '))

    produto = Produto(nome, preco)

    produtos.append(produto)

    print(f'O produto {produto.nome} foi cadastrado com sucesso')
    sleep(2)
    menu()


def listar_produtos():
    """
    Função para listar todos os produtos cadastrados na lista de produtos
    """
    if len(produtos) > 0:
        print('Listagem de produtos')
        print('--------------------')
        for produto in produtos:
            print(produto)
            print('--------------------')
            sleep(1)
    else:
        print('Não existem produtos cadastrados')
    sleep(2)
    menu()


def comprar_produto():
    """
    Função para fazer uma compra de um produto, recebe o codigo do produto e adiciona este produto
    ao carrinho
    """
    if len(produtos) > 0:
        print('Digite o codigo do produto que deseja comprar')
        print('---------------------------------------------')
        print('=============Produtos Disponiveis============')
        for produto in produtos:
            print(produto)
            print('-----------------------')
            sleep(1)
        codigo = int(input())
        produto = pega_produto(codigo)
        if produto:
            if len(carrinho) > 0:
                contem = False
                for item in carrinho:
                    qtd = item.get(produto)
                    if qtd:
                        item[produto] = qtd + 1
                        print(f'O produto {produto.nome} agora possui {qtd + 1} unidades no carrinho')
                        contem = True
                        sleep(2)
                        menu()
                if not contem:
                    prod = {produto: 1}
                    carrinho.append(prod)
                    print(f'O produto {produto.nome} foi adicionado ao carrinho')
            else:
                item = {produto: 1}
                carrinho.append(item)
                print(f'O produto {produto.nome} foi adcionado ao carrinho')
                menu()
        else:
            print(f'O produto com o codigo {codigo} não foi encontrado')
            sleep(1)
            menu()

    else:
        print('Não existem produtos cadastrados')
    sleep(2)
    menu()

def visualizar_carrinho():
    """
    Função para visualizar todos os produtos no carrinho e sua quantidade
    """
    if len(carrinho) > 0:
        print('Produtos no carrinho: ')
        print('----------------------')
        for item in carrinho:
            for dados in item.items():
                print(dados[0])
                print(f'Quantidade: {dados[1]}')
                print('-----------------------')
                sleep(1)
    else:
        print('Ainda não existem produtos no carrinho')
    sleep(2)
    menu()

def fechar_pedido():
    """
    Função para fechar um pedido, e esvaziar o carrinho
    """
    if len(carrinho) > 0:
        valor_total = 0
        print('Produtos do carrinho')
        for item in carrinho:
            for dados in item.items():
                print(dados[0])
                print(f'Quantidade: {dados[1]}')
                valor_total += dados[0].preco * dados[1]
                print('--------------------')
                sleep(1)
        print(f'Sua fatura é {formata_float_moeda(valor_total)}')
        print('Volte sempre')
        carrinho.clear()
        sleep(5)
    else:
        print('Ainda não há produtos no carrinho')
    sleep(2)
    menu()

def pega_produto(codigo):
    """
    Função para buscar um produto pelo seu codigo
    """
    p = None

    for produto in produtos:
        if produto.codigo == codigo:
            p = produto
    return p


if __name__ == '__main__':
    main()
