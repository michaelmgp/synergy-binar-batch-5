package com.example.challenge_3.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
class RumusImplTest {
    RumusImpl rumus = new RumusImpl();
    private List<Integer> list ;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5, 7, 8, 9, 9, 9, 10));

    }

    @AfterEach
    void tearDown(){
        list.clear();
    }

    @Test
    public void shouldReturnMean(){
        Assert.assertEquals(6.0, Double.parseDouble(rumus.mean(list)), 0.1);
        Assert.assertNotEquals(10.0, Double.parseDouble(rumus.mean(list)), 0.1);
    }


    @Test
    void median() {
        Assert.assertEquals(6.0, Double.parseDouble(rumus.median(list)), 0.1);
        Assert.assertNotEquals(7.0, Double.parseDouble(rumus.median(list)), 0.1);
    }

    @Test
    void modus() {
        Assert.assertEquals(9.0, Double.parseDouble(rumus.modus(list)), 0.1);
        Assert.assertNotEquals(7.0, Double.parseDouble(rumus.median(list)), 0.1);
    }

    @Test
    void kelompokData() {
    }
}