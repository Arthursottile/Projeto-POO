// Arthur Aloysio Sottile Serrarens a2601338

public class Main {
    public static void main(String[] args) {
        Leitura leitura = new Leitura();
        Gravadora sony = new Gravadora("Sony Music", "Rua Principal, 123");

        String nomeCantor = leitura.entDados("Digite o nome do cantor:");
        System.out.println();
        int anoNascimentoCantor = Integer.parseInt(leitura.entDados("Digite o ano de nascimento do cantor:"));
        System.out.println();
        Cantor cantor = new Cantor(nomeCantor, anoNascimentoCantor);
        sony.setCantor(cantor);

        String nomeProdutor = leitura.entDados("Digite o nome do produtor:");
        System.out.println();
        int anoNascimentoProdutor = Integer.parseInt(leitura.entDados("Digite o ano de nascimento do produtor:"));
        System.out.println();
        Produtor produtor = new Produtor(nomeProdutor, anoNascimentoProdutor);
        sony.setProdutor(produtor);

        String tituloAlbum = leitura.entDados("Digite o titulo do album:");
        System.out.println();
        int anoLancamento = Integer.parseInt(leitura.entDados("Digite o ano de lancamento do album:"));
        System.out.println();
        int faixas = Integer.parseInt(leitura.entDados("Digite o total de faixas:"));
        System.out.println();
        String genero = leitura.entDados("Digite o genero do album:");
        System.out.println();
        Album album = new Album(tituloAlbum, anoLancamento, faixas, genero, sony);
        album.setProdutor(produtor);
        sony.setAlbum(album);

        System.out.println("Cantor da Gravadora:\n");
        System.out.println("Nome: " + cantor.getNome());
        System.out.println("Ano de Nascimento: " + cantor.getAnoNascimento() + "\n");

        System.out.println("Albuns da Gravadora:\n");
        System.out.println(album.exibirInformacoes());
    }
}
