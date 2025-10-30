package com.senac.prova.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.prova.dto.request.UsuarioRequest;
import com.senac.prova.dto.response.PedidoResponse;
import com.senac.prova.dto.response.UsuarioResponse;
import com.senac.prova.entity.Usuario;
import com.senac.prova.interfaces.PedidoClient;
import com.senac.prova.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoClient pedidoClient;

    public UsuarioResponse criarUsuarios(UsuarioRequest request){
        Usuario usuarioRequest = modelMapper.map(request, Usuario.class);
        usuarioRequest.setStatus(1);
        Usuario usuarioSalvo = usuarioRepository.save(usuarioRequest);
        return modelMapper.map(usuarioSalvo, UsuarioResponse.class);
    }

    

    public List<UsuarioResponse> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponse> responses = usuarios.stream()
        .map(usuario -> modelMapper.map(usuario, UsuarioResponse.class))
        .collect(Collectors.toList());
        for(UsuarioResponse usuario : responses){
            List<PedidoResponse> pedidos = pedidoClient.listarPedidosPorUsuario(usuario.getId());
            usuario.setPedidos(pedidos);
        }
        
        return responses;
    }
}
