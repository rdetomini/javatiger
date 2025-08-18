package com.jagrinho.jatiger.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jagrinho.jatiger.api.model.inputs.configuracao.CreateConfiguracaoModel;
import com.jagrinho.jatiger.api.model.inputs.configuracao.UpdateConfiguracaoModel;
import com.jagrinho.jatiger.api.model.inputs.empresa.CreateEmpresaModel;
import com.jagrinho.jatiger.api.model.inputs.jogada.CreateJogadaModel;
import com.jagrinho.jatiger.api.model.inputs.usuario.CreateUsuarioModel;
import com.jagrinho.jatiger.api.model.outputs.configuracao.ViewConfiguracaoModel;
import com.jagrinho.jatiger.api.model.outputs.empresa.ViewEmpresaModel;
import com.jagrinho.jatiger.api.model.outputs.jogada.ViewJogadaModel;
import com.jagrinho.jatiger.api.model.outputs.usuario.ViewUsuarioModel;
import com.jagrinho.jatiger.domain.entities.Configuracao;
import com.jagrinho.jatiger.domain.entities.Empresa;
import com.jagrinho.jatiger.domain.entities.Jogada;
import com.jagrinho.jatiger.domain.entities.Usuario;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Empresa.class, CreateEmpresaModel.class);
        modelMapper.createTypeMap(Empresa.class, ViewEmpresaModel.class);

        modelMapper.createTypeMap(Configuracao.class, CreateConfiguracaoModel.class);
        modelMapper.createTypeMap(Configuracao.class, UpdateConfiguracaoModel.class);
        modelMapper.createTypeMap(Configuracao.class, ViewConfiguracaoModel.class);

        modelMapper.createTypeMap(Usuario.class, CreateUsuarioModel.class);
        modelMapper.createTypeMap(Usuario.class, ViewUsuarioModel.class);

        modelMapper.createTypeMap(Jogada.class, CreateJogadaModel.class);
        modelMapper.createTypeMap(Jogada.class, ViewJogadaModel.class);
        return modelMapper;
    }
}
