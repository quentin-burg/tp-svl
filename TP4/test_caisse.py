# Test Caisse

import unittest
from mockito import *
from caisse import Caisse

class TestCaisse(unittest.TestCase):

    def test_debit_porte_monaie_solde_suffisant(self):
        caisse = Caisse()
        carte = mock()
        when(carte).getSolde().thenReturn(100)
        caisse.payerSansTicket(carte,15)
        verify(carte).debiter(15)

    def test_debit_porte_monnaie_solde_insuffisant(self):
        caisse = Caisse()
        carte = mock()
        when(carte).getSolde().thenReturn(10)
        with self.assertRaises(ValueError) :
            caisse.payerSansTicket(carte,15)

    def test_debit_ticket_suffisant_montant_inferieur_valeur_ticket(self):
        caisse = Caisse()
        carte = mock()
        when(carte).getTickets().thenReturn(2)
        when(carte).getTicketValue().thenReturn(8)
        caisse.payerAvecTicket(carte, 7)
        verify(carte).debiterAvecTicket()

    def test_debit_ticket_insuffisant_solde_suffisant(self):
        caisse = Caisse()
        carte = mock()
        when(carte).getTickets().thenReturn(0)
        when(carte).getTicketValue().thenReturn(8)
        when(carte).getSolde().thenReturn(50)
        caisse.payerAvecTicket(carte,7)
        verify(carte).debiter(7)

    def test_debit_ticket_insuffisant_solde_insuffisant(self):
        caisse = Caisse()
        carte = mock()
        when(carte).getTickets().thenReturn(0)
        when(carte).getTicketValue().thenReturn(8)
        when(carte).getSolde().thenReturn(5)
        with self.assertRaises(ValueError):
            caisse.payerAvecTicket(carte,7)

    def test_debit_ticket_suffisant_montant_superieur_valeur_ticket(self):
        caisse = Caisse()
        carte = mock()
        when(carte).getTickets().thenReturn(10)
        when(carte).getSolde().thenReturn(100)
        when(carte).getTicketValue().thenReturn(8)
        caisse.payerAvecTicket(carte, 20)
        verify(carte).debiterAvecTicket()
        verify(carte).debiter(12)
        
