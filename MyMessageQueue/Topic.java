package www.gzhou.MyMessageQueue;

public class Topic {
    /**
     * 主题名称
     */
    private String topic_name;

    /**
     * 请求队列数
     */
    private int queueNum;

    public Topic(String topic_name, int queueNum) {
        this.topic_name = topic_name;
        this.queueNum = queueNum;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public int getQueueNum() {
        return queueNum;
    }

    public void setQueueNum(int queueNum) {
        this.queueNum = queueNum;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topic_name='" + topic_name + '\'' +
                ", queueNum=" + queueNum +
                '}';
    }
}
