1. Baseado no Scrum Guide, qual o tempo máximo deveriam ter as seguintes
cerimônias:
	a. Daily:
		A Daily é uma reunião realizada diariamente que ocorre em um tempo limite de 15 minutos. Nela são discutidas três tópicos: 1 -O que foi realizado desde a última daily, 2 - O que se pretende realizar até a próxima daily, 3 - Se houveram impeditivos em relação a execução da task.

	b. Planning:
		A Sprint Planning é uma reunião realizada para determinar o que será realizado na Sprint, a duração máxima é de até 8 horas para Sprint de um mês. Em Sprints mais curtas a duração geralmente é menor.

	c. Review:
		Na Sprint review é feita uma analise do incremento que foi adicionado ao produto, além da adptação do Product Backlog caso seja necessário. Ela é limitada a duração de 4 horas para sprints de um mês, podendo durar menos em sprints mais curtas.

	d. Retrospectiva:
		Enquanto a Sprint Review foca na análise do incremento que foi adicionado, a Sprint Retrospective será uma análise do processo Scrum em si, o processo de desenvolvimento, comunicação e dinâmica da equipe, fluxo de entregas, ambiente e ferramentas de trabalho. A duração máxima é de até 3 horas, mas em Sprints mais curtas o tempo de duração geralmente é menor.

2. Para que serve e como funciona o Framework Scrum?

	R = O Scrum é um framework utilizado para gerenciamento de projetos complexos. Devido a seus príncipios de transparência, inspeção e adaptação, o Scrum torna os processos mais claros e simples tendo em vista o constante feedback da situação atual do projeto e da inspeção contínua  da equipe focando na meta e objetivo da Sprint. 

	O Scrum é organizado em Sprint Planning, Sprints, Dailys, Sprint Review e Sprint Retropesctive. Sprint Planning onde é definido o que sera feito, o que será construído nas Sprints, que são ciclos de atividade que duram de 2 a 4 semanas na qual ao final devem produzir um incremento ao produto que está sendo construído. São realizadas as chamadas dailys, reuniões diárias de 15 minutos na qual a equipe responde 3 perguntas relacionadas ao andamento do projeto: O que foi feito desde a última reunião, o que será feito e se houveram impecílios para realização da tarefa.No final da Sprint, ocorre a Sprint Review onde é feita a análise do incremento que foi construído e adaptação do Product BackLog caso haja necessidade. Após a Sprint Review é feita a Sprint Retrospective que é uma analise do processo Scrum em si, é analisado o processo de desenvolvimento, a dinâmica e comunicação do time Scrum, fluxo de entregas, ambiente e ferramentas de trabalho, ou seja, diferente da Sprint Review que é focada no produto, a Retrospective é focado nas pessoas, nos relacionamentos. 

	No Scrum há 3 papéis básicos: O Scrum Master, o Product Owner e o Dev Team.
	O Scrum Master é um facilitador, ele é quem garante que a equipe esteja engajada com os valores & práticas do Scrum, detêm um papel importante garantindo que a equipe entenda e aplique de melhor forma o Scrum. 

	O product Owner, dono do produto, responsável por conduzir o projeto de acordo com o desejo do cliente e demais stakeholders, ele detêm autonomia para definir e priorizar quais serão as funcionalidades que serão constrúidas, sendo assim ele é o unico responsável por gerenciar o Product Backlog  e transmitir para o time Scrum uma visão clara dos requisitos, prioridades e metas do projeto. 
	Dev Team, o time de desenvolvimento é responsável pela construção do produto, sendo autogerenciável e decidindo como realizar o que foi especificado pelo PO no Product Backlog.
	Também há os artefatos gerados pelos eventos do Scrum, O Product Backlog que reúne o os requisitos e funcionalidades necessárias ao produto; O Backlog da Sprint, que reúne as funcionalidades escolhidas do Backlog para serem constrúidas na Sprint, e por fim o Incremento que é a entrega parcial feita no final da Sprint.

3. José iniciou sua jornada recentemente com git e não está conseguindo
publicar seu arquivo README e a classe Product.js que acabou de criar. O
erro do git dá a seguinte informação:

		Untracked Files:
		README
		Product.js
Por que esse “erro” de “Untracked files” ocorreu e qual comando resolveria
o problema?
	
	R = Isso ocorre quando há arquivos no repositório que não estão sendo monitorados pelo GIT. Para resolver isso, José deve executar o comando(sem aspas)  “git add READM”, depois “git add Product.js” ou ainda “git add .” Para que o git monitore as alterações feitas em ambos os arquivos.

4. O time de desenvolvimento analisou e descobriu que o projeto está gerando
arquivos pesados e desnecessários para serem commitados no repositório
git. Em qual arquivo você deve incluir a lista de extensões para que esses
arquivos desnecessários sejam desconsiderados?

	R = Deve ser incluído no arquivo “.gitignore”, esse arquivo deve ser criado e dentro dele devem ser escritos os nomes dos arquivos que pretendemos fazer o git não rastrear.


5. José foi promovido de seu cargo anterior e se tornou o novo Product Owner
do time, quais são suas novas responsabilidades como PO?

6. Escreva um programa Java que tem como objetivo ser um quiz de
perguntas e respostas. Na tela, você perguntará ao usuário e ele
responderá. Se o usuário acertar ou errar, você precisa informar se ele
acertou ou errou e passar para próxima pergunta (enquanto houver
próxima). Utilizem array para guardar as perguntas e respostas. Na tela
perguntará ao usuário o nome, e por vez assim as perguntas, caso o
usuário acerte ele demonstre os erros e acertos (como no exemplo abaixo):
Usuário XPTO:
Acertos: 6
Erros:4

7. Escreva um programa em Java que tem como objetivo validar se um
usuário e senha existem no sistema. Se o usuário e senha tiver corretos, o
usuário deverá receber uma mensagem de acordo com o horário. (Utilizem
arrays para armazenar os dados)
• Se for das 6h às 11h59 da manhã, receberá “Bom dia, você se
logou ao nosso sistema.”
• Se for das 12 às 17h59 da tarde, receberá “Boa tarde, você se
logou ao nosso sistema.”
• Se for das 18h às 23h59 da noite, receberá “Boa noite, você se
logou ao nosso sistema.”
• Se for das 0h às 05h59 da madrugada, receberá “Boa madrugada,
você se logou ao nosso sistema.”
• Se o usuário ou senha for inválidos, deverá exibir a mensagem:
“Usuário e/ou senha incorretos.”


8. Escreva um programa Java que tem como objetivo validar se um
determinado funcionário tem direito a bonificação. O programa precisa
receber a quantidade de funcionários que serão cadastrados e após isso, o
programa deve armazenar o nome e o salário de cada funcionário. Se o
usuário receber até R$ 1000,00 reais, receberá 20% de bonificação. Se
receber acima de 1000 e menos que 2000, recebe 10%. Se for acima de
2000, em vez de bonificação, o funcionário terá um desconto de 10%. No
fim do programa, deverá ter uma saída com os nomes dos funcionários,
salário, bônus ou desconto e salário líquido. (Utilizem arrays para
armazenar os dados.).
Exemplo:
Funcionário XPTO
• Salário: 1200,00
• Bônus: 120,00
• Salário Líquido: 1320,00

Funcionário XYZ
• Salário: 3000,00
• Desconto: 300,00
• Salário Líquido: 2700,00

Funcionário ABC
• Salário: 700,00
• Bônus: 140,00
• Salário Líquido: 840,00
