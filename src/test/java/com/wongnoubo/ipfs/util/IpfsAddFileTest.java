package com.wongnoubo.ipfs.util;

import com.wongnoubo.ipfs.BaseJunitTest;

import org.junit.Test;
import java.io.File;
import java.io.IOException;


public class IpfsAddFileTest extends BaseJunitTest{
    @Test
    public void testIpfsAddFile(){
        try {
            File file = new File("src/main/resources/ScreenToGif.exe");
            IpfsAddFile.ipfsAddFile(file);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("test");
    }
}
