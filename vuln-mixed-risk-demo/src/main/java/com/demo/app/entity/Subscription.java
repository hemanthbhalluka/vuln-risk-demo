package com.demo.app.entity;
import jakarta.persistence.*;
@Entity @Table(name="subscriptions") public class Subscription { @Id @GeneratedValue private Long id; private String name; }