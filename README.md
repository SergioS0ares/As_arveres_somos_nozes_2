# Benchmark-de-Pesquisa
Trabalho sobre busca de árvores.
Benchmark de Pesquisa

**Descrição:**
Faça um programa que leia um arquivo texto (no formato .txt) e imprima, em ordem
alfabética, as palavras e a suas frequências no texto, além de indicadores de
performance dos algoritmos implementados. A leitura do arquivo deverá desprezar
espaços em branco e sinais de pontuação, que serão considerados separadores de
palavras. Além disso, a leitura também deverá ignorar as stopwords em português
(https://gist.github.com/alopes/5358189) e por fim, a leitura deverá converter todas as
letras maiúsculas em minúsculas.

A busca e inserção das palavras do texto deverão ser implementadas com as seguintes
estruturas:
1. Busca Binária (utilizando um vetor dinâmico para armazenar as palavras).
2. Árvore Binária de Pesquisa sem balanceamento.
3. Árvore Binária de Pesquisa com balanceamento (Árvore AVL).

Coloque contadores no seu programa para determinar o número de comparações de
chaves e atribuições de registros necessárias para montar a tabela de frequências em
cada uma das estruturas acima. Conte apenas o número de comparações para montar
a estrutura (operações de inserir e pesquisar). Você não deve considerar as operações
na fase de impressão ordenada. Calcule também o tempo que cada estrutura leva apara
montar a tabela. Analise, por meio dos dados coletados, a eficiência de cada estrutura.

A entrada de dados será um arquivo de texto contendo um texto qualquer. Observe um
exemplo de arquivo de entrada abaixo.
Exemplo de arquivo texto:
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
Deverá ser impresso na tela um resumo completo da execução para todas as três
estruturas implementadas. As estruturas devem ser impressas em ordem de

desempenho (as que gastaram menos tempo primeiro). Em seguida, as frequências das
palavras devem ser impressas. Para esta impressão, deverá ser utilizada a estrutura
indicada pelo parâmetro passado na linha de comando.
Segue um exemplo fictício para indicar o formato da saída:

**Pontos Extras:**
Será concedido até 20,0 pontos extras para o grupo que desenvolver uma interface
gráfica de qualidade para o sistema. Para valer nota extra, a interface gráfica deve
implementar os seguintes recursos:
• Leitura do arquivo: uma interface para escolher o arquivo texto.
• Visualização das árvores: alguma forma de visualização das árvores. Este
recurso é especialmente interessante para o aluno perceber, visualmente, o grau
de degeneração da Árvore Binária de Pesquisa sem Balanceamento em
situações específicas.
