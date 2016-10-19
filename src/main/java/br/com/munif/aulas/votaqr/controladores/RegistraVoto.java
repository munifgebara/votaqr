package br.com.munif.aulas.votaqr.controladores;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author munif
 */
@WebServlet(name = "RegistraVoto", urlPatterns = {"/voto"})
public class RegistraVoto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        String ip=requisicao.getRemoteAddr();
        String opcao=requisicao.getParameter("opcaoid");
        resposta.setCharacterEncoding("UTF-8");
        resposta.setContentType("text/html");
        OutputStream saida = resposta.getOutputStream();
        PrintWriter pw=new PrintWriter(saida);
        pw.print("Seu voto foi registrado do endereço "+ip+" na opção "+opcao);
        pw.close();
        
    }
    
    


}
