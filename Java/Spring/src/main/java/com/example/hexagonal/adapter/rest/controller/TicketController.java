package com.example.hexagonal.adapter.rest.controller;

import com.example.hexagonal.domain.service.TicketService;
import com.example.hexagonal.infra.entity.EventEntity;
import com.example.hexagonal.shared.dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController
{
	private final TicketService service;

	@Autowired
	public TicketController(TicketService service)
	{
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<TicketDTO> save(@RequestParam String purchaserName, @RequestParam EventEntity event)
	{
		return ResponseEntity.ok(service.save(purchaserName, event));
	}

	@GetMapping
	public ResponseEntity<List<TicketDTO>> get()
	{
		return ResponseEntity.ok(service.get());
	}
}
