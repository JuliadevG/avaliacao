package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ItemPedido;
import com.example.demo.services.ItemPedidoService;

@RestController
@RequestMapping("/funcionario")
public class ItemPedidoController {

	private final ItemPedidoService itempedidoService;

	public ItemPedidoController(ItemPedidoService itempedidoService) {
		this.itempedidoService = itempedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> findItemPedidobyId(@PathVariable Long id) {
		ItemPedido itempedido = itempedidoService.getItemPedidoById(id);
		if (itempedido != null) {
			return ResponseEntity.ok(itempedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<ItemPedido>> findAllItemPedidoscontrol() {
		List<ItemPedido> itempedido = itempedidoService.getAllItemPedidos();
		return ResponseEntity.ok(itempedido);
	}

	@PostMapping("/")
	public ResponseEntity<ItemPedido> insertItemPedidosControl(@RequestBody ItemPedido itempedido) {
		ItemPedido novoitempedido = itempedidoService.saveItemPedido(itempedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoitempedido);
	}

}

