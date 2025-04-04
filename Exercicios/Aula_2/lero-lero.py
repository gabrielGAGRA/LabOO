#!usr/bin/python3
#https://github.com/japoyudi/lero-lero

"""Gerador de lero-lero.
Gera frases de efeito sem significado real."""

import random

parte1 = ["O sistema em desenvolvimento",
"O novo protocolod e comunicacao",
"O algorimo otimizado e"]
parte2 = ["possui excelente desempenho",
"oferece garantias de precisão acima da média",
"preenche uma lacuna significativa"]
parte3 = ["nas aplicações a que se destina",
"em relação às opções disponíveis do mercado",
", provendo ampla vantagem competitiva a seus usuários"]

lingua = int(input("Escolha a língua: 1 - português; 2 - inglês\n "))

if lingua == 2:
	parte1 = []
	parte2 = []
	parte3 = [] 

print(random.choice(parte1), random.choice(parte2), random.choice(parte3))