package le1.plp.expressions1.expression;

import le1.plp.expressions1.util.Tipo;
import le1.plp.expressions1.util.TipoPrimitivo;
import le1.plp.expressions2.memory.AmbienteCompilacao;
import le1.plp.expressions2.memory.AmbienteExecucao;

public class ExpMult extends ExpBinaria {
    public ExpMult(Expressao esq, Expressao dir) {
        super(esq, dir, "*");
    }

    public Valor avaliar(AmbienteExecucao amb) {
        Valor v1 = getEsq().avaliar(amb);
        Valor v2 = getDir().avaliar(amb);

        if (v1 instanceof ValorInteiro && v2 instanceof ValorInteiro) {
            return new ValorInteiro(((ValorInteiro) v1).valor() * ((ValorInteiro) v2).valor());
        } else {
            throw new RuntimeException("Tipos incompatíveis na multiplicação");
        }
    }

    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) {
        Tipo t1 = getEsq().getTipo(amb);
        Tipo t2 = getDir().getTipo(amb);
        return (t1.eInteiro() && t2.eInteiro());
    }

    public Tipo getTipo(AmbienteCompilacao amb) {
        return TipoPrimitivo.INTEIRO;
    }
}