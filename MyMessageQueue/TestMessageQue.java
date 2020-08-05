package www.gzhou.MyMessageQueue;

/**
 * @Author: catKing.chen
 * @Date: 2020/8/5 11:25
 */

public class TestMessageQue {
    public static void main(String[] args) {
        /**
         * 主题
         */
        Topic topic = new Topic("test1",1);
        /**
         * 消息
         * int num, String message, int type
         */
        Message message = new Message(1,"mess1-0", 1,"订阅者1");

        /**
         * 发布者
         */
        Publish publish = new Publish(message,topic);
        publish.sed();


        Topic topic1 = new Topic("test2",1);
        Message message1 = new Message(1,"mess2-0", 1,"订阅者2");
        Publish publish1 = new Publish(message1,topic1);

        publish1.sed();


        MinitorMq minitorMq1 = new MinitorMq();
        MinitorMq minitorMq2 = new MinitorMq();

        /**
         * 订阅者1
         */
        Subscriber subscriber1 = new Subscriber();
        Subscriber subscriber2 = new Subscriber();
        subscriber1.setSubName("订阅者1");
        subscriber1.setFlag(false);
        subscriber1.SubscriTopic("test1",subscriber1);

        while (true){
            minitorMq1.monitorMes(subscriber1);
            if(subscriber1.isFlag() == true)
                break;
        }


        /**
         * 订阅者2
         */
        subscriber2.setSubName("订阅者2");
        subscriber2.setFlag(false);
        subscriber2.SubscriTopic("test2",subscriber2);

        while (true){
            minitorMq2.monitorMes(subscriber2);
            if(subscriber2.isFlag() == true)
                break;
        }


    }
}
