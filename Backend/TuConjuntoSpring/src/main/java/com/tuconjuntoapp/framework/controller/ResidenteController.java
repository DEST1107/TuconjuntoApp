package com.tuconjuntoapp.framework.controller;

import com.tuconjuntoapp.framework.model.Residente;
import com.tuconjuntoapp.framework.service.ResidenteService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/residentes")
public class ResidenteController {

    private final ResidenteService residenteService;

    public ResidenteController(ResidenteService residenteService) {
        this.residenteService = residenteService;
    }

    @GetMapping
    public String listar(@RequestParam(value = "correo", required = false) String correo, Model model) {
        // GET para mostrar todos los residentes o aplicar filtro por correo.
        model.addAttribute("residentes", residenteService.listar(correo));
        model.addAttribute("correoBuscado", correo);
        return "residentes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("residente", new Residente());
        model.addAttribute("tituloFormulario", "Registrar residente");
        return "residentes/formulario";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model,
                                           RedirectAttributes redirectAttributes) {
        return residenteService.buscarPorId(id)
                .map(residente -> {
                    model.addAttribute("residente", residente);
                    model.addAttribute("tituloFormulario", "Editar residente");
                    return "residentes/formulario";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("mensaje", "No se encontro el residente solicitado.");
                    return "redirect:/residentes";
                });
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("residente") Residente residente,
                          BindingResult bindingResult,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        // POST para crear o actualizar el residente desde el mismo formulario.
        if (bindingResult.hasErrors()) {
            model.addAttribute("tituloFormulario",
                    residente.getIdUsuario() == null ? "Registrar residente" : "Editar residente");
            return "residentes/formulario";
        }

        boolean nuevo = residente.getIdUsuario() == null;
        residenteService.guardar(residente);
        redirectAttributes.addFlashAttribute("mensaje",
                nuevo ? "Residente registrado correctamente." : "Residente actualizado correctamente.");
        return "redirect:/residentes";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        residenteService.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Residente eliminado correctamente.");
        return "redirect:/residentes";
    }
}
