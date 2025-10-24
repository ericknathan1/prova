package com.senac.prova.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.senac.prova.dto.response.PedidoResponse;


@FeignClient(name="avaliacao", url="http://10.136.36.121/pedido")
public interface PedidoClient {

    @GetMapping("/listar/{usuarioId}")
    List<PedidoResponse> listarPedidosPorUsuario(@PathVariable("usuarioId") Integer id);
}
