package cme;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class YinglongYuTestTask3 {


    /**
     * RateTestcases
     */
    @Test
    @DisplayName("RateTestCase1")
    void rateTestCase1()  {
        //set up data set
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        // create valid period for normal period
        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        // create valid period for reduced period
        Period reducedPeriod = new Period(10, 12);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);
        //create valid rate object
        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        // verify the rate object
        assertNotNull(rate);

    }





    @Test
    @DisplayName("RateTestCase2")
    void rateTestCase2()  {
        //set up data set
        CarParkKind kind = null;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(1.6);
        //create valid normal period
        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        //create valid reduced period
        Period reducedPeriod1 = new Period(10, 12);
        Period reducedPeriod2 = new Period(16, 21);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        //throw IllegalArgument
        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }





    @Test
    @DisplayName("RateTestCase3")
    void rateTestCase3()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(2.4);
        BigDecimal reducedRate = new BigDecimal(1.2);

        Period normalPeriod = new Period(8,9);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod);


        Period reducedPeriod1 = new Period(9, 11);
        Period reducedPeriod2 = new Period(12, 15);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);

    }


    @Test
    @DisplayName("RateTestCase4")
    void rateTestCase4()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(-1);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(15,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9, 11);
        Period reducedPeriod2 = new Period(10, 15);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);



        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }


    @Test
    @DisplayName("RateTestCase5")
    void rateTestCase5()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(2);


        Period reducedPeriod = new Period(8, 9);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);


        Period normalPeriod1 = new Period(9, 12);
        Period normalPeriod2 = new Period(10, 16);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

    @Test
    @DisplayName("RateTestCase6")
    void rateTestCase6()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(1.2);


        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(10, 16);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Period normalPeriod1 = new Period(8,9);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });


    }





    @Test
    @DisplayName("RateTestCase7")
    void rateTestCase7()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(1.6);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13, 15);
        Period normalPeriod3 = new Period(16, 20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);

        Period reducedPeriod1 = new Period(10,11);
        Period reducedPeriod2 = new Period(12,13);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });


    }




    @Test
    @DisplayName("RateTestCase8")
    void rateTestCase8()  {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = null;


        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13, 15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);


        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(12,15);
        Period reducedPeriod3 = new Period(16,20);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });


    }




    @Test
    @DisplayName("RateTestCase9")
    void rateTestCase9()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(-2.1);
        BigDecimal reducedRate = new BigDecimal(2.1);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13, 15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);


        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(12,15);
        Period reducedPeriod3 = new Period(16,20);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });


    }



    @Test
    @DisplayName("RateTestCase10")
    void rateTestCase10()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(1.5);


        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        Period normalPeriod3 = new Period(16,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);


        Period reducedPeriod1 = new Period(10,11);
        Period reducedPeriod2 = new Period(12,13);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

    @Test
    @DisplayName("RateTestCase11")
    void rateTestCase11()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(-2);


        Period normalPeriod1 = new Period(8,12);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);



        Period reducedPeriod1 = new Period(12,15);
        Period reducedPeriod2 = new Period(16,20);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }



    @Test
    @DisplayName("RateTestCase12")
    void rateTestCase12()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(0);


        Period normalPeriod1 = new Period(8,12);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);



        Period reducedPeriod1 = new Period(12,15);
        Period reducedPeriod2 = new Period(16,20);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);


        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);

    }


    @Test
    @DisplayName("RateTestCase13")
    void rateTestCase13()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(4);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(12,15);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }



    @Test
    @DisplayName("RateTestCase14")
    void rateTestCase14()  {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1.8);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(15,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(12,15);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);

    }


    @Test
    @DisplayName("RateTestCase15")
    void rateTestCase15()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(1);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,8);
        Period reducedPeriod2 = new Period(10,12);
        Period reducedPeriod3 = new Period(16,21);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);

    }



