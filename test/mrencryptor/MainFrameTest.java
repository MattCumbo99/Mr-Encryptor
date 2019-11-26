/*
 * Copyright (C) 2019 Matthew Cumbo & Hunter Jasinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mrencryptor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class MainFrameTest {
    
    private MainFrame m;
    
    public MainFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        m = new MainFrame();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testEncrypt1(){
        assertEquals("+Phd/EbSanKDh3vwBdjj6g==", m.encrypt("Hello world!"));
    }
    
    @Test
    public void testEncrypt2(){
        assertEquals("8R8EeAk+s8rsmoR9aMcbe0Y2TSeeyGqgTt0VC46plOs=", m.encrypt("Fire away Fire away"));
    }
    
    @Test
    public void testEncrypt3(){
        assertEquals("RBR77jJ/6MQEYh+MYUED1A==", m.encrypt("(3+3)=7?"));
    }
    
    @Test
    public void testDecrypt1(){
        assertEquals("Send the email.", m.decrypt("25zWuhz4J6vScA+K9kbEcg=="));
    }
    
    @Test
    public void testDecrypt2(){
        assertEquals("This test has passed", m.decrypt("hQV4mB3BBtK2Enb5g+X3bkjmfvlCu8maH3oCsi7/JuY="));
    }
    
    @Test
    public void testDecrypt3(){
        assertEquals("(3+3)=6!", m.decrypt("dWwk4UO7zsgAXabtweX+Sg=="));
    }
}
