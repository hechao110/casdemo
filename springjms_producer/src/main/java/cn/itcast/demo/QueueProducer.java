package cn.itcast.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

//发送文本消息  点对点
@Component
public class QueueProducer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination queueTextDestination;//发送的列表目的地
    public void sendTestMessage(final String text){
        jmsTemplate.send(queueTextDestination, new MessageCreator() {// new MessageCreator()发送的文本消息
            public Message createMessage(Session session) throws JMSException {

                return session.createTextMessage(text);
            }
        });
    }

}
