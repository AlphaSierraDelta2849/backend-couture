package com.mbi.couture.entity;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Mesure")
public class Mesure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float tete;    
    private Float coup;
    private Float epaule;
    private Float lBras;
    private Float poitrine;
    private Float hanches;
    private Float lCorps;
    private Float cuisse;
    private Float genou;
    private Float mollet;
    private Float cheville;
    private Float biceps;
    private Float coude;
    private Float avantBras;
    private Float poignetCoude;
    private Float entreJambe;
    private Float coutureExt;
    private Float hToal;
    private Float dessousPoit;
    private Float cretesIliaque;
    private Float LDos;
    // @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "client_id")
    private Client client;
}
