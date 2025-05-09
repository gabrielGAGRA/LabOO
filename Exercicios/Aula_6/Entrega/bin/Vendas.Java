/* Implemente em Java, usando Polimorfismo, uma boa arquitetura OO para o seguinte problema. */

/* Cada venda possui um código do item, nome do item e valor da venda.*/
public abstract class Vendas {
    protected int codigoItem;
    protected String nomeItem;
    protected float valorTotalVenda;

    public Vendas(int codigoItem, String nomeItem, float valorTotalVenda) {
        this.codigoItem = codigoItem;
        this.nomeItem = nomeItem;
        this.valorTotalVenda = valorTotalVenda;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public float getValorTotalVenda() {
        return valorTotalVenda;
    }

    public abstract float getFrete();

    public abstract float getImposto();

    public abstract String getTipoVenda();

    public float getReceitaLiquida() {
        return this.valorTotalVenda - getImposto() - getFrete();
    }
}