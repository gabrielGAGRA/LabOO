public class VendasForaSP extends Vendas {
    private static final float TAXA_IMPOSTO = 0.08f;
    private static final float VALOR_FRETE = 30.0f;

    public VendasForaDeSaoPaulo(int codigoItem, String nomeItem, float valorTotalVenda) {
        super(codigoItem, nomeItem, valorTotalVenda);
    }

    @Override
    public float getFrete() {
        return VALOR_FRETE;
    }

    @Override
    public float getImposto() {
        return this.valorTotalVenda * TAXA_IMPOSTO;
    }

    @Override
    public String getTipoVenda() {
        return "Fora de SP";
    }
}