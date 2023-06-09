package Aula_02;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void Criar(InputStream inputStream, String nomeArquivo, String texto, InputStream selo) throws Exception{
        // leitura de imagem
        BufferedImage imgOriginal = ImageIO.read(inputStream);
        BufferedImage seloImage = ImageIO.read(selo);

        // criar nova imagem com memoria e transparencia e tamanho novo
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        float novaAltura = altura*1.2f;
        BufferedImage novaImagen = new BufferedImage(largura, (int)novaAltura, BufferedImage.TRANSLUCENT);

        int seloImageY = altura - seloImage.getHeight();

        // copiar imagem original para a nova
        Graphics2D graphics = (Graphics2D)novaImagen.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        graphics.drawImage(seloImage, 0, seloImageY, null);

        // nova fonte
        var fonte = new Font("Impact", Font.BOLD, 128);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);

        // escrever frase na nova imagem
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
        int alturaTexto = (int)retangulo.getHeight();
        int larguraTexto = (int)retangulo.getWidth();

        int posXTexto = (largura - larguraTexto)/2;
        float posYTexto = (novaAltura - altura)/2 + altura + alturaTexto/3;

        graphics.drawString(texto, posXTexto, posYTexto);

        // Definindo estilo do contorno.
        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(texto, fonte, fontRenderContext);

        // Definindo posi��o.
        Shape outLine = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posXTexto, posYTexto);
        graphics.setTransform(transform);

        // Definindo largura do contorno.
        var outLineStoke = new BasicStroke(largura * 0.004f);
        graphics.setStroke(outLineStoke);

        // Definindo cor e desenhando o contorno.
        graphics.setColor(Color.BLACK);
        graphics.draw(outLine);
        graphics.setClip(outLine);

        // salvar em arquivo
        ImageIO.write(novaImagen, "png", new File(nomeArquivo));

    }

}