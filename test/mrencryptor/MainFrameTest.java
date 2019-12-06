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
        assertEquals("hQL3Lw8NmyoeOibqbfTlOQ==", m.encrypt("Hello world!"));
    }
    
    @Test
    public void testEncrypt2(){
        assertEquals("m9GT+cYmznVH9wjgDZz3v0YZ5AhOq+KRSPEj1i5b/uI=", m.encrypt("Fire away Fire away"));
    }
    
    @Test
    public void testEncrypt3(){
        assertEquals("y9kex6FsYD2aKt43tdPSbw==", m.encrypt("(3+3)=7?"));
    }
    
    @Test
    public void testDecrypt1(){
        assertEquals("Send the email.", m.decrypt("961sJZ+W+WSKEkcuM+UvzA=="));
    }
    
    @Test
    public void testDecrypt2(){
        assertEquals("This test has passed", m.decrypt("zcyJlFVNmKExlLnfF6pVerrc6zY+LUP4alWP7F7c8FE="));
    }
    
    @Test
    public void testDecrypt3(){
        assertEquals("(3+3)=6!", m.decrypt("0HGtic5xkCPlzO32Zhs7Wg=="));
    }
}
