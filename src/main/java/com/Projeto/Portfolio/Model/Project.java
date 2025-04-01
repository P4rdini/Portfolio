package com.Projeto.Portfolio.Model;

import com.Projeto.Portfolio.Resources.Skill;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String link;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "project_id")
    private List<Imagem> listImagem = new ArrayList<>();
    private List<Skill> listSkill = new ArrayList<>();


    public Project(String titulo, String descricao, String link, List<Imagem> listImagem) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.listImagem = listImagem;
    }

    public List<Skill> getListSkill() {
        return listSkill;
    }

    public void setListSkill(List<Skill> listSkill) {
        this.listSkill = listSkill;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Imagem> getListImagem() {
        return listImagem;
    }

    public void setListImagem(List<Imagem> listImagem) {
        this.listImagem = listImagem;
    }


}
