package com.jeRso.projetopoo.controller;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class teste {

    @ShellMethod("Soma de dois numeros.")
    public int add(int a, int b) {
        return a + b;
    }
}
