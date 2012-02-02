
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class GPXcalculatorTest {
	protected GPXcalculator tc;
	
	protected GPXtrk t0;
	protected GPXtrk t1;
	protected GPXtrk t2;
	protected GPXtrk t3;
	protected GPXtrk t4;
	protected GPXtrk t5;
	protected GPXtrk t6;
	protected GPXtrk t7;
	protected GPXtrk t8;
	protected GPXtrk t9;
	protected GPXtrk t10;
	protected GPXtrk t11;
	protected GPXtrk tn;
	
	public GPXcalculatorTest() {
		//setting up things for use later

		GPXcalculator tc = new GPXcalculator();
		
		//points
		GPXtrkpt nopt = null;
		Long time = (long) 100;
		Date date = new Date(time);
		GPXtrkpt p1 = new GPXtrkpt(0.0, 0.0, date);
		GPXtrkpt p2 = new GPXtrkpt(5.0, 5.0, date);
		GPXtrkpt p3 = new GPXtrkpt(3.0, -4.0, date);
		GPXtrkpt p4 = new GPXtrkpt(-1.0, -10.0, date);
		
		GPXtrkpt b1 = new GPXtrkpt(-90.0, 0.0, date);
		GPXtrkpt b2 = new GPXtrkpt(0.0, -180.0, date);
		GPXtrkpt b3 = new GPXtrkpt(90.0, 0.0, date);
		GPXtrkpt b4 = new GPXtrkpt(0.0, 180.0, date);
		
		GPXtrkpt o1 = new GPXtrkpt(-95.0, 0.0, date);
		GPXtrkpt o2 = new GPXtrkpt(0.0, -185.0, date);
		GPXtrkpt o3 = new GPXtrkpt(95.0, 0.0, date);
		GPXtrkpt o4 = new GPXtrkpt(0.0, 185.0, date);
		GPXtrkpt o5 = new GPXtrkpt(100, 190, date);
		GPXtrkpt o6 = new GPXtrkpt(100, -190, date);
		
		ArrayList<GPXtrkpt> arr = new ArrayList<GPXtrkpt>();
		arr.add(p1);
		arr.add(p2);
		arr.add(p3);
		arr.add(p4);
		
		//is null
		GPXtrkseg sn = null;
		
		//vanilla
		GPXtrkseg s1 = new GPXtrkseg(arr);
		
		//contains a null point
		ArrayList<GPXtrkpt> arr2 = new ArrayList<GPXtrkpt>();
		arr2.add(nopt);
		arr2.add(p2);
		arr2.add(p3);
		arr2.add(p4);
		GPXtrkseg s2 = new GPXtrkseg(arr2);
		
		//passed null array
		ArrayList<GPXtrkpt> arr3 = null;
		GPXtrkseg s3 = new GPXtrkseg(arr3);
		
		//has no points
		ArrayList<GPXtrkpt> arr4 = new ArrayList<GPXtrkpt>();
		GPXtrkseg s4 = new GPXtrkseg(arr4);
		
		//has one point
		ArrayList<GPXtrkpt> arr5 = new ArrayList<GPXtrkpt>();
		arr5.add(p1);
		GPXtrkseg s5 = new GPXtrkseg(arr5);
		
		//has point on boundary (lat)
		ArrayList<GPXtrkpt> arr6 = new ArrayList<GPXtrkpt>();
		arr2.add(p1);
		arr2.add(p2);
		arr2.add(p3);
		arr2.add(b1);
		GPXtrkseg s6 = new GPXtrkseg(arr6);
		
		//has point on boundary (lat)
		ArrayList<GPXtrkpt> arr7 = new ArrayList<GPXtrkpt>();
		arr2.add(p1);
		arr2.add(p2);
		arr2.add(p3);
		arr2.add(o1);
		GPXtrkseg s7 = new GPXtrkseg(arr7);
		
		//has point on boundary (lon)
		ArrayList<GPXtrkpt> arr8 = new ArrayList<GPXtrkpt>();
		arr2.add(p1);
		arr2.add(p2);
		arr2.add(p3);
		arr2.add(b2);
		GPXtrkseg s8 = new GPXtrkseg(arr8);
		
		//has point over boundary (lon)
		ArrayList<GPXtrkpt> arr9 = new ArrayList<GPXtrkpt>();
		arr2.add(p1);
		arr2.add(p2);
		arr2.add(p3);
		arr2.add(o2);
		GPXtrkseg s9 = new GPXtrkseg(arr9);
		
		//is null
		GPXtrk tn = null;
	
		//has no objects
		ArrayList<GPXtrkseg> sarr0 = new ArrayList<GPXtrkseg>();
		GPXtrk t0 = new GPXtrk("has no objects", sarr0);
		
		//passed null
		ArrayList<GPXtrkseg> sarr = null;
		GPXtrk t1 = new GPXtrk("passed null", sarr);
		
		//vanilla
		ArrayList<GPXtrkseg> sarr2 = new ArrayList<GPXtrkseg>();
		sarr2.add(s1);
		GPXtrk t2 = new GPXtrk("vanilla", sarr2);
		
		//contains null point
		ArrayList<GPXtrkseg> sarr3 = new ArrayList<GPXtrkseg>();
		sarr3.add(s1);
		sarr3.add(s2);
		GPXtrk t3 = new GPXtrk("contains null point", sarr3);
		
		//contains seg with null array
		ArrayList<GPXtrkseg> sarr4 = new ArrayList<GPXtrkseg>();
		sarr2.add(s3);
		GPXtrk t4 = new GPXtrk("no points", sarr4);
		
		//contains seg with no points
		ArrayList<GPXtrkseg> sarr5 = new ArrayList<GPXtrkseg>();
		sarr5.add(s4);
		GPXtrk t5 = new GPXtrk("empty points", sarr5);
		
		//has seg with only one point
		ArrayList<GPXtrkseg> sarr6 = new ArrayList<GPXtrkseg>();
		sarr6.add(s5);
		GPXtrk t6 = new GPXtrk("one point", sarr6);
		
		//has seg with lat on bound
		ArrayList<GPXtrkseg> sarr7 = new ArrayList<GPXtrkseg>();
		sarr7.add(s6);
		GPXtrk t7 = new GPXtrk("passed null", sarr7);
		
		//has seg with lat over bound
		ArrayList<GPXtrkseg> sarr8 = new ArrayList<GPXtrkseg>();
		sarr7.add(s7);
		GPXtrk t8 = new GPXtrk("passed null", sarr8);
		
		//has seg with lon on bound
		ArrayList<GPXtrkseg> sarr9 = new ArrayList<GPXtrkseg>();
		sarr9.add(s8);
		GPXtrk t9 = new GPXtrk("passed null", sarr9);
		
		//has seg with lat over bound
		ArrayList<GPXtrkseg> sarr10 = new ArrayList<GPXtrkseg>();
		sarr10.add(s9);
		GPXtrk t10 = new GPXtrk("passed null", sarr10);
		
		//vanilla + one point + no points
		ArrayList<GPXtrkseg> sarr11 = new ArrayList<GPXtrkseg>();
		sarr11.add(s1);
		sarr11.add(s4);
		sarr11.add(s5);
		GPXtrk t11 = new GPXtrk("vanilla + one point + no points", sarr10);
		
	}
	
	//test if GPXtrak is null
	@Test
	public void testGPXtrknull() {
		assertEquals("GPXtrk was null", -1.0, tc.calculateDistanceTraveled(tn));
	}
	
	//test has no objects
	@Test
	public void testGPXtrkempty() {
		assertEquals("GPXtrk was null", -1.0, tc.calculateDistanceTraveled(t0));
	}
	
	//test null trkseg
	@Test
	public void testGPXtrksegnull() {
		assertEquals("GPXtrk was null", 0, tc.calculateDistanceTraveled(t1));
	}
	
	//test trkseg contains null point
	@Test
	public void testGPX() {
		assertEquals("GPXtrkseg had null point", 0, tc.calculateDistanceTraveled(t3));
	}
	
	//trkseg has null array (what is expected output?)
	@Test
	public void testGPXtrksegnullarray() {
		assertEquals("GPXtrkseg array was null", -1.0, tc.calculateDistanceTraveled(t4));
	}
	
	//trkseg has no points
	@Test
	public void testGPXtrksegnopoints() {
		assertEquals("GPXtrk was null", 0, tc.calculateDistanceTraveled(t5));
	}
	
	//trkseg has one point
	@Test
	public void testGPXtrkonepoint() {
		assertEquals("one point", 0, tc.calculateDistanceTraveled(t6));
	}
	
	//trkseg has lat on bound
	@Test
	public void testGPXtrkb1() {
		assertEquals("invalid point bounds - lat border", 0, tc.calculateDistanceTraveled(t7));
	}
	
	//trkseg has lat over bound
	@Test
	public void testGPXtrkb2() {
		assertEquals("invalid point bounds - lat over", 0, tc.calculateDistanceTraveled(t8));
	}
	
	//trkseg has lon on bound
	@Test
	public void testGPXtrkb3() {
		assertEquals("invalid point bounds - lon border", 0, tc.calculateDistanceTraveled(t9));
	}
	
	//trkseg has lat over bound
	@Test
	public void testGPXtrkb4() {
		assertEquals("invalid point bounds - lon over", 0, tc.calculateDistanceTraveled(t10));
	}
	
	//multiple segs: vanilla + one point + no points. Should equal just vanilla
	@Test
	public void testGPXtrkmultiple() {
		assertEquals("multple segs", tc.calculateDistanceTraveled(t2), tc.calculateDistanceTraveled(t11));
	}
}

