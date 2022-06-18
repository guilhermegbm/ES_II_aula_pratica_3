package com.esii.aulapratica3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esii.aulapratica3.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("from Empresa e where e.cnpj = :cnpj")
	List<Empresa> findByCNPJ(@Param("cnpj") String cnpj);
}
