public class VendasExterior extends Vendas {
    private static final float TAXA_IMPOSTO = 0.0;
    private static final float VALOR_FRETE = 100.0f;

    public VendasExterior(int codigoItem, String nomeItem, float valorTotalVenda) {
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
        return "Exterior";
    }
}
