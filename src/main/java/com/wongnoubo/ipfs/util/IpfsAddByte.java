package com.wongnoubo.ipfs.util;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * 添加字节到ipfs网络
 */

@Component
public class IpfsAddByte {
    private static Logger logger = Logger.getLogger(IpfsAddByte.class);

    private static IpfsAddByte ipfsAddByte;
    @PostConstruct
    public void init(){
        ipfsAddByte=this;
    }

    public static void ipfsAddByte(byte[] bytes) throws IOException{
        IPFS ipfs = new IPFS(Consts.IPFS_PUBLIC_API);
        logger.info("connected");
        logger.info("id: "+ipfs.id());

        // 上传字节流
       // byte[] byte = "Hello from IPFS Gateway Checker\n".getBytes();
        NamedStreamable.ByteArrayWrapper file = new NamedStreamable.ByteArrayWrapper(bytes);
        MerkleNode node = ipfs.add(file).get(0);
        String hash = node.hash.toString();
        logger.info("hash: "+hash);

        // 下载 https://ipfs.infura.io/ipfs/Qmaisz6NMhDB51cCvNWa1GMS7LU1pAxdF4Ld6Ft9kZEP2a
        Multihash CID = Multihash.fromBase58(hash);
        byte[] content = ipfs.cat(CID);
        logger.info("content: "+new String(content));
    }
}
