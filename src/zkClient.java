import java.io.IOException;
 
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
 
public class zkClient {
 
    public static void main(String[] args) throws Exception{
        Watcher wh = new Watcher(){
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.toString());
            }
        };
        ZooKeeper zk = new ZooKeeper("localhost:2181",30000,wh);
        System.out.println("=========�����ڵ�===========");
        zk.create("/sharpxiajun", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.err.println("=============�鿴�ڵ��Ƿ�װ�ɹ�===============");
        System.out.println(new String(zk.getData("/sharpxiajun", false, null)));
        System.out.println("=========�޸Ľڵ������==========");
        zk.setData("/sharpxiajun", "sharpxiajun130901".getBytes(), -1);
        System.out.println("========�鿴�޸ĵĽڵ��Ƿ�ɹ�=========");
        System.out.println(new String(zk.getData("/sharpxiajun", false, null)));
        System.out.println("=======ɾ���ڵ�==========");
        zk.delete("/sharpxiajun", -1);
        System.out.println("==========�鿴�ڵ��Ƿ�ɾ��============");
        System.out.println("�ڵ�״̬��" + zk.exists("/sharpxiajun", false));
        zk.close();
    }
 
}