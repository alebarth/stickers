import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {

	public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
		
		// leitura da imagem
		//InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// criar nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage imagemNova = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original pra imagem nova (em memória)
		Graphics2D graficos = (Graphics2D) imagemNova.getGraphics();
		graficos.drawImage(imagemOriginal, 0, 0, null);
		
		// configurar a fonte da frase
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graficos.setColor(Color.RED);
		graficos.setFont(fonte);
		
		// escrever uma frase na imagem nova
		graficos.drawString("TOPZERA", 180, novaAltura - 100);
		
		// escrever a imagem nova em um arquivo
		ImageIO.write(imagemNova, "png", new File(nomeArquivo));
	}
}
