/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaoantonio.cepservice;

import javax.enterprise.context.Dependent;

@Dependent
public final class WidenetCepService extends AbstractCepService {
    
    private static final String DOMINIO = "https://apps.widenet.com.br/";

    public WidenetCepService() {
        super(DOMINIO);
    }

    @Override
    protected String buildPath(String cep) {
        
        return "busca-cep/api/cep.json?code=" + cep;
        
    }
    
}
