package luffy.helloworld;

import com.alibaba.fastjson.JSON;

/**
 * Created by luffy on 2017/7/12.
 */
public class Fruit {
    int id;
    String name;
    int num;

    public Fruit() {
    }

    public Fruit(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
