package com.capgemini.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "t_vehicle")
public class VehicelBE {

    @Id
    private String vin;

    private String color;

    private int kw;
}