//    @Test
//    @DisplayName("RateTestCase16_invalid normal periods(end Hour over 24 hours)")
//    void testRateConstructor_16_withInValidNormalPeriod()  {
//        CarParkKind kind = CarParkKind.MANAGEMENT;
//        BigDecimal normalRate = new BigDecimal(7);
//        BigDecimal reducedRate = new BigDecimal(3);
//
//        Period normalPeriod1 = new Period(8,10);
//        Period normalPeriod2 = new Period(13,25);
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(normalPeriod1);
//        normalPeriods.add(normalPeriod2);
//
//        Period reducedPeriod1 = new Period(10,12);
//        Period reducedPeriod2 = new Period(16,21);
//
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(reducedPeriod1);
//        reducedPeriods.add(reducedPeriod2);
//
//        assertThrows(IllegalArgumentException.class,()->{
//            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
//        });
//
//    }



    @Test
    @DisplayName("RateTestCase16")
    void rateTestCase16()  {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(1);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,8);
        Period reducedPeriod2 = new Period(10,12);
        Period reducedPeriod3 = new Period(16,21);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }
//    @Test
//    @DisplayName("RateTestCase17_invalid normal periods(end Hour over 24 hours)")
//    void testRateConstructor_17_withInValidNormalPeriod()  {
//        CarParkKind kind = CarParkKind.MANAGEMENT;
//        BigDecimal normalRate = new BigDecimal(5);
//        BigDecimal reducedRate = new BigDecimal(2.1);
//
//        Period normalPeriod1 = new Period(27,10);
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(normalPeriod1);
//
//        Period reducedPeriod1 = new Period(10,12);
//        Period reducedPeriod2 = new Period(16,21);
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(reducedPeriod1);
//        reducedPeriods.add(reducedPeriod2);
//
//        assertThrows(IllegalArgumentException.class,()->{
//            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
//        });
//
//    }


    @Test
    @DisplayName("RateTestCase17")
    void rateTestCase17()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate =  new BigDecimal(2.1);
        BigDecimal reducedRate =  new BigDecimal(1.1);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(11,15);
        Period normalPeriod3 = new Period(16,20);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);


        ArrayList<Period> reducedPeriods = null;

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

//    @Test
//    @DisplayName("RateTestCase18_invalid reduced periods(end hour over 24 hours)")
//    void testRateConstructor_18_withInValidReducedPeriod()  {
//        CarParkKind kind = CarParkKind.STUDENT;
//        BigDecimal normalRate = new BigDecimal(4);
//        BigDecimal reducedRate = new BigDecimal(2);
//
//        Period normalPeriod1 = new Period(8,10);
//        Period normalPeriod2 = new Period(13,15);
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(normalPeriod1);
//        normalPeriods.add(normalPeriod2);
//
//        Period reducedPeriod1 = new Period(7,8);
//        Period reducedPeriod2 = new Period(10,12);
//        Period reducedPeriod3 = new Period(16,30);
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(reducedPeriod1);
//        reducedPeriods.add(reducedPeriod2);
//        reducedPeriods.add(reducedPeriod3);
//
//        assertThrows(IllegalArgumentException.class,()->{
//            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
//        });
//
//    }

    @Test
    @DisplayName("RateTestCase18")
    void rateTestCase18()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate =  new BigDecimal(3.2);
        BigDecimal reducedRate =  new BigDecimal(2.2);

        Period normalPeriod1 = new Period(7,8);
        Period normalPeriod2 = new Period(9,20);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(normalPeriod1);
        reducedPeriods.add(normalPeriod2);

        ArrayList<Period>  normalPeriods = null;

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

//    @Test
//    @DisplayName("RateTestCase19_invalid reduced periods(start hour over 24 hours)")
//    void testRateConstructor_19_withInValidReducedPeriod()  {
//        CarParkKind kind = CarParkKind.STUDENT;
//        BigDecimal normalRate = new BigDecimal(6.1);
//        BigDecimal reducedRate = new BigDecimal(2.3);
//
//        Period normalPeriod1 = new Period(8,10);
//        Period normalPeriod2 = new Period(13,15);
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(normalPeriod1);
//        normalPeriods.add(normalPeriod2);
//
//        Period reducedPeriod1 = new Period(31,8);
//        Period reducedPeriod2 = new Period(10,12);
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(reducedPeriod1);
//        reducedPeriods.add(reducedPeriod2);
//
//        assertThrows(IllegalArgumentException.class,()->{
//            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
//        });
//
//    }



    @Test
    @DisplayName("RateTestCase19")
    void rateTestCase19()  {
        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = BigDecimal.valueOf(Double.MIN_VALUE);
        BigDecimal reducedRate = new BigDecimal(2);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(15,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(12,15);


        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);


        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }
