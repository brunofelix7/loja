package br.com.casadocodigo.loja.util;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Component
public class FileSaver {
	
	@Autowired
	private AmazonS3Client s3;

	@Autowired
	private HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file){
		String realPath = request.getServletContext().getRealPath("/" + baseFolder);
		try{
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			return baseFolder + "/" + file.getOriginalFilename();
		}catch(IOException e){
			throw new RuntimeException();
		}
	}
	
	public String writeS3(String baseFolder, MultipartFile file){
		try{
			s3.putObject("casadocodigo", file.getOriginalFilename(), file.getInputStream(), new ObjectMetadata());
			return "http://localhost:9444/s3/casadocodigo/"	+ file.getOriginalFilename() + "?noAuth=true";
		}catch (AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unused")
	private final AmazonS3 s3client(){
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY");
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).withCredentials(new AWSStaticCredentialsProvider(credentials)).withPathStyleAccessEnabled(true).disableChunkedEncoding().build();
		s3Client.setEndpoint("http://localhost:9444/s3");
		return s3Client;
	}
}
