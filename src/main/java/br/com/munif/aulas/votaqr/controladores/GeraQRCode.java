package br.com.munif.aulas.votaqr.controladores;

import br.com.munif.aulas.votaqr.services.QRCodeService;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GeraQRCode", urlPatterns = {"/geraqrcode"})
public class GeraQRCode extends HttpServlet {
    
    private QRCodeService qRCodeService=new QRCodeService();

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        String opcao = requisicao.getParameter("opcaoid");
        resposta.setContentType("image/png");
        OutputStream saida = resposta.getOutputStream();
        BufferedImage imagem = qRCodeService.gera("http://munif.com.br/votaqr/voto?opcaoid="+opcao);
        ImageIO.write(imagem, "PNG", saida);
    }

}
