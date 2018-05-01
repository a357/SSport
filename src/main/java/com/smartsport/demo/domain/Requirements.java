package com.smartsport.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class Requirements {
   @ApiModelProperty(notes = "Requirements trainings")
   public boolean trainings;
   @ApiModelProperty(notes = "Requirements sauna")
   public boolean sauna;
   @ApiModelProperty(notes = "Requirements gym")
   public boolean gym;
   @ApiModelProperty(notes = "Requirements number of trainings session")
   public int numberOfTrainingsSession;
}
