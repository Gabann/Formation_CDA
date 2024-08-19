package com.example.hexagonal.adapter.rest.controller;

import com.example.hexagonal.domain.service.EventService;
import com.example.hexagonal.shared.dto.EventDTO;
import com.example.hexagonal.shared.enums.EventTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController
{
	private final EventService service;

	@Autowired
	public EventController(EventService service)
	{
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<EventDTO> save(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
	                                     @RequestParam EventTypes eventType)
	{
		return ResponseEntity.ok(service.save(date, eventType));
	}

	@GetMapping
	public ResponseEntity<List<EventDTO>> get()
	{
		return ResponseEntity.ok(service.get());
	}
}
