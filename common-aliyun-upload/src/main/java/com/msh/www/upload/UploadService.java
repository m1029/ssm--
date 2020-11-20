package com.msh.www.upload;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.msh.www.http.AxiosResult;
import com.msh.www.http.AxiosStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;


/**
 * 阿里云的文件上传（所需资料）
 * #endpoint=http://oss-cn-beijing.aliyuncs.com
 * #accessKeyId=LTAI4Fz9utroADEiqdCgkF9K
 * #accessKeySecret=X7nAFAw10dZAK5aeAXSGXY9vLtUM1E
 * #url=http://hellowordmsh.oss-cn-beijing.aliyuncs.com/
 * #backetName=hellowordmsh
 * #ext=jpg,png,jpeg
 * #size=1
 *
 *
 * @author dn26
 */
@Component
@PropertySource(value = {"classpath:upload.properties"})
public class UploadService {

    @Value("${endpoint}")
    private String endpoint;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;
    @Value("${backetName}")
    private String backetName;
    @Value("${url}")
    private String url;
    /**
     * 文件格式
     */
    @Value("${ext}")
    private String ext;
    /**
     * 文件大小  默认的是兆
     */
    @Value("${size}")
    private int size;

    public AxiosResult upload(InputStream inputStream, String fileName,long size) throws IOException {

        String[] split = ext.split(",");

        //拿到文件的后缀名 判断后端接收的文件格式是否符合jpg,png,jpeg  这三种格式
        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);

        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(buffer);

        BufferedImage read = ImageIO.read(inputStream1);

        if(Objects.isNull(read)){
            return AxiosResult.error(AxiosStatus.NOT_IMAGE);
        }

        if(!Arrays.asList(split).contains(StringUtils.getFilenameExtension(fileName))){
         return AxiosResult.error(AxiosStatus.EXT_ERROR);
     }

        //直接传过来图片大小 进行判断  返回给前端信息
        if(size/1024/1024>this.size){
            return AxiosResult.error(AxiosStatus.FILE_TOLONG);
        }
// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
// 上传网络流。
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(buffer);
        ossClient.putObject(backetName, fileName, inputStream2);
// 关闭OSSClient。
        ossClient.shutdown();
        return AxiosResult.success(url+fileName);
    }
}
