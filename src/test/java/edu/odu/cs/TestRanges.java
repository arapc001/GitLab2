package edu.odu.cs;

import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test of the Ranges class
 */
public class TestRanges {

    double precision = 0.001;

    @Test
    public void testConstructor() {
        Ranges ranges = new Ranges(1.0, 100.0);
        assertThat(ranges.sum(), closeTo(99.0, precision));

        Interval[] expected = { new Interval(1.0, 100.0) };
        assertThat (ranges, contains(expected)); // checks ranges.iterator()
    }
    @Test
    public void testRemove() {
        Ranges ranges = new Ranges(0.0, 10.0);
        Interval toRemove = new Interval(5.0, 8.0);
        
        ranges.remove(toRemove);
        
        assertThat(ranges.sum(), closeTo(7.0, precision));
        
        Interval expected1stHalf =  new Interval(0.0, 5.0) ;
        Interval expected2ndHalf =  new Interval(8.0, 10.0) ;
  
        
        assertThat(ranges, contains(expected1stHalf,expected2ndHalf));
      
    }
	

}