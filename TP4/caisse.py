#TP4 SVL

from carte import Carte

class Caisse:
    """
    Ainsi qu'un nouvel objet Caisse
    >>> caisse = Caisse()

    On a également besoin d'un objet Carte
    >>> carte = Carte(200,2,8)

    On peut ensuite décider de payer sans utiliser
    de ticket quand le solde est suffisant
    >>> caisse.payerSansTicket(carte,10)

    Le solde de la carte vaut à présent 190
    >>> carte.getSolde()
    190

    On paye à présent avec une carte dont
    le solde est insuffisant
    >>> carte = Carte(10,5,8)
    >>> caisse.payerSansTicket(carte,13)
    Traceback (most recent call last):
    ...
    ValueError

    On veut à présent payer en utilisant les
    tickets pour un montant qui est inférieur
    à la valeur d'un ticket
    >>> caisse.payerAvecTicket(carte,7)

    Un ticket a été débité de la carte
    >>> carte.getTickets()
    4

    On veut à présent payer avec un ticket dont
    le montant est inférieur au montant dû
    >>> caisse.payerAvecTicket(carte,10)

    Dans ce cas, un ticket est débité de la
    carte mais le reste dû est également
    débité du solde de la carte
    >>> carte.getTickets()
    3
    >>> carte.getSolde()
    8

    A présent, on souhaite payer avec un ticket
    pour un montant supérieur à la valeur d'un
    ticket mais sans avoir un solde suffisant
    sur la carte
    >>> carte = Carte(2,3,8)
    >>> caisse.payerAvecTicket(carte,15)
    Traceback (most recent call last):
    ...
    ValueError

    Enfin, on souhaite payer avec un ticket
    sans aucun ticket sur la carte
    >>> carte = Carte(100,0,8)
    >>> caisse.payerAvecTicket(carte,10)

    Dans ce cas là, c'est le solde de la carte
    qui est débité:
    >>> carte.getSolde()
    90

    """
    def payerSansTicket(self, carte, montant):
        """
        Permet de payer un certain montant avec
        une carte sans utiliser de ticket.

        Une exception est levée si le solde
        est inférieur au montant dû.
        """
        solde = carte.getSolde()
        if solde >= montant:
            carte.debiter(montant)
        else:
            raise ValueError()

    def payerAvecTicket(self, carte, montant):
        """
        Permet de payer un certain montant
        avec un ticket.

        On débite un ticket de la carte si
        il y en a au moins 1 et ensuite on
        débite le solde de carte si le montant
        dû est supérieur à la valeur d'un ticket.

        Enfin, on débite le solde de la carte si
        le solde est suffisant et que le nombre de
        ticket est insuffisant.

        Une exception est levée si le solde de
        la carte est inférieur au montant dû.
        """
        ticket = carte.getTickets()
        valeurTicket = carte.getTicketValue()
        if ticket >= 1:
            carte.debiterAvecTicket()
            if valeurTicket < montant:
                self.payerSansTicket(carte, montant - valeurTicket)
        else:
            self.payerSansTicket(carte, montant)
