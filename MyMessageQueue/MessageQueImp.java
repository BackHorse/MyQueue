package www.gzhou.MyMessageQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: catKing.chen
 * @Date: 2020/8/4 23:23
 */

public class MessageQueImp implements MessageQue {

    /**
     * 主题与消息集合
     */
    private volatile static ConcurrentHashMap<String, ArrayBlockingQueue<Message>> concurrentHashMap;

    /**
     * 主题名字和订阅者
     */
    private volatile static ConcurrentHashMap<String,String> conHashMapSub;

    /**
     * 假设最多可以存储100条消息
     */
    private ArrayBlockingQueue<Message> arrayBlockingQueue;

    /**
     * 单例模式
     */
    private volatile static MessageQueImp messageQueImp;

    public MessageQueImp() {
        arrayBlockingQueue = new ArrayBlockingQueue<>(100);
        conHashMapSub = new ConcurrentHashMap<>();
        concurrentHashMap = new ConcurrentHashMap<>();
    }

    /**
     * 注册
     * @param topicName
     * @param subscriber
     */
    @Override
    public void register(String topicName, Subscriber subscriber) {

        conHashMapSub.put(subscriber.getName(), topicName);
        // System.out.println("大小："+conHashMapSub.size());
    }

    /**
     * 注销
     * @param topicName
     * @param subscriber
     */
    @Override
    public void Takeoff(String topicName, Subscriber subscriber) {
        conHashMapSub.remove(subscriber.getName(), topicName);
    }

    /**
     * 发布消息
     * @param topic
     * @param message
     */
    @Override
    public void PutMessage(Topic topic, Message message) {
        arrayBlockingQueue.add(message);
        concurrentHashMap.put(topic.getTopic_name(), arrayBlockingQueue);
        // System.out.println("大小：" + concurrentHashMap.size());
    }

    /**
     * 取出消息
     * @param subscriber
     * @return
     */
    @Override
    public ArrayBlockingQueue<Message> takeMessage(Subscriber subscriber) {
        String string = conHashMapSub.get(subscriber.getName());
        if (string != null && string.trim() != "")
        {
            ArrayBlockingQueue<Message> arrayBlockingQueue = concurrentHashMap.get(string);
            if (arrayBlockingQueue != null) {
                return arrayBlockingQueue;
            }
        }
        return null;
    }

    /**
     * 单例模式
     * @return
     */
    public static MessageQue getOneInstance() {
        if(messageQueImp == null){
            synchronized (MessageQueImp.class){
                if(messageQueImp == null){
                    messageQueImp = new MessageQueImp();
                }
            }
        }
        return messageQueImp;
    }
}
