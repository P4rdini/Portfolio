package com.Projeto.Portfolio.Resources;

public enum Skill {

    JAVA("Java"),
    JAVADESKTOP("Java Desktop"),
    THYMELEAF("Thymeleaf"),
    SPRINGBOOT("Spring Boot"),
    SPRINGMVC("Spring MVC"),
    SPRINGJPA("String JPA"),
    SPRINGSECURITY("Spring Security"),

    SQL("SQL"),
    POSTGRESQL("PostGreSQL"),


    API("API"),
    RESTFULL("RestFull"),


    HTML("HTML"),
    BOOTSTRAP("BootStrap"),
    JAVASCRIPT("JavaScript");


    private final String nome;

    Skill(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
