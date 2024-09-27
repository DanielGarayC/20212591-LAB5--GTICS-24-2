package com.example.lab5_20212591.controller;

import com.example.lab5_20212591.entity.Lugares;
import com.example.lab5_20212591.entity.Mascotas;
import com.example.lab5_20212591.entity.Persona;
import com.example.lab5_20212591.entity.Viajes;
import com.example.lab5_20212591.repository.LugaresRepository;
import com.example.lab5_20212591.repository.MascotasRepository;
import com.example.lab5_20212591.repository.PersonaRepository;
import com.example.lab5_20212591.repository.ViajesRepository;
import jakarta.persistence.Entity;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class TravelController {

    private final LugaresRepository lugaresRepository;
    private final MascotasRepository mascotasRepository;
    private final PersonaRepository personaRepository;
    private final ViajesRepository viajesRepository;

    public TravelController(LugaresRepository lugaresRepository, MascotasRepository mascotasRepository, PersonaRepository personaRepository,ViajesRepository viajesRepository ){
        this.lugaresRepository = lugaresRepository;
        this.mascotasRepository = mascotasRepository;
        this. personaRepository = personaRepository;
        this.viajesRepository = viajesRepository;
    }

    //Viajes
    @GetMapping("/listaViajes")
    public String listarViajes(Model model){
        List<Viajes> listaViajes = viajesRepository.findAll();
        model.addAttribute("listaViajes", listaViajes);
        return "listaViajes";
    }
    @GetMapping("/listaViajes/crear")
    public String crearViaje(Model model){
        List<Persona> listaPersonas = personaRepository.findAll();
        model.addAttribute("listaPersonas", listaPersonas);
        List<Lugares> listaLugares = lugaresRepository.findAll();
        model.addAttribute("listaLugares", listaLugares);
        Viajes viajes = new Viajes();
        model.addAttribute("viaje", viajes);
        return "crearViaje";
    }
    @PostMapping("/listaViajes/registrar")
    public String registrarViaje(Viajes viajes){
        viajesRepository.save(viajes);
        return "redirect:/listaViajes";
    }
    @GetMapping("/listaViajes/verDetalles/{id}")
    public String verViaje(@PathVariable("id") int id, Model model){
        Optional<Viajes> optionalViajes = viajesRepository.findById(id);
        if (optionalViajes.isPresent()){
            model.addAttribute("viaje",optionalViajes.get());
        } else {
            return "listaViajes";
        }
        return "verViaje";
    }
    @GetMapping("/listaViajes/editar/{id}")
    public String editarViaje(@PathVariable("id") int id,Model model){
        Optional<Viajes> optionalViajes = viajesRepository.findById(id);
        model.addAttribute("viaje",optionalViajes);
        return "editViaje";
    }
    @GetMapping("/listaViajes/borrar")
    public String borrarViaje(Model model, @RequestParam("id") int id){
        Optional<Viajes> optionalViajes = viajesRepository.findById(id);

        if (optionalViajes.isPresent()) {
            try {
                viajesRepository.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/listaViajes";
    }

    //Mascotas
    @GetMapping("/listaMascotas")
    public String listarMascotas(Model model){
        List<Mascotas> listaMascotas = mascotasRepository.findAll();

        model.addAttribute("listaMascotas", listaMascotas);
        return "listaMascotas";
    }
    @GetMapping("/listaMascotas/crear")
    public String crearMascota(Model model){
        List<Persona> listaPersonas = personaRepository.findAll();
        model.addAttribute("listaPersonas", listaPersonas);
        Mascotas mascotas = new Mascotas();
        model.addAttribute("mascota", mascotas);
        return "crearMascota";
    }
    @PostMapping("/listaMascotas/registrar")
    public String registrarMascota(Mascotas mascota){
        mascotasRepository.save(mascota);
        return "redirect:/listaMascotas";
    }
    @GetMapping("/listaMascotas/verDetalles/{id}")
    public String verMascota(@PathVariable("id") int id,Model model){
        Optional<Mascotas> optionalMascotas = mascotasRepository.findById(id);
        if (optionalMascotas.isPresent()){
            model.addAttribute("mascota",optionalMascotas.get());
        } else {
            return "listaMascotas";
        }
        return "verMascota";
    }
    @GetMapping("/listaMascotas/editar/{id}")
    public String editarMascota(@PathVariable("id") int id,Model model){
        Optional<Mascotas> optionalMascotas = mascotasRepository.findById(id);
        model.addAttribute("mascota",optionalMascotas);
        return "editMascota";
    }
    @GetMapping("/listaMascotas/borrar")
    public String borrarMascota(Model model, @RequestParam("id") int id){
        Optional<Mascotas> optionalMascotas = mascotasRepository.findById(id);

        if (optionalMascotas.isPresent()) {
            try {
                mascotasRepository.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/listaMascotas";
    }

    //Lugares
    @GetMapping("/listaLugares")
    public String listarLugares(Model model){
        List<Lugares> listaLugares = lugaresRepository.findAll();
        model.addAttribute("listaLugares", listaLugares);
        return "listaLugares";
    }
    @GetMapping("/listaLugares/crear")
    public String crearLugar(Model model){
        Lugares lugares = new Lugares();
        model.addAttribute("lugar", lugares);
        return "crearLugar";
    }
    @PostMapping("/listaLugares/registrar")
    public String registrarLugar(Lugares lugar){
        lugaresRepository.save(lugar);
        return "redirect:/listaLugares";
    }
    @GetMapping("/listaLugares/editar/{id}")
    public String editarLugar(@PathVariable("id") int id,Model model, Lugares lugares){
        Optional<Lugares> optionalLugares = lugaresRepository.findById(id);
        model.addAttribute("lugar",optionalLugares);
        return "editLugar";
    }
    @GetMapping("/listaLugares/borrar")
    public String borrarLugar(Model model, @RequestParam("id") int id){
        Optional<Lugares> optionalLugares = lugaresRepository.findById(id);

        if (optionalLugares.isPresent()) {
            try {
                lugaresRepository.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/listaLugares";
    }
}
