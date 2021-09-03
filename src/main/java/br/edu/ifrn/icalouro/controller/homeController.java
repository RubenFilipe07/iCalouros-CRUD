package br.edu.ifrn.icalouro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/** Esta classe contém os métodos para entrar em algumas páginas do site. */
@Controller
public class homeController {

	@GetMapping("/")
	public String inicio() {
		return "home/index";
	}
	
	@GetMapping("eventos/codegirl")
	public String codeGirl() {
		return "eventos/codegirl";
	}
	
	@GetMapping("eventos/expotec")
	public String expotec() {
		return "eventos/expotec";
	}
	
	@GetMapping("eventos/semadec")
	public String semadec() {
		return "eventos/semadec";
	}
	
	@GetMapping("curso/informatica")
	public String informatica() {
		return "curso/informatica";
	}
	
	@GetMapping("curso/materias")
	public String materias() {
		return "curso/materias";
	}
	
	@GetMapping("forum/forum")
	public String hospedagem() {
		return "forum/forum";
	}
	
	@GetMapping("/login")
	public String login() {
	    return "usuario/login";
	}

	@GetMapping("/login-error")
    public String loginError(ModelMap model) {
	    model.addAttribute("msgErro", "Login ou senha incorreto. Tente novamente!");
	    return "usuario/login";
	 }
	
}
