//A questão 4 pede para que façamos uma análise testando diferentes quantidades de leitores e escritores para o mesmo recurso compartilhado. Realizando essa analise foi percebido que 
//Idependente do numero de escritores, o volume de leituras sempre vai ser maior do que de escritas realizadas, isso se da pelo fato de que N leituras podem ser realizadas ao mesmo
//portanto, é possível que seja feita mais de 1 leitura antes de realizar uma escrita, portanto a frequencia com que o recurso se altera entre uma leitura e outra é bem pequena considerando
//a frequencia com que é feita as leituras.