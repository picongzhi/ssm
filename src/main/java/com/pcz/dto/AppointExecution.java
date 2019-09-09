package com.pcz.dto;

import com.pcz.entity.Appointment;
import com.pcz.enums.AppointStateEnum;
import lombok.Data;

/**
 * @author picongzhi
 */
@Data
public class AppointExecution {
    private long bookId;
    private int state;
    private String stateInfo;
    private Appointment appointment;

    public AppointExecution() {
    }

    public AppointExecution(long bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public AppointExecution(long bookId, AppointStateEnum stateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }
}
