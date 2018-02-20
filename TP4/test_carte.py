# Test Carte

import unittest
from carte import Carte

class TestCarte(unittest.TestCase):

    def test_get_solde(self):
        carte = Carte(20,3,8)
        self.assertEqual(20, carte.getSolde())

    def test_get_tickets(self):
        carte = Carte(20,3,8)
        self.assertEqual(3, carte.getTickets())

    def test_get_value_ticket(self):
        carte = Carte(20,3,8)
        self.assertEqual(8, carte.getTicketValue())

    def test_debiter_solde(self):
        carte = Carte(20,3,8)
        carte.debiter(10)
        self.assertEqual(10, carte.getSolde())

    def test_debiter_tickets(self):
        carte = Carte(20,3,8)
        carte.debiterAvecTicket()
        self.assertEqual(2, carte.getTickets())
