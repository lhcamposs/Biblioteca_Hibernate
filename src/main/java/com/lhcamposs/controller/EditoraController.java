package com.lhcamposs.controller;

import com.lhcamposs.entity.Editora;
import com.lhcamposs.service.EditoraService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/editoras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EditoraController {

    private final EditoraService editoraService = new EditoraService();

    @GET
    public Response getAll() {
        List<Editora> editoras = editoraService.buscarTodos();
        return Response.ok(editoras).build();
    }

    @POST
    public Response create(Editora editora) {
        Editora novaEditora = editoraService.salvar(editora);
        return Response.status(Response.Status.CREATED).entity(novaEditora).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Editora editora = editoraService.buscarPorId(id);
        return Response.ok(editora).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Editora editora) {
        Editora editoraAtualizada = editoraService.atualizar(id, editora);
        return Response.ok(editoraAtualizada).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        editoraService.deletar(id);
        return Response.noContent().build();
    }
}