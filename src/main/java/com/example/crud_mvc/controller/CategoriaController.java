package com.example.crud_mvc.controller;

import com.example.crud_mvc.dto.ApiResponse;
import com.example.crud_mvc.model.Categoria;
import com.example.crud_mvc.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String categorias(Model model){
            return "categorias/listcat";
    }

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar() {
        return ResponseEntity.ok(
                ApiResponse.ok("Listado Correcto",categoriaService.readAll())
        );
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Categoria categoria, BindingResult result, Model model) {
        if(result.hasErrors()) {
            //model.addAttribute("categorias", categoriaService.readAll());
            String mensaje = result.getFieldErrors().get(0).getDefaultMessage();
        }
        categoriaService.create(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        categoriaService.delete(id);
        return "redirect:/categorias";
    }

}
