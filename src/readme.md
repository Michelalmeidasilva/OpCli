
/**
* METODO SEQUENCIAL com 1/2/4/8 thread FORÇANDO REPETIÇÃO ( FORÇA BRUTA )
* Sem Arvore
* acesso O(n²)
  */

/**
* METODO Paralelo Randomico 1 com 1/2/4/8 thread FORÇANDO REPETIÇÃO ( FORÇA BRUTA )
* com arvore
*    explicação:
*    * O randomico é em cima de cada tentativa de 0 a 1000000, portanto cada thread faz de 0  a 1000000
*    * 0 a 250000
*    * 250000 a 500000
*    * 500000 a 750000
*    * 750000 a 100000
* acesso O(log n)
  */

/**
* METODO Paralelo Randomico 1 com 1/2/4/8 thread FORÇANDO REPETIÇÃO ( FORÇA BRUTA )
* com Tabela Hash
*    explicação:
*    * O randomico é em cima de cada tentativa de 0 a 1000000, portanto cada thread faz de 0  a 1000000
*    * 0 a 250000
*    * 250000 a 500000
*    * 500000 a 750000
*    * 750000 a 100000
* acesso O(1)
  */


/**
* METODO Paralelo Randomico 1 com 1/2/4/8 thread EVITANDO REPETIÇÃO
*    explicação:
*    * O randomico é em cima de cada tentativa de inicial até o tam final , portanto cada thread faz de tamanho inicial ao tamanho final designado
* Distribuir um intervalo a cada thread
*
*          Pararelo diminuindo a ocorrencia de repetições
*          0 a 250000         cada thread faz de 0  a 2500000
*          250000 a 500000      250000  a 500000
*          500000 a 750000      500000  a 500000
*          750000 a 100000      750000  a 500000
* arvore: acesso O(log n)
* hash: O(1)
  */


/**
* DIMINUIÇÂO REPETIÇÂO
* procurar outra forma de embaralhar o vetor ou algo assim
  */


/**
* Forma do Thiago leal
* 0  a 1.000.000
* O vetor é embaralhado e as posições sao retiradas dele
  */


/**
* Tentar enxergar alguma forma de ordenar paralelamente com pilha, arvore ou algo assim
*
*/

/**
* Primeira alternativa de ordenamento, enquanto está sendo inserida na matriz separar por varios vetores e já inserir ordenando
  */

/**
* Aqui  tem todas as posições possiveis da matriz mapeados em uma arvore
* entao em cada interação até a arvore for 0 ele verifica se existe a posição
* e insere na matriz
* Se a variavel interactive estiver com valor true ela imprime as posições randomicas que foram tentadas
  */