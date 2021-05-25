package ru.strelchm.skb.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class RestDto {
    private Integer code;
    private String name;
    private String phone;
}
