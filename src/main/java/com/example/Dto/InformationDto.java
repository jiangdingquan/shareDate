package com.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author shRstart
 * @date 2020/4/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "information")
public class InformationDto  implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String dateTime;
    private Boolean  datavalue;


}
