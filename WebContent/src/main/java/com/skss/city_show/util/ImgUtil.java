package com.skss.city_show.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author wdp 图片处理工具
 */
public class ImgUtil {
	private static String basePath =Thread.currentThread().getContextClassLoader().getResource("").getPath();//获取当前类路径
	private static final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");/*时间格式对象*/
	private static final Random random=new Random();/*随机数对象*/
	private static  Logger logger=LoggerFactory.getLogger(ImgUtil.class);
	/**
	 * 将CommonsMultipartFile转换成File类 是为了在测试的时候就立即初始化
	 * @param commonsMultipartFile
	 * @return newFile
	 */
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile commonsMultipartFile){
		File newFile=new File(commonsMultipartFile.getOriginalFilename());//获取原始文件名
		try {
			commonsMultipartFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		}
		
		return newFile;
		
	}
	
	/**
	 * 处理缩略图，并返回新生成的图片的相对路径
	 * @param saveTargetFileAddr 在服务器上保存文件的相对地址
	 * @return relativeAddr 相对路径
	 * 
	 */
	// CommonsMultipartFile spring自带的文件处理对象
	public static String generateThumbnail(InputStream thumbnailInputSream,String fileName,String saveTargetFileAddr){/*CommonsMultipartFile  spring自带的文件处理对象*/
		String realFileName=getRandomFileName();
		String extensionFileName=getFileExtension(fileName);
		makeDirPth(saveTargetFileAddr);
		String relativeAddr=saveTargetFileAddr+realFileName+extensionFileName;/*相对路径*/
		logger.debug("上传文件存储在服务器上的相对路径是："+relativeAddr);
		File newFileAbsolutelyPath=new File(PathUtil.getImgBasePath()+relativeAddr);/*上传文件存储在服务器上的绝对路径*/
		logger.debug("上传文件存储在服务器上的绝对路径是："+newFileAbsolutelyPath);
		try {
			Thumbnails.of(thumbnailInputSream)/* 需要打水印和压缩的图片 */
					.size(200, 200)
					.watermark(Positions.CENTER_RIGHT, /* 水印放在图片里的右下角 */
							ImageIO.read(new File(basePath + "/watermark.jpg")), /* 读取水印图片流 */
							0.5f)/* 水印图片透明度 */
					.outputQuality(0.8)/* 压缩程度 */
					.toFile(newFileAbsolutelyPath);/* 处理后输出位置 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
		logger.error(e.toString());
			e.printStackTrace();
		}
		return relativeAddr;/*此处返回相对路径是为了程序迁移到其他服务器上后依然能读到图片*/
			
	}
	/**
	 * 创建文件上传后保存在服务器上的路径
	 * @param saveTargetFileAddr
	 */
	private static void makeDirPth(String saveTargetFileAddr) {/*saveTargetFileAddr是目标文件的相对路径*/
		// TODO Auto-generated method stub
		String getsaveTargetFileAbsolutlyPath=PathUtil.getImgBasePath()+saveTargetFileAddr;
		File dirPath=new File(getsaveTargetFileAbsolutlyPath);
		if(!dirPath.exists()){
			dirPath.mkdirs();	
		}
	}
	/**
	 * 获取输入文件名的扩展名
	 * @param commonsMultipartFile
	 * @return originalFileName.substring(originalFileName.lastIndexOf(".")) 
	 */
	public static String getFileExtension(String fileName) {
		// TODO Auto-generated method stub
		
		String suffixName=fileName.substring(fileName.indexOf("."));/*截取后缀*/
		return suffixName;
	}
	/**
	 * 生成随即文件名，当前年月日时分秒+五位随机数
	 * @return nowTimeStr+randomNum;
	 */
	public static String getRandomFileName() {
		// TODO Auto-generated method stub
		//获取随即的5位数  10000-99999
		int randomNum=random.nextInt(89999)+10000;
		String nowTimeStr=simpleDateFormat.format(new Date());
		return nowTimeStr+randomNum;
	}
	
	/**
	 * storePath可能是文件路径或是目录路径，
	 * 如果是文件路径则删除文件，
	 * 如果是目录路径则删除目录下的所有文件。
	 * @param storePath 数据库里的路径
	 */
	public static void  deleteImgFile(String storePath) {
		File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
		System.out.println("PathUtil.getImgBasePath()+storePath=========="+PathUtil.getImgBasePath()+storePath);
		String imgPath=PathUtil.getImgBasePath()+storePath;
		if(!imgPath.isEmpty()) {
		//if(fileOrPath.exists()) {
			System.out.println("fileOrPath参数存在");
		if(fileOrPath.isDirectory()) {//如果是目录返回true
			File files[] =fileOrPath.listFiles();//将目录下的所有文件放入数组
			int i=-1;
			for( i=0;i<files.length;i++) {
				System.out.println("删除文件或者文件夹"+files[i].getName());
				files[i].delete();//递归删除
				System.out.println("删除成功"+files[i]);
			}
			/*for (File f:files) {
			f.delete()	;
			}*/		
		}
		}
		System.out.println("fileOrPath不是目录");
		fileOrPath.delete();
		System.out.println("文件删除成功");
	}
	
	
	
	
	
/*	public static void main(String[] args) {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
				//.getPath();
							 //* 获取classpath的绝对路径 通过线程逆推到类加载器，通过类加载器得到资源，通过资源得到路径
							 
		try {
			Thumbnails.of(new File("D:/apache-tomcat-8.0.47/Img/xiaohuangren.jpg")) //需要打水印和压缩的图片 
					.size(200, 200)
					.watermark(Positions.CENTER_RIGHT,  //水印放在图片里的右下角 
							null, //ImageIO.read(new File(basePath + "/watermark.jpg")),  //读取水印图片流 
							//ImageIO.read(new File(basePath +)),  //读取水印图片流
							0.5f) //水印图片透明度 
					.outputQuality(0.8) //压缩程度 
					.toFile(new File("D:/apache-tomcat-8.0.47/Img/watermark_xiaohuangren.jpg")); //处理后输出位置 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

}
