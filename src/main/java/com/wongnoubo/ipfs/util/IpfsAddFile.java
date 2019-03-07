package com.wongnoubo.ipfs.util;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 上传文件到ipfs网络
 */

@Component
public class IpfsAddFile {

    private static Logger logger = Logger.getLogger(IpfsAddFile.class);

    private static IpfsAddFile ipfsAddFile;
    @PostConstruct
    public void init(){
        ipfsAddFile=this;
    }

    public static void ipfsAddFile(File file) throws IOException{
        IPFS ipfs = new IPFS(Consts.IPFS_PUBLIC_API);
        logger.info("connected");
        logger.info("id: " + ipfs.id());

        // 上传文件
        //File file = new File("src/main/resources/ScreenToGif.exe");
        NamedStreamable.FileWrapper files = new NamedStreamable.FileWrapper(file);
        MerkleNode node = ipfs.add(files).get(0);
        String hash = node.hash.toString();
        System.out.println(hash);
        logger.info("hash:"+hash);
    }
}
