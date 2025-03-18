package com.lhcamposs.controller;

import com.lhcamposs.entity.Autor;
import com.lhcamposs.service.AutorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/autores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AutorController {

    private final AutorService autorService = new AutorService();

    @GET
    public Response getAll() {
        List<Autor> autores = autorService.buscarTodos();
        return Response.ok(autores).build();
    }

    @POST
    public Response create(Autor autor) {
        Autor novoAutor = autorService.salvar(autor);
        return Response.status(Response.Status.CREATED).entity(novoAutor).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Autor autor = autorService.buscarPorId(id);
        return Response.ok(autor).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Autor autor) {
        Autor autorAtualizado = autorService.atualizar(id, autor);
        return Response.ok(autorAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        autorService.deletar(id);
        return Response.noContent().build();
    }
}