//    @Test
//    @DisplayName("RateTestCase20_invalid (normal rate equal reduce rate)")
//    void testRateConstructor_20_withInValidNormalRateAndReduceRate()  {
//        CarParkKind kind = CarParkKind.VISITOR;
//        BigDecimal normalRate = new BigDecimal(1);
//        BigDecimal reducedRate = new BigDecimal(1);
//
//        Period normalPeriod1 = new Period(8,10);
//        Period normalPeriod2 = new Period(13,15);
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(normalPeriod1);
//        normalPeriods.add(normalPeriod2);
//
//        Period reducedPeriod1 = new Period(7,8);
//        Period reducedPeriod2 = new Period(10,12);
//        Period reducedPeriod3 = new Period(16,21);
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(reducedPeriod1);
//        reducedPeriods.add(reducedPeriod2);
//        reducedPeriods.add(reducedPeriod3);
//
//        assertThrows(IllegalArgumentException.class,()->{
//            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
//        });
//     }



    @Test
    @DisplayName("RateTestCase20")
    void rateTestCase20()  {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = BigDecimal.valueOf(Double.MIN_VALUE);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,8);
        Period reducedPeriod2 = new Period(10,12);
        Period reducedPeriod3 = new Period(16,21);


        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);


        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);

    }



//    @Test
//    @DisplayName("RateTestCase21_invalid normal periods (start hour equal end hour)")
//    void testRateConstructor_21_withInValidNormalPeriods()  {
//        CarParkKind kind = CarParkKind.STUDENT;
//        BigDecimal normalRate = new BigDecimal(5);
//        BigDecimal reducedRate = new BigDecimal(2.3);
//
//        Period normalPeriod1 = new Period(8,8);
//
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(normalPeriod1);
//
//        Period reducedPeriod1 = new Period(7,8);
//        Period reducedPeriod2 = new Period(9,20);
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(reducedPeriod1);
//        reducedPeriods.add(reducedPeriod2);
//
//        assertThrows(IllegalArgumentException.class,()->{
//            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
//        });
//
//    }
    @Test
    @DisplayName("RateTestCase21")
    void rateTestCase21()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = BigDecimal.valueOf(Double.MAX_VALUE);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(15,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod = new Period(10,14);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }




