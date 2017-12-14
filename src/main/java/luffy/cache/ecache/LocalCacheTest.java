package luffy.cache.ecache;

/**
 * @author Luffy
 * @date 2017/8/11
 * @description todo
 */

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LocalCacheTest {


    /**
     * 看看到在20此循环中命中次数是17次，未命中3次，这是因为我们设定缓存的过期时间是写入后的8秒，
     * 所以20秒内会失效两次，另外第一次获取时缓存中也是没有值的，所以才会未命中3次，其他则命中。
     */
    public static void main(String[] args) throws Exception {
        //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer, Person> loadingCache
                //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                = CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置写缓存后8秒钟过期 然后重新load
                .expireAfterWrite(8, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(100)
                //设置要统计缓存的命中率
                .recordStats()
                //设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey()+","+notification.getValue()+","+notification.getCause());
                    }
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<Integer, Person>() {
                    @Override
                    public Person load(Integer key) throws Exception {
                        System.out.println("load person " + key);
                        Person person = new Person(1000,"luffy");
                        return person;
                    }
                });

        for (int i = 0; i < 20; i++) {
            //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
            Person person = null;
            try {
                person = loadingCache.get(1);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(person.toString());
            //休眠1秒
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("cache stats:");
        //最后打印缓存的命中率等 情况
        System.out.println(loadingCache.stats().toString());
    }



}


class Person {
    private int uid;
    private String name;

    public Person(int uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person = [uid=" + this.uid + ",name = " + name + "]";
    }
}


