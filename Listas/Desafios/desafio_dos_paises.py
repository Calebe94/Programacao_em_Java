"""
Desafio
*Escreva o codigo em java para representar a classe de um pais que tem como
atributos nome, nome da capital, sua dimensao em Km2 e os paises na qual ele
faz fronteira. As condicoes sao as seguintes:
    * O construtor da classe deve ser inicializado com o nome do pais, sua capital e sua dimensao
    * Metodos get's/set's para os atributos
    * Um metodo que permita verificar se dois paises sao iguais OBS: Dois paises serao iguais se tiverem o mesmo nome e mesma capital
    * Um metodo que define quais outros paises fazem fronteira (UM PAIS NaO PODE FAZER
FRONTEIRA COM ELE MESMO)
    * Um metodo que retorne os paises na qual ele faz fronteira
    * Um metodo que receba um outro pais como parametro e retorna verdadeiro se estes dois
paises forem vizinhos, falso caso contrario
    * Criar 5 paises, pais 1 faz fronteira com os paises 2, 3, e 5. Pais 2 faz fronteira com os paises
3,4 e 5. O pais 3 faz fronteira com o pais 4
    * ESCREVER CoDIGOS DE TESTES PARA CADA UM DOS MeTODOS E TESTANDO AS CONDIcoES DE FRONTEIRA
* Lembrar de verificar se os paises fazem fronteira:
* 5 com 1?
* 4 com 5?
* 4 com 2?
* 3 com 5?
"""

class pais(object):
    name = str()
    capital = str()
    dimension = int()
    frontier = list()
    def __init__ (self,country,capital,dimension,border_countries):
        self.name = country
        self.capital=capital
        self.dimension=dimension
        self.frontier=border_countries
    def getCountryName(self):
        return self.name
    def getCountryCapital(self):
        return self.capital
    def getCountryFrontier(self):
        return self.frontier
    def setAnotherFrontier(self,another):
        if another == self.name:
            return False
        else:
            self.frontier.append(another) 
            return True
    def SameCountry(self,country1,country2):
        if(country1 == country2):
            return True
        else:
            return False
    def isNeighbor(self,country):
        if country in self.frontier:
            return True
        else:
            return False

if __name__ == "__main__":
    #pais 1 faz fronteira com os paises 2, 3, e 5. Pais 2 faz fronteira com os paises 3,4 e 5. O pais 3 faz fronteira com o pais 4
    country1 = pais("Brazil","Brasilia",120000,["Paraguai","Argentina","Uruguai"])
    country2 = pais("Argentina","Buenos Aires",120000,["Paraguai","Uruguai","Chile"])
    country3 = pais("Paraguai","Roraima",120000,["Chile"])
    country4 = pais("Chile","Roraima",120000,["Paraguai"])
    country5 = pais("Uruguai","Roraima",120000,["Brazil","Argentina"])
    """
        * 5 com 1?
        * 4 com 5?
        * 4 com 2?
        * 3 com 5?
    """
    if country5.isNeighbor(country1.getCountryName()) is True:
        print(country5.getCountryName()+" E Vizinho de:"+country1.getCountryName())
    else:
        print(country5.getCountryName()+" Nao e Vizinho de:"+country1.getCountryName())
    
    if country4.isNeighbor(country5.getCountryName()) is True:
        print(country4.getCountryName()+" E Vizinho de:"+country5.getCountryName())
    else:
        print(country4.getCountryName()+" Nao e Vizinho de:"+country5.getCountryName())
        
    if country4.isNeighbor(country2.getCountryName()) is True:
        print(country4.getCountryName()+" E Vizinho de:"+country2.getCountryName())
    else:
        print(country4.getCountryName()+" Nao e Vizinho de:"+country2.getCountryName())

    if country3.isNeighbor(country5.getCountryName()) is True:
        print(country3.getCountryName()+" E Vizinho de:"+country5.getCountryName())
    else:
        print(country3.getCountryName()+" Nao e Vizinho de:"+country5.getCountryName())