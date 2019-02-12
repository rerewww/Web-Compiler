package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by son on 2019-01-08.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultCompile {
    private boolean success;
    private String message;
    private List<Boolean> result;
}
