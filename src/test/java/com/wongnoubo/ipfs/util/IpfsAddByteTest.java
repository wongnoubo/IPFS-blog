package com.wongnoubo.ipfs.util;

import com.wongnoubo.ipfs.BaseJunitTest;

import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class IpfsAddByteTest extends BaseJunitTest{
    @Test
    public void testIpfsAddByte(){
        byte[] bytes = "Hello from JNU\n".getBytes();
        try {
            IpfsAddByte.ipfsAddByte(bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
