package com.Travel.butler.service;

import com.Travel.butler.common.RequestResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created on 2017/10/11.
 */
public interface FileService {

    public RequestResult uploadFile(MultipartFile uploadedFile, String filePath, String fileName);

    public RequestResult uploadFiles(MultipartFile[] uploadedFiles, String[] filePaths, String[] fileName);
}
