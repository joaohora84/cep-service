/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joaoantonio.cepservice;

import javax.enterprise.context.Dependent;


public final class ViaCepService extends AbstractCepService {

    public ViaCepService() {
        
        super("https://viacep.com.br");
    }

    @Override
    protected String buildPath(String cep) {
        
        return String.format("/ws/" + cep + "/json");
        
    }
    
}
