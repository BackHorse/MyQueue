package www.gzhou.MyMessageQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消息队列
 */
public interface MessageQue {

    /**
     * 消费者关注主题
     */
    void register(String TopicName, Subscriber subscriber);

    /**
     * 取消关注
     */
    void Takeoff(String topicName, Subscriber subscriber);

    /**
     * 生产者送消息
     */
    void PutMessage(Topic topic, Message message);

    /**
     * 取消息
     * @param subscriber
     * @return
     */
    ArrayBlockingQueue<Message> takeMessage(Subscriber subscriber);


}
