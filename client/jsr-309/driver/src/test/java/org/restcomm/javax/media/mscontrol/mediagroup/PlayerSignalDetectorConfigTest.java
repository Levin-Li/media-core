/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
 * by the @authors tag. 
 *  
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *  
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.restcomm.javax.media.mscontrol.mediagroup;

import javax.media.mscontrol.MediaConfig;
import javax.media.mscontrol.mediagroup.Player;
import javax.media.mscontrol.mediagroup.signals.SignalDetector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restcomm.javax.media.mscontrol.mediagroup.PlayerSignalDetectorConfig;

import static org.junit.Assert.*;

/**
 *
 * @author kulikov
 */
public class PlayerSignalDetectorConfigTest {

    private MediaConfig cfg = null;
    
    public PlayerSignalDetectorConfigTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        cfg = new PlayerSignalDetectorConfig().getConfig();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getConfig method, of class PlayerSignalDetectorConfig.
     */
    @Test
    public void testGetConfig() {
        assertTrue(cfg.getSupportedFeatures().getSupportedParameters().contains(Player.MAX_DURATION));
        assertTrue(cfg.getSupportedFeatures().getSupportedParameters().contains(SignalDetector.MAX_DURATION));
    }

}
