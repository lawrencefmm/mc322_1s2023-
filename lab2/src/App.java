public class App {
    public static void main(String[] args) throws Exception {
        String teste = "082.439.894-71";
        System.out.println(teste);
        teste = teste.replaceAll("[^0-9]", "");
        System.out.println(teste);
        teste = teste.replaceAll("\\-", "");
        System.out.println(teste);

        String aux = "";
        System.out.println(aux.length());
    }
}
