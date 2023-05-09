public enum MenuListar {
    CLIENTE_SEG(0),
    SINISTRO_SEG(1),
    SINISTRO_CLIENTE(2),
    VEICULO_CLIENTE(3),
    VEICULO_SEG(4),
    SAIR(5);

    public final int operacao;
    MenuListar(int operacao) {
        this.operacao = operacao;
    }
    public int getOperacao () {
        return this.operacao;
    }

}
