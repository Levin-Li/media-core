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

package org.restcomm.media.control.mgcp.endpoint.notification;

import java.util.List;
import java.util.Queue;

import org.restcomm.media.control.mgcp.signal.BriefSignal;
import org.restcomm.media.control.mgcp.signal.TimeoutSignal;

/**
 * Action that executes the next pending Brief signal.
 * 
 * @author Henrique Rosa (henrique.rosa@telestax.com)
 *
 */
class ExecuteNextBriefSignalAction extends NotificationCenterAction {
    
    static final ExecuteNextBriefSignalAction INSTANCE = new ExecuteNextBriefSignalAction();
    
    ExecuteNextBriefSignalAction() {
        super();
    }

    @Override
    public void execute(NotificationCenterState from, NotificationCenterState to, NotificationCenterEvent event, NotificationCenterTransitionContext context, NotificationCenterFsm stateMachine) {
        final NotificationCenterContext globalContext = stateMachine.getContext();
        final List<TimeoutSignal> timeoutSignals = globalContext.getTimeoutSignals();
        final Queue<BriefSignal> briefSignals = globalContext.getPendingBriefSignals();
        
        // Check if there is any pending BR signal
        final BriefSignal signal = briefSignals.poll();

        // Update active brief signal
        globalContext.setActiveBriefSignal(signal);

        if(signal != null) {
            // Execute next pending BR signal
            final BriefSignalExecutionCallback callback = new BriefSignalExecutionCallback(signal, stateMachine);
            signal.execute(callback);
        } else if (timeoutSignals.isEmpty()){
            // There are no more signals (BR nor TO) to be executed. Move to IDLE state.
            stateMachine.fire(NotificationCenterEvent.ALL_SIGNALS_COMPLETED, context);
        }
    }

}
