package com.linkalma.utils.cipher;

import org.apache.commons.codec.digest.DigestUtils;

public class Cipher 
{
	
	private final static String SALT_PREFIX="xjjufjgTFTF!#$%^&123";
	private final static String SALT_SUFFIX="FGHOIhausfda#$%^&865";
	
	public static String DIGEST_PASSWORD(String pass)
	{
		return DigestUtils.sha512Hex(SALT_PREFIX+pass+SALT_SUFFIX);
	}
	
}
