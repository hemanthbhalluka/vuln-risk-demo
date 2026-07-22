package com.demo.app.entity;
import jakarta.persistence.*;
@Entity @Table(name="payments") public class Payment { @Id @GeneratedValue private Long id; private String name; }