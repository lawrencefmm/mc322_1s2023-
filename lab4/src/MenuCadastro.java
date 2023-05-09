public enum MenuCadastro {
    CLIENTE(0),
    VEICULO(1),
    SEGURADORA(2),
    SAIR(3);

    public final int operacao;
    MenuCadastro(int operacao) {
        this.operacao = operacao;
    }
    public int getOperacao() {
        return this.operacao;
    }

}