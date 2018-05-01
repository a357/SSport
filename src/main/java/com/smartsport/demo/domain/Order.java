package com.smartsport.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@EqualsAndHashCode
@Document
public class Order {
    @Id
    @ApiModelProperty(notes = "The database generated product ID")
    private String id;
    @Indexed(unique=true)
    @ApiModelProperty(notes = "Manager Name")
    private String managerName;
    @ApiModelProperty(notes = "Organization")
    private String organization;
    @ApiModelProperty(notes = "Number of athlets")
    private Integer numberOfAthlets;
    @ApiModelProperty(notes = "Requirements")
    private Requirements requirements;
    @ApiModelProperty(notes = "Country")
    private String country;
    @ApiModelProperty(notes = "Status")
    private String status;
}
