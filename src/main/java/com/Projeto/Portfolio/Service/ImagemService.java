/*package com.Projeto.Portfolio.Service;

import com.Projeto.Portfolio.Model.Imagem;
import com.Projeto.Portfolio.Repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {
    @Autowired
    private ImagemRepository imagemRepository;

    public Imagem save(Imagem imagem){
        return imagemRepository.save(imagem);
    }

    public List<Imagem> listImagem(){
        return imagemRepository.findAll();
    }

    public Optional<Imagem> findImagem(Long id){
        return imagemRepository.findById(id);
    }
}*/
