package www.gzhou.MyMessageQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: catKing.chen
 * @Date: 2020/8/5 14:05
 */

public class MinitorMq {
    /**
     * 监听
     * @param subscriber
     * @return
     */
    public void monitorMes(Subscriber subscriber){
        ArrayBlockingQueue<Message> arrayBlockingQueue =
                MessageQueImp.getOneInstance().takeMessage(subscriber);
        if (subscriber.isFlag() == true) {
            return;
        }
        if (arrayBlockingQueue != null)
        {
            //消息确认
            subscriber.setFlag(true);
            for (Message message : arrayBlockingQueue){
                if (message.getToName() == subscriber.getSubName())
                    System.out.println("我-"+subscriber.getSubName()+"收到消息：" + message);
            }
        }
    }
}
