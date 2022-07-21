import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Program {

	public static void main(String[] args) throws Exception {

		// fazer uma conexão HTTP e buscar o conteudo desejado
		
		// IMDB
		//String url = "https://api.mocki.io/v2/549a5d8b";
		//ExtratorConteudo extrator = new ExtratorConteudoIMDB();
		
		//NASA
		String url = "https://api.nasa.gov/planetary/apod?api_key=UvkSOtKQupSGh6fckTTmuoSRZw7YmyW2m4MZJQaf&start_date=2022-06-12&end_date=2022-06-14";
		ExtratorConteudo extrator = new ExtratorConteudoNasa();
		
		ClienteHttp http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		// exibir e manipular os dados
		List<Conteudo> conteudos = extrator.extrairConteudo(json);
		
		GeradorFigurinhas geradora = new GeradorFigurinhas();
		
		for (int i=0; i<3; i++) {
			
			Conteudo conteudo = conteudos.get(i);
			
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
			
			geradora.criar(inputStream, nomeArquivo);
			
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
	}
}
