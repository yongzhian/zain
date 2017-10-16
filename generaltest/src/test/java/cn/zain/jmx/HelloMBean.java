package cn.zain.jmx;

/**
 * Standard MBean
 * 必须每一个MBean定义一个接口，而且这个接口的名字必须是其被管理的资源的对象类的名称后面加上”MBean”
 * Created by Zain on 2017/10/12.
 */
public interface HelloMBean {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}
