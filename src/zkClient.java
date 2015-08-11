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
        System.out.println("=========创建节点===========");
        zk.create("/sharpxiajun", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.err.println("=============查看节点是否安装成功===============");
        System.out.println(new String(zk.getData("/sharpxiajun", false, null)));
        System.out.println("=========修改节点的数据==========");
        zk.setData("/sharpxiajun", "sharpxiajun130901".getBytes(), -1);
        System.out.println("========查看修改的节点是否成功=========");
        System.out.println(new String(zk.getData("/sharpxiajun", false, null)));
        System.out.println("=======删除节点==========");
        zk.delete("/sharpxiajun", -1);
        System.out.println("==========查看节点是否被删除============");
        System.out.println("节点状态：" + zk.exists("/sharpxiajun", false));
        zk.close();
    }
 
}