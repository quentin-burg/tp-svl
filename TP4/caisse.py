#TP4 SVL

class Caisse:

    def payerSansTicket(self, carte, montant):
        solde = carte.getSolde()
        if solde > montant:
            carte.debiter(montant)
        else:
            raise ValueError()

    def payerAvecTicket(self, carte, montant):
        ticket = carte.getTickets()
        valeurTicket = carte.getTicketValue()
        if ticket >= 1:
            carte.debiterAvecTicket()
            if valeurTicket < montant:
                self.payerSansTicket(carte, montant - valeurTicket)
        else:
            self.payerSansTicket(carte, montant)
