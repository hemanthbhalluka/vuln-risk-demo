package com.demo.app.entity;
import jakarta.persistence.*;
@Entity @Table(name="profiles") public class Profile { @Id @GeneratedValue private Long id; private String name; }