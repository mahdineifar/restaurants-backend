package com.example.restaurants.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "T_PLACE")
public class Place implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLA_ID")
    private Long id;

    @Column(name = "PLA_NAME", nullable = false, length = 100)
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "PLA_DESCRIPTION", length = 250)
    @Size(max = 250)
    private String description;

    @Column(name = "PLA_ADDRESS", length = 250, nullable = false)
    @Size(min = 15, max = 250)
    private String address;

    @OneToOne
    @JoinColumn(name = "PLA_CATEGORY_ID", nullable = false)
    private Category category;

}
