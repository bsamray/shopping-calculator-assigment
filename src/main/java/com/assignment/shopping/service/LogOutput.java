package com.assignment.shopping.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogOutput implements Output {

    /**
     * Logs discount information
     * @param info Discount information
     */
    @Override
    public void output(String info) {
        log.info(info);
    }

}
