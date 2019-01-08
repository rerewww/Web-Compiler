package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by son on 2019-01-08.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultCompile {
    private boolean success;
    private String message;
    private String result;
}
