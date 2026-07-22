package com.demo.app.entity;
import jakarta.persistence.*;
@Entity @Table(name="accounts") public class Account { @Id @GeneratedValue private Long id; private String name; }