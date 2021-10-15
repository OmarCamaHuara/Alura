// Classe definem uma forma de organizar uma serie de informações repetidas de nosso codigo e por isso devemos usar elas quando temos um codigo que se repete e que faz parte de um contexto coeso.

class Cliente{
    // Atributos con la idea de criar um molde
    nome;
    cpf;
}
// abstraindo de acordo ao contexto do banco
class ContaCorrente{
    agencia;
    // #saldo = 0;
    _saldo = 0;

    // metodos
    sacar(valor){
        if(this._saldo >= valor){
            this._saldo -=valor;
            return valor;
        }else {
            return 0;
        }
    }
    depositar(valor){
        if(valor > 0){
            this._saldo += valor;
        }
    }
}

const cliente1 = new Cliente();
const cliente2 = new Cliente();


cliente1.cpf = 24229004860;
cliente1.nome = "Ricardo";

cliente2.cpf = 56814525485;
cliente2.nome = "Omar";

const contaCorrenteDoRicardo = new ContaCorrente();
const contaCorrenteDoOmar = new ContaCorrente();

contaCorrenteDoOmar.agencia = 1100;

contaCorrenteDoRicardo.depositar(1000);
contaCorrenteDoOmar.depositar(-5);

contaCorrenteDoOmar.sacar(50);

contaCorrenteDoRicardo.agencia = 1100;
const valorSacado = contaCorrenteDoOmar.sacar(50);
console.log(valorSacado + " o valor sacado é");

console.log(contaCorrenteDoOmar, contaCorrenteDoRicardo)

console.log(cliente1, cliente2)
