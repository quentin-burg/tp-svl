# Carte


class Carte:
    """
    On peut créer un objet Carte
    avec 200€ de solde et 30 tickets
    d'une valeur unitaire de 8€
    >>> c = Carte(200,30,8)

    On peut donc consulter le solde
    de la carte...
    >>> c.getSolde()
    200

    ...son nombre de tickets...
    >>> c.getTickets()
    30

    ...et même la valeur d'un ticket.
    >>> c.getTicketValue()
    8

    On peut également débiter la carte
    d'un certain montant.
    >>> c.debiter(20)

    On remarque que le solde a diminué mais
    que le nombre de tickets reste inchangé.
    >>> c.getSolde()
    180
    >>> c.getTickets()
    30

    On peut aussi débiter la carte
    d'un ticket si le solde est suffisant
    >>> c.debiterAvecTicket()

    On remarque cette fois-ci que c'est
    le nombre de tickets qui a diminué et
    non le solde qui reste inchangé.
    >>> c.getSolde()
    180
    >>> c.getTickets()
    29

    """
    def __init__(self, solde, tickets, valTicket):
        """
        Initialise un objet carte avec les
        valeurs du solde, du nombre de tickets
        et la valeur de chacun donnés en
        paramètre.
        """
        self.__solde = solde
        self.__tickets = tickets
        self.__ticketVal = valTicket

    def getSolde(self):
        """
        Retourne le solde de la carte
        """
        return self.__solde

    def getTickets(self):
        """
        Retourne le nombre de tickets
        sur la carte
        """
        return self.__tickets

    def getTicketValue(self):
        """
        Retourne la valeur d'un
        ticket
        """
        return self.__ticketVal

    def debiter(self, montant):
        """
        Débite la carte du montant
        passé en paramètre
        """
        self.__solde -= montant

    def debiterAvecTicket(self):
        """
        Débite la carte d'un ticket
        """
        self.__tickets -= 1

    if __name__ == "__main__":
        import doctest
        doctest.testmod()
