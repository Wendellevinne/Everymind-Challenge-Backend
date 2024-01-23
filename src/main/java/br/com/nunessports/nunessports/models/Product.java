package br.com.nunessports.nunessports.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tbl_prd")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    private String code;

    private String name;

    private String description;

    private BigDecimal price;

}
