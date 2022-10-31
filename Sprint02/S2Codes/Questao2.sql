USE avaliacao_sprint2;
CREATE TABLE FILME(ID INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(50), descricao VARCHAR(300), ano YEAR);
INSERT INTO FILME(nome, descricao, ano)
Values("Star Wars IV", "Uma nova esperança!", 1977),
("Star Wars V", "O Império Contra-Ataca", 1980),
("Star Wars VI","O retorno de Jedi",1983),
("Blade Runner", "O caçador androides, dirigido por Stanley Kubrick, estrelado por Harrison Ford", 1982),
("O Vingador do Futuro","Estrelado por Arnold Schwarzenegger", 1990),
("O Exterminador do Futuro","Clássico estrelado por Arnold Schwarzenegger, inicio da Era das Máquinas!", 1984),
("De volta para o Futuro","Clássico da ficção científica - retrata a viagem,literalmente, de um adolescente ao passado", 1985),
("Forrest Gump","Emocione-se com um dos melhores filmes de Tom Hanks", 1994),
("Interstellar","Um dos melhores filmes de ficção científica, uma obra prima de Christopher Nolan",2014),
("Matrix","Clássico estrelado por Keanu Reeves - Tudo é mera simulação!",1999),
("O Show de Truman","Um dos melhores filmes de Jim Carrey, emocione-se com a história de libertação de Truman!",1998),
("O homem bicentenário","Clássico estrelado por Robin Wiliams - O robô que se torna humano",2000),
("Capitão América","Capitão América 2 - O Soldado Invernal",2014),
("2001 - Uma Odisseia no Espaço","Clássico de Stanley Kubrick - Uma aventura no espaço-tempo",1968),
("Zatoichi","A luta de um espadachim cego contra gangues de um vilarejo",2003),
("Star Wars Rogue One","Uma prequel fantástica situada antes de Star Wars IV",2016),
("Gladiador","Com brilhantes atuações de Russel Crowe e Joaquin Phoenix", 2000),
("Vingadores Guerra Infinita","O ínicio do embate contra Thanos!", 2018),
("Perdido em Marte","Cultivando em outro planeta!", 2015),
("A Chegada", "A chegada de Visitantes espaciais",2016);


