/**
 * 
 */
package com.linkalma.bo;

import org.springframework.ui.Model;

import com.linkalma.dto.UploadedFile;

/**
 * @author KENIL
 *
 */
public interface IFileUploadBO {

	public Model uploadFile(UploadedFile uploadedFile, String destination, Model model);
}
