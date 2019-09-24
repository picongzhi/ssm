package com.pcz.service;

/**
 * @author picongzhi
 */
public interface MailService {
    /**
     * 发送简单文本邮件
     *
     * @param to      接收方
     * @param subject 主题
     * @param content 内容
     * @param cc      抄送
     */
    void sendSimpleMail(String to, String subject, String content, String... cc);
}
