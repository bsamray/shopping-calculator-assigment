package com.assignment.shopping.service;

import lombok.extern.slf4j.Slf4j;

public class LogOutput implements Output {

    @Override
    public void output(String info) {
        System.out.println(info);
    }

}
