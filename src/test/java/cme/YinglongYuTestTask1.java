package cme;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class YinglongYuTestTask1 {

    /**
     * RateTestcase #1
     * CarParkKind is STAFF
     * BigDecimal NormalRate = 5
     * BigDecimal ReducedRate = 2
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(10,12)]
     * Partition: test valid CarParkKind
     * Expected to rate object
     */

    @Test
    @DisplayName("RateTestCase1_valid CarParkKind")
    void rateTestConstructor_1_withValidCarParkKind()  {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod = new Period(10, 12);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);

    }



    /**
     * RateTestcase #2
     * CarParkKind is Null
     * BigDecimal NormalRate = 5
     * BigDecimal ReducedRate = 2
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(10,12),(16,21)]
     * Partition: test invalid CarParkKind
     * Expected to throw IllegalAccessException
     */

    @Test
    @DisplayName("RateTestCase2_invalid CarParkKind")
    void rateTestConstructor_2_withInValidCarParkKind()  {
        CarParkKind kind = null;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(1.6);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod1);

        Period reducedPeriod1 = new Period(10, 12);
        Period reducedPeriod2 = new Period(16, 21);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });
    }




    /**
     * RateTestcase #3
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 2.4
     * BigDecimal ReducedRate = 1.2
     * Normal Periods = [(8,9)]
     * Reduced Periods = [(9,11),(12,15)]
     * Partition: valid reduced period
     * Expected to rate object
     */


    @Test
    @DisplayName("RateTestCase3_valid reduced period")
    void rateTestConstructor_3_withValidReducedPeriod()  {
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

    /**
     * RateTestcase #4
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = 1.6
     * Normal Periods = [(8,9),(15,20)]
     * Reduced Periods = [(9,11),(10,15)]
     * Partition: invalid reduced period(overlap)
     * Expected to throw IllegalAccessException
     */
    @Test
    @DisplayName("RateTestCase4_invalid reduced period")
    void rateTestConstructor_4_withInValidReducedPeriod()  {
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


    /**
     * RateTestcase #5
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 6
     * BigDecimal ReducedRate = 2
     * Normal Periods = [(8,9),(15,20)]
     * Reduced Periods = [(9,11),(12,15),(21,22)]
     * Partition: valid normal period
     * Expected to Rate Object
     */
    @Test
    @DisplayName("RateTestCase5_valid normal period")
    void rateTestConstructor_5_withValidNormalPeriod()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(2);


        Period reducedPeriod1 = new Period(8, 9);
        Period reducedPeriod2 = new Period(15, 20);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        Period normalPeriod1 = new Period(9, 11);
        Period normalPeriod2 = new Period(12, 15);
        Period normalPeriod3 = new Period(21, 22);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);

        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        assertNotNull(rate);


    }



    /**
     * RateTestcase #6
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = 1.2
     * Normal Periods = [(9,11),(10,16)]
     * Reduced Periods = [(8,9)]
     * Partition: invalid normal period (overlap)
     * Expected to IllegalArgumentException
     */


    @Test
    @DisplayName("RateTestCase6_invalid normal period_overlap")
    void rateTestConstructor_6_withInValidNormalPeriod()  {
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




    /**
     * RateTestcase #7
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = null
     * BigDecimal ReducedRate = 1.6
     * Normal Periods = [(8,10),(13,15),(16,20)]
     * Reduced Periods = [(10,11),(12,13)]
     * Partition: invalid NormalRateType(null)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase7_invalid normal rate type null")
    void rateTestConstructor_7_withInValidNormalRateType()  {
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




    /**
     * RateTestcase #8
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = null
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(9,11),(12,15),(16,20)]
     * Partition: invalid ReduceRateType(null)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase8_invalid reducedRate type null")
    void testRateConstructor_8_withInValidReducedRateType()  {
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


    /**
     * RateTestcase #9
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = -1
     * BigDecimal ReducedRate = 1.6
     * Normal Periods = [(8,10),(13,15),(16,20)]
     * Reduced Periods = [(10,11),(12,13)]
     * Partition: invalid NormalRateType(negative)
     * IllegalArgumentException
     */

    @Test
    @DisplayName("RateTestCase9_invalid NormalRateType(negative)")
    void testRateConstructor_9_withInValidNormalRateTypeNegative()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
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

    /**
     * RateTestcase #9
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = -1
     * BigDecimal ReducedRate = 1.6
     * Normal Periods = [(8,10),(13,15),(16,20)]
     * Reduced Periods = [(10,11),(12,13)]
     * Partition: invalid NormalRateType(negative)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase9_invalid NormalRateType(negative)")
    void tesRateConstructor_9_withInValidNormalRateTypeNegative()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(1.6);


        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13, 15);
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



    /**
     * RateTestcase #10
     * CarParkKind is VISITOR
     * BigDecimal NormalRate = 0
     * BigDecimal ReducedRate = 1.5
     * Normal Periods = [(8,10),(13,15),(16,20)]
     * Reduced Periods = [(10,11),(12,13)]
     * Partition: invalid NormalRateType(zero)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase10_invalid NormalRateType(zero)")
    void testRateConstructor_10_withInValidNormalRateTypeZero()  {
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

    /**
     * RateTestcase #11
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = -2
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(9,11),(12,15),(16,20)]
     * Partition: invalid ReduceRateType(negative)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase11_invalid ReduceRateType(negative)")
    void testRateConstructor_11_withInValidReduceRateTypeNegative()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(-2);


        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
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


    /**
     * RateTestcase #12
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = 0
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(9,11),(12,15),(16,20)]
     * Partition: invalid ReduceRateType(zero)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase12_invalid ReduceRateType(zero)")
    void testRateConstructor_12_withInValidReduceRateTypeZero()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(2.1);
        BigDecimal reducedRate = new BigDecimal(0);


        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
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

    /**
     * RateTestcase #13
     * CarParkKind is STAFF
     * BigDecimal NormalRate = 3
     * BigDecimal ReducedRate = 4
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(9,11),(12,15)]
     * Partition: (invalid)reduced rate greater than normal rate
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase13_(invalid)reduced rate greater than normal rate")
    void testRateConstructor_13_withInValidReduceRateType()  {
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


    /**
     * RateTestcase #14
     * CarParkKind is VISITOR
     * BigDecimal NormalRate = 3
     * BigDecimal ReducedRate = 1.8
     * Normal Periods = [(8,9),(15,20)]
     * Reduced Periods = [(9,11),(12,15)]
     * Partition: valid NormalRateType
     * Expected to rate object
     */
    @Test
    @DisplayName("RateTestCase14_valid NormalRateType")
    void testRateConstructor_14_withValidNormalRateType()  {
        CarParkKind kind = CarParkKind.STUDENT;
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

    /**
     * RateTestcase #15
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 5
     * BigDecimal ReducedRate = 1
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(7.8),(10,12),(16,21)]
     * Partition: valid ReduceRateType
     * Expected to rate object
     */
    @Test
    @DisplayName("RateTestCase15_valid ReduceRateType")
    void testRateConstructor_15_withValidReduceRateType()  {
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





    /**
     * RateTestcase #16
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = 7
     * BigDecimal ReducedRate = 3
     * Normal Periods = [(8,10),(13,25)]
     * Reduced Periods = [(10,12),(16,21)]
     * Partition: invalid normal periods(end Hour over 24 hours)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase16_invalid normal periods(end Hour over 24 hours)")
    void testRateConstructor_16_withInValidNormalPeriod()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(3);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,25);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(10,12);
        Period reducedPeriod2 = new Period(16,21);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }


    /**
     * RateTestcase #17
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = 5
     * BigDecimal ReducedRate = 2.1
     * Normal Periods = [(27,10)]
     * Reduced Periods = [(10,12),(16,21)]
     * Partition: invalid normal periods(start Hour over 24 hours)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase17_invalid normal periods(end Hour over 24 hours)")
    void testRateConstructor_17_withInValidNormalPeriod()  {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2.1);

        Period normalPeriod1 = new Period(27,10);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);

        Period reducedPeriod1 = new Period(10,12);
        Period reducedPeriod2 = new Period(16,21);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }


    /**
     * RateTestcase #18
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 4
     * BigDecimal ReducedRate = 2
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(7.8),(10,12),(16,30)]
     * Partition: invalid reduced periods(end hour over 24 hours)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase18_invalid reduced periods(end hour over 24 hours)")
    void testRateConstructor_18_withInValidReducedPeriod()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,8);
        Period reducedPeriod2 = new Period(10,12);
        Period reducedPeriod3 = new Period(16,30);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

    /**
     * RateTestcase #19
     * CarParkKind is STAFF
     * BigDecimal NormalRate = 6.1
     * BigDecimal ReducedRate = 2.3
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(31.8),(10,12)]
     * Partition: invalid reduced periods(start hour over 24 hours)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase19_invalid reduced periods(start hour over 24 hours)")
    void testRateConstructor_19_withInValidReducedPeriod()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(6.1);
        BigDecimal reducedRate = new BigDecimal(2.3);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(31,8);
        Period reducedPeriod2 = new Period(10,12);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }



    /**
     * RateTestcase #20
     * CarParkKind is VISITOR
     * BigDecimal NormalRate = 1
     * BigDecimal ReducedRate = 1
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(7.8),(10,12),(16,21)]
     * Partition: invalid (normal rate equal reduce rate)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase20_invalid (normal rate equal reduce rate)")
    void testRateConstructor_20_withInValidNormalRateAndReduceRate()  {
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

    /**
     * RateTestcase #21
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 5
     * BigDecimal ReducedRate = 2.3
     * Normal Periods = [(8,8)]
     * Reduced Periods = [(7.8),(9,20)]
     * Partition: invalid normal periods (start hour equal end hour)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase21_invalid normal periods (start hour equal end hour)")
    void testRateConstructor_21_withInValidNormalPeriods()  {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2.3);

        Period normalPeriod1 = new Period(8,8);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);

        Period reducedPeriod1 = new Period(7,8);
        Period reducedPeriod2 = new Period(9,20);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

    /**
     * RateTestcase #22
     * CarParkKind is STAFF
     * BigDecimal NormalRate = 3
     * BigDecimal ReducedRate = 2.2
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(7.8),(9,12),(16,16)]
     * Partition: invalid reduced periods (start hour equal end hour)
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase22_invalid reduced periods (start hour equal end hour")
    void testRateConstructor_22_withInValidReducedPeriods()  {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(2.2);

        Period normalPeriod1 = new Period(8,10);
        Period normalPeriod2 = new Period(13,15);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);

        Period reducedPeriod1 = new Period(7,8);
        Period reducedPeriod2 = new Period(9,12);
        Period reducedPeriod3 = new Period(16,16);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }

    /**
     * RateTestcase #23
     * CarParkKind is null
     * BigDecimal NormalRate = null
     * BigDecimal ReducedRate = null
     * Normal Periods = null
     * Reduced Periods = null
     * Partition: invalid parameters all null
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("RateTestCase23_invalid parameters all null")
    void testRateConstructor_23_withInValidParameters()  {
        CarParkKind kind = null;
        BigDecimal normalRate = null;
        BigDecimal reducedRate = null;

        Period normalPeriod = null;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(normalPeriod);


        Period reducedPeriod = null;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(reducedPeriod);


        assertThrows(IllegalArgumentException.class,()->{
            Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        });

    }




    /**
     * CalculateTestcase #1
     * CarParkKind is STAFF
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = 1.6
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(10,12),(16,21)]
     * Period Stay = [(16,18)]
     * Partition: valid CarParkKind-staff
     * Expected to 3.2
     */
    @Test
    @DisplayName("CalculateTestCase1_valid CarParkKind-staff")
    void testCalculateConstructor_1_withValidCarParkKind()  {
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
        BigDecimal expectedValue = BigDecimal.valueOf(3.2);
        assertEquals(expectedValue,actualValue);
    }


    /**
     * CalculateTestcase #2
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 3.7
     * BigDecimal ReducedRate = 2
     * Normal Periods = [(8,9),(12,15),(15,20)]
     * Reduced Periods = [(9,11)]
     * Period Stay = [(9,10)]
     * Partition: valid reduced period
     * Expected to 2
     */


    @Test
    @DisplayName("CalculateTestCase2_valid reduced period")
    void testCalculateConstructor_2_withValidReducedPeriod()  {
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
        BigDecimal expectedValue = BigDecimal.valueOf(2);

        assertEquals(expectedValue,actualValue);


    }

    /**
     * CalculateTestcase #3
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 6.3
     * BigDecimal ReducedRate = 3.1
     * Normal Periods = [(8,9),(15,20)]
     * Reduced Periods = [(9,11),(12,15)]
     * Period Stay = [(15,17)]
     * Partition: valid normal period
     * Expected to 12.6
     */


    @Test
    @DisplayName("CalculateTestCase3_valid normal period")
    void testCalculateConstructor_3_withValidNormalPeriod()  {
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
        BigDecimal expectedValue = BigDecimal.valueOf(12.6);

        assertEquals(expectedValue,actualValue);


    }
    /**
     * CalculateTestcase #4
     * CarParkKind is STAFF
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = 1.6
     * Normal Periods = [(8,9),(15,20)]
     * Reduced Periods = [(9,13)]
     * Period Stay = [(16,18)]
     * Partition: valid NormalRateType
     * Expected to 4.2
     */


    @Test
    @DisplayName("CalculateTestCase4_valid normal Rate type")
    void testCalculateConstructor_4_withValidNormalRateType()  {
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
        BigDecimal expectedValue = BigDecimal.valueOf(4.2);
        assertEquals(expectedValue,actualValue);
    }




    /**
     * CalculateTestcase #5
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 4.2
     * BigDecimal ReducedRate = 3
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(10,12),(16,21)]
     * Period Stay = [(16,20)]
     * Partition: valid ReduceRateType
     * Expected to 12
     */


    @Test
    @DisplayName("CalculateTestCase5_valid ReduceRateType")
    void testCalculateConstructor_5_withValidReducedType()  {
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
        BigDecimal expectedValue = BigDecimal.valueOf(12);
        assertEquals(expectedValue,actualValue);
    }
    /**
     * CalculateTestcase #6
     * CarParkKind is MANAGEMENT
     * BigDecimal NormalRate = 2.1
     * BigDecimal ReducedRate = 1.6
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(10,12),(16,21)]
     * Period Stay = [(9,10)]
     * Partition: valid period stay
     * Expected to 2.1
     */


    @Test
    @DisplayName("CalculateTestCase6_valid period stay")
    void testCalculateConstructor_6_withValidPeriodStay()  {
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
        BigDecimal expectedValue = BigDecimal.valueOf(2.1);
        assertEquals(expectedValue,actualValue);
    }


    /**
     * CalculateTestcase #7
     * CarParkKind is STUDENT
     * BigDecimal NormalRate = 5
     * BigDecimal ReducedRate = 1
     * Normal Periods = [(8,10),(13,15)]
     * Reduced Periods = [(10,12)]
     * Period Stay = [(null,null)]
     * Partition: invalid period stay
     * Expected to IllegalArgumentException
     */
    @Test
    @DisplayName("CalculateTestCase7_invalid period stay as null")
    void testCalculateConstructor_7_withInValidPeriodStayAsNull()  {
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
        Period periodStay = null;
        Rate rate = new Rate(normalRate,reducedRate,kind,reducedPeriods,normalPeriods);
        BigDecimal actualValue = rate.calculate(periodStay);
        BigDecimal expectedValue = null;
        assertEquals(expectedValue,actualValue);
        try{
            System.out.println(expectedValue=actualValue);
        }catch (Exception e){
            System.out.println("expected value not equals actualValue");
        }

    }




}