package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import service.RentsCountService;

public class RentsCountServiceTest {


    @Test
    public void countRentedCarsTest() {
        RentsCountService rentsCountService = new RentsCountService();

        int count = rentsCountService.countRentedCars();

        assertEquals(2, count);
    }
}
