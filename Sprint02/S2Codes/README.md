
Questão 01 - Composta por 3 classes: Produto, ProdutoDAO e ProdutoMain.
 		
 		A conexão com o banco de Dados é feita através da Classe ConnectionFactory que implementa uma pool de conexões.
 		Foram chumbadas três variáveis de referência:
 		
        Produto cadeira = new Produto("Cadeira", "Cadeira MX5", 5, 750.00);
        Produto abajur = new Produto("Abajur", "Abajur Gamer PKMN", 7, 150)
        Produto mesa = new Produto("Mesa", "Mesa Gamer PKMN", 3, 700.00);
   		
   		Código SQL "Questao1" está contido na pasta S2Codes do diretório.
   		
   		Roteiro de Utilização:

   		1 - Usuário digita uma inteiro de 0 a 3 referente a ação que deseja efetuar, sendo que a opção 0 encerra o programa.
   		2 - Retorno para o usuário de acordo com a opção selecionada.


Questão 02 - Composta por 3 Classes: Filme, FilmeDAO, FilmeMain  
       

       A conexão com o banco de Dados é feita através da classe ConnectionFactory que implementa uma pool de conexões.

   		Roteiro de Utilização:

   		1 - Usuário digita um número inteiro referente a quantos filmes deseja visualizar
   		2 - Usuario digita o número 1 ou 2 que corresponde as duas paginas de filmes.
   		3 - São retornados os filmes filtrados.

   		Código SQL "Questao2" está contido na pasta S2Codes do diretório.


Questao 03 - Composta apenas pela classe Main

	Foram chumbadas 2 variáveis contendo a expressão que deve ser buscada:
		
		String smileyRegex = "\\:-\\)";
    	String sadFaceRegex = "\\:-\\(";

	Roteiro de Utilização:
	 
	 1 - Usuario digita uma frase:
	 2 - É retornado a sensação expressa pela frase de acordo com os emoticons presentes nela.

