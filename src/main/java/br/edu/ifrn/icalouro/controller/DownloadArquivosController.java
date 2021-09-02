package br.edu.ifrn.icalouro.controller;

import java.math.MathContext;
import java.util.List;
import java.util.Random;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.ifrn.icalouro.dominio.Arquivo;
import br.edu.ifrn.icalouro.dominio.Usuario;
import br.edu.ifrn.icalouro.repository.ArquivoRepository;
import br.edu.ifrn.icalouro.repository.UsuarioRepository;

/** Esta classe contém a estrutura para downloads.*/
@Controller
public class DownloadArquivosController {

  @Autowired
  private ArquivoRepository arquivoRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  /** Este método busca uma lista de usuários e o retorna como um download.*/
  @GetMapping("/download")
  public ResponseEntity < ? > downloadFile(@PathParam("salvar") String salvar) {

    List < Usuario > lista = usuarioRepository.findAll();
    String conteudo = "";

    for (int i = 0; i <= (lista.size() - 1); i++) {
      conteudo = conteudo + "\n" +
    		  "ID: " +  lista.get(i).getId() + 
    		  "\n" + 
    		  "EMAIL:" + lista.get(i).getEmail() +
    		  "\n" + 
    		  "PERFIL:" + lista.get(i).getPerfil();
    }

    Arquivo relatorioUsuarios = new Arquivo(null, "relatorioUsuarios.txt", "text/plain", conteudo.getBytes());
  
    String texto = (salvar == null || salvar.equals("true")) ? "attachment; filename=\"" + relatorioUsuarios.getNomeArquivo() + "\"" :
      "inline; filename=\"" + relatorioUsuarios.getNomeArquivo()+ "\"";
    return ResponseEntity.ok()
      .contentType(MediaType.parseMediaType(relatorioUsuarios.getTipoArquivo()))
      .header(HttpHeaders.CONTENT_DISPOSITION, texto)
      .body(new ByteArrayResource(relatorioUsuarios.getDados()));
  }
}