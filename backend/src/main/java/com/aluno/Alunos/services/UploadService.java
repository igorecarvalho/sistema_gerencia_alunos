package com.aluno.Alunos.services;

import com.aluno.Alunos.model.Upload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Calendar;

@Service
@CrossOrigin(origins = "*")
public class UploadService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${scitc.upload.src}")
    private String rootPath;

    @Value("${scitc.upload.host}")
    private String uploadhost;

    @CrossOrigin
    public String uploadFile(MultipartFile file) {

        String filename = file.getOriginalFilename();
        String name = filename.substring(0, filename.indexOf("."));
        String suffix = filename.substring(filename.lastIndexOf("."));

        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1));

        File descFile = new File(rootPath + File.separator + dateDirs + File.separator + filename);

        int i = 1;
        String newFilename = filename;

        while(descFile.exists()) {
            newFilename = name + "(" + i +")" + suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath+File.separator + newFilename);
            i++;
        }

        if(!descFile.getParentFile().exists()) {
            descFile.getParentFile().mkdirs();
        }

        try {

            file.transferTo(descFile);
        } catch (Exception e) {

            e.printStackTrace();
            logger.error("ERROR，cause:{}",e);
        }

        String fileUrl = "../../../uploads/" + dateDirs + "/" + newFilename;
//        String fileUrl = "/img/" + newFilename;
        return  fileUrl;
    }
}
