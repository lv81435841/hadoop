

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;

public class HDFSTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://user1:9820");
        FileSystem fs = FileSystem.get(conf);
        testFileUpload(fs);
        fs.close();
    }
    public static void testFileUpload(FileSystem fs) throws IOException{
        Path localPath=new Path("C:\\Users\\80621\\Desktop\\words\\");
        Path hdfsPath=new Path("/words");
        fs.copyFromLocalFile(localPath,hdfsPath);
        System.out.println("上传成功");
    }
}