package com.pcz.entity;

import lombok.Data;

/**
 * @author picongzhi
 */
@Data
public class Appointment {
    private long bookId;
    private long studentId;
    private Data appointTime;
    private Book book;
}
