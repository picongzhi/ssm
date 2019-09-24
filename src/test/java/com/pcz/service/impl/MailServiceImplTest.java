package com.pcz.service.impl;

import com.pcz.BaseTest;
import com.pcz.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MailServiceImplTest extends BaseTest {
    @Autowired
    private MailService mailService;

    @Test
    public void testSendSimpleMail() {
        mailService.sendSimpleMail("picongzhi@meituan.com", "test", "test");
    }
}
