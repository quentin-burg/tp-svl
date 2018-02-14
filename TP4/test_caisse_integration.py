# Test intégration de la classe Caisse

import unittest
from caisse import Caisse
from carte import Carte

class TestCaisseIntegration(unittest.TestCase):

    def test_debit_sans_ticket_solde_suffisant(self):
        caisse = Caisse()
        carte = Carte(150,10,8)
        caisse.payerSansTicket(carte,15)
        self.assertEqual(135,carte.getSolde())

    def test_debit_sans_ticket_solde_insuffisant(self):
        caisse = Caisse()
        carte = Carte(2,10,8)
        with self.assertRaises(ValueError):
            caisse.payerSansTicket(carte,15)

    def test_debit_ticket_suffisant_montant_inferieur_valeur_ticket(self):
        caisse = Caisse()
        carte = Carte(150,10,8)
        caisse.payerAvecTicket(carte,7)
        self.assertEqual(9, carte.getTickets())

    def test_debit_ticket_suffisant_montant_superieur_valeur_ticket(self):
        caisse = Caisse()
        carte = Carte(150,10,8)
        caisse.payerAvecTicket(carte,10)
        self.assertEqual(148,carte.getSolde())

    def test_debit_ticket_insuffisant_solde_suffisant(self):
        caisse = Caisse()
        carte = Carte(150,0,8)
        caisse.payerAvecTicket(carte,7)
        self.assertEqual(143,carte.getSolde())

    def test_debit_ticket_insuffisant_solde_insuffisant(self):
        caisse = Caisse()
        carte = Carte(5,0,8)
        with self.assertRaises(ValueError):
            caisse.payerAvecTicket(carte,7)
