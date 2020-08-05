package www.gzhou.MyMessageQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 订阅者
 */
public class Subscriber extends Thread{

    /**
     * 主题名字
     */
    private String topicName;

    /**
     * 订阅者名字
     */
    private String subName;

    /**
     * 用于消息确认
     */
    private static boolean flag;

    /**
     * 修改状态
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取状态
     * @return
     */
    public boolean isFlag() {
        return flag;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    /**
     * 订阅主题
     */
    public void SubscriTopic(String topicName, Subscriber subscriber){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MessageQueImp.getOneInstance().register(topicName, subscriber);
            }
        }).start();
    }

    /**
     * 取消关注
     */
    public void TakeOffTopic(String topicName, Subscriber subscriber){
        MessageQueImp.getOneInstance().Takeoff(topicName, subscriber);
    }


}
