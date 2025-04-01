package com.Projeto.Portfolio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Imagem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String tipo;
        private byte[] dados;
        private String dadosbase64;

        public String getDadosbase64() {
                return dadosbase64;
        }

        public void setDadosbase64(String dadosbase64) {
                this.dadosbase64 = dadosbase64;
        }

        public Imagem(String nome, String tipo, byte[] dados) {
                this.nome = nome;
                this.tipo = tipo;
                this.dados = dados;
        }

        public Imagem() {
        }

        public byte[] getImageBytes(String caminhoDaImagem) throws IOException {
                Path path = Paths.get(caminhoDaImagem);
                return Files.readAllBytes(path); // Retorna byte[]
        }

        public Long getId() {
                return id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public byte[] getDados() {
                return dados;
        }

        public void setDados(byte[] dados) {
                this.dados = dados;
        }
}
