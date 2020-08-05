package www.gzhou.MyMessageQueue;

/**
 * 生产消息
 */
public class Publish extends Thread{

    /**
     * 消息体
     */
    private Message message;

    /**
     * 主题
     */
    private Topic topic;

    public Publish(Message message, Topic topic) {
        this.message = message;
        this.topic = topic;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * 生产消息
     */
    public void sed(){
        new Thread(()->{
            MessageQueImp.getOneInstance().PutMessage(topic, message);
        }).start();
    }


}
