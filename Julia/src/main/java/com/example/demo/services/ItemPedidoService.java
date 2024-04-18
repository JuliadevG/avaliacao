package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ItemPedido;
import com.example.demo.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itempedidoRepository;

	public List<ItemPedido> getAllItemPedidos() {
		return itempedidoRepository.findAll();
	}

	public ItemPedido getItemPedidoById(long itecodigo) {
		return itempedidoRepository.findById(itecodigo).orElse(null);
	}

	public ItemPedido saveItemPedido(ItemPedido itempedido) {
		return itempedidoRepository.save(itempedido);
	}

}