package com.siscia.bravofly;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.siscia.bravofly.SingleItem;
import com.siscia.bravofly.Recepit;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSingleItemNoTax()
    {
    	SingleItem s = new SingleItem("Choccolate", 100*100, false, false);
	assertEquals( 100*100, s.getPrice() );
	assertEquals( 0, s.getTaxOnItem() );
    }

    public void testSingleItemSalesTax()
    {
    	SingleItem s = new SingleItem("Music CD", 100*100, true, false);
	assertEquals(10 * 100, s.getTaxOnItem());
    }

    public void testSingleItemImportTax()
    {
	SingleItem s = new SingleItem("Imported Choccolate", 100*100, false, true);
	assertEquals( (int)(5 * 100), s.getTaxOnItem() );
    }

    public void testSingleItemImportAndSalesTax()
    {
	SingleItem s = new SingleItem("Imported Music CD", 100 * 100, true, true);
	assertEquals( (int)(15 * 100), s.getTaxOnItem());
    }

    public void testRecepit1()
    {
	Recepit r = new Recepit();
	r.addItem(new SingleItem("Book", 1249, false, false));
	r.addItem(new SingleItem("Music CD", 1649, true, false));
	r.addItem(new SingleItem("Choccolate bar", 85, false, false));
	assertEquals(2983, r.getTotalPrice());
	assertEquals(165, r.getTotalTax());
    }

    public void testRecepit2()
    {
	Recepit r = new Recepit();
	r.addItem(new SingleItem("Imported Box of Choccolate", 1000, false, true));
	r.addItem(new SingleItem("Imported Bottle of Perfume", 4750, true, true));
	assertEquals(765, r.getTotalTax());
	assertEquals(5750, r.getTotalPrice());
    }

    public void testRecepit3()
    {
	Recepit r = new Recepit();
	r.addItem(new SingleItem("Importe Bottle of Perfume", 2799, true, true));
	r.addItem(new SingleItem("Bottle of Perfume", 1899, true, false));
	r.addItem(new SingleItem("Headache Pills", 975, false, false));
	r.addItem(new SingleItem("Imported choccolare", 1125, false, true));
	assertEquals(670, r.getTotalTax());
	assertEquals(6798, r.getTotalPrice());
    }

}
