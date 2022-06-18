package com.esii.aulapratica3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esii.aulapratica3.entity.Empresa;
import com.esii.aulapratica3.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa buscarEmpresaPorCNPJ(String cnpj) throws RuntimeException {
		if (cnpj == null || cnpj.isEmpty()) {
			throw new RuntimeException("O CNPJ é obrigatório");
		}

		List<Empresa> lEmp = this.empresaRepository.findByCNPJ(cnpj);
		return (lEmp.isEmpty() ? null : lEmp.get(0));
	}
}
