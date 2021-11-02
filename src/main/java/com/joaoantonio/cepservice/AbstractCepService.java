/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaoantonio.cepservice;

import com.joaoantonio.model.Endereco;
import java.util.Objects;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


public abstract class AbstractCepService implements CepService {
    
    private static final Logger LOG = Logger.getLogger(AbstractCepService.class.getName());

    private final String dominio;
    private final WebTarget target;
    
    public AbstractCepService(String dominio){
        this.dominio = insertTrailingSlash(Objects.requireNonNull(dominio));
        Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }
    
    protected final String insertTrailingSlash(String path){
        
        return path.endsWith("/") ? path : path + "/";
        
    }

    @Override
    public Endereco buscaEndereco(String cep) {
        
        LOG.info(
                String.format(this.dominio + buildPath(cep))
        );
        
        Objects.requireNonNull(cep, "CEP NAO PODE SER NULO");
        
        
        return target.path(buildPath(cep)).request().get(Endereco.class);
        
    }
    
    protected String getFullPath(String cep){
      
        return this.dominio + buildPath(cep);
    }
    
    
     protected abstract String buildPath(String cep);
    
}
