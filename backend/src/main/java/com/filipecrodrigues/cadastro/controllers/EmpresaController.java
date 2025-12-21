package com.filipecrodrigues.cadastro.controllers;

import com.filipecrodrigues.cadastro.entities.Empresa;
import com.filipecrodrigues.cadastro.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller REST
@RestController

// Endpoint base da API
@RequestMapping("/api/empresas")
public class EmpresaController {

    // Service com regras de negócio
    private final EmpresaService empresaService;

    // Injeção via construtor (melhor prática)
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // ===============================
    // CREATE
    // ===============================
    @PostMapping
    public ResponseEntity<Empresa> cadastrar(
            // @Valid ativa as validações da entidade
            @RequestBody @Valid Empresa empresa) {

        Empresa empresaSalva = empresaService.cadastrar(empresa);
        return ResponseEntity.ok(empresaSalva);
    }

    // ===============================
    // READ - Listar todas
    // ===============================
    @GetMapping
    public ResponseEntity<List<Empresa>> listarTodas() {

        return ResponseEntity.ok(empresaService.listarTodas());
    }

    // ===============================
    // READ - Buscar por ID
    // ===============================
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    // ===============================
    // UPDATE
    // ===============================
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Empresa empresa) {

        return ResponseEntity.ok(empresaService.atualizar(id, empresa));
    }

    // ===============================
    // DELETE
    // ===============================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        empresaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
