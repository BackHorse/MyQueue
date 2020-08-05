package www.gzhou.MyMessageQueue;

import java.io.Serializable;

/**
 * 消息体
 */
public class Message implements Serializable {
    /**
     * 消息序号
     */
    private int num;

    /**
     * 消息
     */
    private String message;

    /**
     * 消息类型
     */
    private int type;

    /**
     * 接收者
     */
    private String toName;


    public Message(int num, String message, int type, String toName) {
        this.num = num;
        this.message = message;
        this.type = type;
        this.toName = toName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Message{" +
                "num=" + num +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
