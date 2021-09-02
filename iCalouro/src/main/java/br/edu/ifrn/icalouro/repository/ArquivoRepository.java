package br.edu.ifrn.icalouro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrn.icalouro.dominio.Arquivo;

/** Esta interface é o repositório da classe Arquivo.*/
public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{
}