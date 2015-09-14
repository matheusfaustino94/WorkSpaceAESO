
-- O sistema deve ser capaz de retornar o primeiro quarto vazio de acordo com o número máximo de hóspedes e tipo do quarto (lista);

select q.ID_Quarto'Nº do\nQuarto', q.Status 'Ocupado (1)\nDisponível (0)'
from projeto_hotel.quarto q
where q.Capacidade_Hóspedes = 3 and q.status = 0;

-- O sistema deve ter uma função que varre todos os quartos do hotel que estão RESERVADOS e com data final da RESERVA (lista toda as reservas);

select q.ID_Quarto'Nº do\nQuarto', q.Status'Ocupado (1)\nDisponível (0)', r.Data_Expiração'Expira em:'
from projeto_hotel.quarto q, projeto_hotel.reserva r
where q.ID_Quarto = r.ID_Quarto and q.status = 1;

-- O sistema deve informar o quarto com data de desocupação mais próxima (pesquisa);

select q.ID_Quarto'Nº do\nQuarto', r.Data_Expiração'Expira em:' 
from projeto_hotel.quarto q, projeto_hotel.reserva r
order by r.Data_Expiração asc; 

-- O sistema deve imprimir a nota com o valor da hospedagem, a tempo de ocupação da hospedagem, os dados do hospede responsável pela hospedagem;

select c.Consumo_ID_Consumo 'ID consumo', c.Produto_ID_Produto 'ID produto', o.Dias_Ocupados 'Dias ocupados', h.Nome 'Nome do Hóspede', o.ID_Quarto'Nº Quarto'
from projeto_hotel.consumo_produto c, projeto_hotel.ocupação o, projeto_hotel.hóspede h, projeto_hotel.ocupação_hóspedes oh
where h.ID_Hóspede = oh.Hóspede_ID_Hóspede and
oh.Ocupação_ID_Ocupação = o.ID_Ocupação and
o.ID_Consumo = c.Consumo_ID_Consumo;

