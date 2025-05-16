public class VendasDentroSP extends Vendas {
    private static final float TAXA_IMPOSTO = 0.12f;
    private static final float VALOR_FRETE = 10.0f;

    public VendasDentroDeSaoPaulo(int codigoItem, String nomeItem, float valorTotalVenda) {
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
        return "Dentro de SP";
    }
}