//    @Test
//    @DisplayName("RateTestCase22_invalid reduced periods (start hour equal end hour")
//    void testRateConstructor_22_withInValidReducedPeriods()  {
//        CarParkKind kind = CarParkKind.STAFF;
//        BigDecimal normalRate = new BigDecimal(3);
//        BigDecimal reducedRate = new BigDecimal(2.2);
//
//        Period normalPeriod1 = new Period(8,10);
//        Period normalPeriod2 = new Period(13,15);
//
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(normalPeriod1);
//        normalPeriods.add(normalPeriod2);
//
//        Period reducedPeriod1 = new Period(7,8);
//        Period reducedPeriod2 = new Period(9,12);
//        Period reducedPeriod3 = new Period(16,16);
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(reducedPeriod1);
//        reducedPeriods.add(reducedPeriod2);
//        reducedPeriods.add(reducedPeriod3);
//
//        assertThrows(IllegalArgumentException.class,()->{
//            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
//        });
//
//    }
    @Test
    @DisplayName("RateTestCase22")
    void rateTestCase22()  {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = BigDecimal.valueOf(Double.MAX_VALUE);
        BigDecimal reducedRate = new BigDecimal(4);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,12);
        Period reducedPeriod2 = new Period(16,20);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);

    }


    @Test
    @DisplayName("RateTestCase23")
    void rateTestCase23()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(3.2);
        BigDecimal reducedRate = new BigDecimal(2.1);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(12,20);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 =  new Period(13,15);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }
    @Test
    @DisplayName("RateTestCase24")
    void rateTestCase24()  {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(1.5);

        Period normalPeriod1 = new Period(8,14);
        Period normalPeriod2 = new Period(14,20);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,13);
        Period reducedPeriod2 = new Period(15,21);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);


        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }
    @Test
    @DisplayName("RateTestCase25")
    void rateTestCase25()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(1.6);

        Period normalPeriod = new Period(17,20);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod);

        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(10,15);
        Period reducedPeriod3 = new Period(13,16);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

    @Test
    @DisplayName("RateTestCase26")
    void rateTestCase26()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1.2);

        Period normalPeriod1 = new Period(11,14);
        Period normalPeriod2 = new Period(13,16);
        Period normalPeriod3 = new Period(15,20);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);

        Period reducedPeriod = new Period(7,10);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);


        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }





    /**
     * CalculateTestcases
     */
    @Test
    @DisplayName("CalculateTestCase1")
    void calculateTestCase1()  {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(1.6);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(10,12);
        Period reducedPeriod2 = new Period(16,21);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Period periodStay = new Period(16,18);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        BigDecimal actualValue = rate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(3.2).setScale(2, RoundingMode.HALF_UP);
       assertEquals(expectedValue,actualValue);

    }



    @Test
    @DisplayName("CalculateTestCase2")
    void calculateTestCase2()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(3.7);
        BigDecimal reducedRate = new BigDecimal(2);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(12,15);
        Period normalPeriod3 = new Period(15,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);

        Period reducedPeriod = new Period(9,11);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);

        Period periodStay = new Period(9,10);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        BigDecimal actualValue = rate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(2).setScale(2, RoundingMode.HALF_UP);

        assertEquals(expectedValue,actualValue);
        //assertEquals(2, expectedValue.compareTo(actualValue));

    }


    @Test
    @DisplayName("CalculateTestCase3")
    void calculateTestCase3()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(6.3);
        BigDecimal reducedRate = new BigDecimal(3.1);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(15,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(9,11);
        Period reducedPeriod2 = new Period(12,15);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Period periodStay = new Period(15,17);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        BigDecimal actualValue = rate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(12.6).setScale(2, RoundingMode.HALF_UP);

        assertEquals(expectedValue,actualValue);
        //assertEquals(12.6, expectedValue.compareTo(actualValue));

    }



    @Test
    @DisplayName("CalculateTestCase4")
    void calculateTestCase4()  {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(1.6);

        Period normalPeriod1 = new Period(8,9);
        Period normalPeriod2 = new Period(15,20);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod = new Period(9,13);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);

        Period periodStay = new Period(16,18);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        BigDecimal actualValue = rate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(4.2).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue,actualValue);
        //assertEquals(4.2, expectedValue.compareTo(actualValue));
    }







    @Test
    @DisplayName("CalculateTestCase5")
    void calculateTestCase5()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4.2);
        BigDecimal reducedRate = new BigDecimal(3);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(10,12);
        Period reducedPeriod2 = new Period(16,21);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Period periodStay = new Period(16,20);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        BigDecimal actualValue = rate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(12).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue,actualValue);
        //assertEquals(12, expectedValue.compareTo(actualValue));
    }



    @Test
    @DisplayName("CalculateTestCase6")
    void calculateTestCase6()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(1.6);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(10,12);
        Period reducedPeriod2 = new Period(16,21);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Period periodStay = new Period(9,10);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        BigDecimal actualValue = rate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(2.1).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue,actualValue);
        //assertEquals(2.1, expectedValue.compareTo(actualValue));
    }



    @Test
    @DisplayName("CalculateTestCase7")
    void calculateTestCase7()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(1);
        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        Period reducedPeriod = new Period(10,12);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);


        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        Period periodStay = null;

        assertThrows(NullPointerException.class,()-> rate.calculate(periodStay));
    }


    @Test
    public void testVisitorReductionLessTen() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate visitorRate = new Rate(new BigDecimal(2), new BigDecimal(1), CarParkKind.VISITOR, reducedPeriods, normalPeriods);
        Period normalPeriod = new Period(8, 14);
        Period reducedPeriod = new Period(14, 24);

        normalPeriods.add(normalPeriod);
        reducedPeriods.add(reducedPeriod);

        Period periodStay = new Period(9, 10);

        BigDecimal actualValue = visitorRate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(2).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue, actualValue);

    }


    @Test
    public void testVisitorReductionAboveTen() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate visitorRate = new Rate(new BigDecimal(10.0), new BigDecimal(5.0), CarParkKind.VISITOR, reducedPeriods, normalPeriods);
        Period normalPeriod = new Period(8, 14);
        Period reducedPeriod = new Period(14, 24);

        normalPeriods.add(normalPeriod);
        reducedPeriods.add(reducedPeriod);

        Period periodStay = new Period(15, 24);

        BigDecimal actualValue = visitorRate.calculate(periodStay);
        BigDecimal expectedValue = BigDecimal.valueOf(17.5).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue, actualValue);
    }




}

