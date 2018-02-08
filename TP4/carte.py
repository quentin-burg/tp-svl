# Carte


class Carte:


    def __init__(self, solde, tickets, valTicket):
        self.__solde = solde
        self.__tickets = tickets
        self.__ticketVal = valTicket

    def getSolde(self):
        return self.__solde

    def getTickets(self):
        return self.__tickets

    def getTicketValue(self):
        return self.__ticketVal

    def debiter(self, montant):
        self.__solde -= montant

    def debiterAvecTicket(self):
        self.__tickets -= 1
