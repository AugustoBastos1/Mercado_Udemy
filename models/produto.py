from utils.helper import formata_float_moeda


class Produto:
    contador = 1


    def __init__(self, nome, preco):
        """
        Metodo construtor da classe Produto
        """
        self.__codigo = Produto.contador
        self.__nome = nome
        self.__preco = preco
        Produto.contador += 1

    """
    Getters e Setters de todos os atributos
    """
    @property
    def codigo(self):
        return self.__codigo

    @property
    def nome(self):
        return self.__nome

    @property
    def preco(self):
        return self.__preco

    def __str__(self):
        """
        Sobrescrita do metodo "To String" de um objeto do tipo Produto
        """
        return f'Codigo: {self.codigo}\nNome: {self.nome}\nPreço: {formata_float_moeda(self.preco)}'


