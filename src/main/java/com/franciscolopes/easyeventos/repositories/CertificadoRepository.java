package com.franciscolopes.easyeventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.franciscolopes.easyeventos.domain.Certificado;

@Repository//um objeto desse evento é capaz de realizar operações de acesso a dados referente a objetos bloco
public interface CertificadoRepository extends JpaRepository<Certificado, Integer>{
	
}
