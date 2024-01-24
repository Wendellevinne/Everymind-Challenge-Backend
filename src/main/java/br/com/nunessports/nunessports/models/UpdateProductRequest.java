package br.com.nunessports.nunessports.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    private String code;
    private String name;
    private String description;
    private BigDecimal price;
}
