package com.joaoantonio.cepservice;

import com.joaoantonio.model.Endereco;

public interface CepService {
	
    Endereco buscaEndereco(String cep);

}
