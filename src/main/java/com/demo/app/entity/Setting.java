package com.demo.app.entity;
import jakarta.persistence.*;
@Entity @Table(name="settings") public class Setting { @Id @GeneratedValue private Long id; private String name; }