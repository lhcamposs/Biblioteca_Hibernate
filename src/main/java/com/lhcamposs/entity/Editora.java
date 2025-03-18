package com.lhcamposs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "editora")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "nome", nullable = false, unique = true, length = 200)
    private String nome;

    @OneToMany(mappedBy = "editora")
    private List<Livro> livros = new ArrayList<>();
}
