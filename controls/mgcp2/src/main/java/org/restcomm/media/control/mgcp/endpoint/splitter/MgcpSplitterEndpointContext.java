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
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.restcomm.media.control.mgcp.endpoint.splitter;

import org.restcomm.media.component.audio.AudioSplitter;
import org.restcomm.media.component.oob.OOBSplitter;
import org.restcomm.media.control.mgcp.endpoint.EndpointIdentifier;
import org.restcomm.media.control.mgcp.endpoint.MgcpEndpointContext;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com)
 *
 */
public class MgcpSplitterEndpointContext extends MgcpEndpointContext {

    private final AudioSplitter splitter;
    private final OOBSplitter oobSplitter;

    public MgcpSplitterEndpointContext(EndpointIdentifier endpointId, AudioSplitter splitter, OOBSplitter oobSplitter) {
        super(endpointId, null);
        this.splitter = splitter;
        this.oobSplitter = oobSplitter;
    }

    AudioSplitter getSplitter() {
        return splitter;
    }

    OOBSplitter getOobSplitter() {
        return oobSplitter;
    }

}