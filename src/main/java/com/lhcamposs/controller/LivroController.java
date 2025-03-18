package com.lhcamposs.controller;

import com.lhcamposs.entity.Livro;
import com.lhcamposs.service.LivroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LivroController {

    private final LivroService livroService = new LivroService();

    @GET
    public Response getAll() {
        List<Livro> books = livroService.buscarTodos();
        return Response.ok(books).build();
    }

    @POST
    public Response create(Livro livro) {
        Livro book = livroService.salvar(livro);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Livro book = livroService.buscarPorId(id);
        return Response.ok(book).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Livro livro) {
        Livro book = livroService.atualizarLivro(id, livro);
        return Response.ok(book).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        livroService.deletar(id);
        return Response.noContent().build();
    }
}