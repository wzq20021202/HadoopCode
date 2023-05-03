package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author 30337
 */
public class HBaseJDBCTest{

    private static Connection con;
    public static Connection getCon(){
        try {
            if(con==null){
                Configuration config = new Configuration();
                config.set("hbase.zookeeper.quorum","hadoop201,hadoop202,hadoop203");
                config.set("hbase.zookeeper.properties.clientPort","2181");
                con = ConnectionFactory.createConnection(config);
                System.out.println("conneted!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        getCon();
    }
}

