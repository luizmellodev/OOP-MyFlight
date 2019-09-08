import java.time.Duration;
import java.time.LocalDateTime;

public class App {

	public static void main(String[] args) {


		System.out.println("MyFlight project...");

        GerenciadorCias cias = new GerenciadorCias();
		CiaAerea c1  = new CiaAerea ("G3", "Gol");
        CiaAerea c2  = new CiaAerea ("JJ", "LATAM");
        CiaAerea c3  = new CiaAerea ("AZ", "Azul");

        cias.inserir(c1);
        cias.inserir(c2);
        cias.inserir(c3);

        for (CiaAerea c: cias.getCias()){
            System.out.println(c + "\n");
        }

        Geo portoAlegre = new Geo(23,22);
        Geo saoPaulo = new Geo (24, 26);
        Geo london = new Geo (35,39);

        Aeroporto portoAlegreAero = new Aeroporto ("POA", "Porto Alegre", portoAlegre);
        Aeroporto saoPauloAero = new Aeroporto ("GRU", "São Paulo", saoPaulo);
        Aeroporto londonAero = new Aeroporto ("LON" , "Londres", london);

        Aeronave aviao1 = new Aeronave ("B747", "Boing 747", 200);

        Rota origem = new Rota (portoAlegreAero, saoPauloAero, aviao1, c1);
        Rota destino = new Rota (saoPauloAero, londonAero, aviao1, c1);


        LocalDateTime datahora = LocalDateTime.of(2019, 6, 30, 12, 00);
        Duration duracao = Duration.ofMinutes(120); // 2 horas


/*--------------------------------------------------------------------------*/
        VooEscalas vooTeste = new VooEscalas(origem, datahora, duracao);
        vooTeste.adicionarRota(destino);
        System.out.print (vooTeste);

		VooDireto vooTeste2 = new VooDireto(origem, datahora, duracao);
		System.out.print (vooTeste2);

		 
	}
}